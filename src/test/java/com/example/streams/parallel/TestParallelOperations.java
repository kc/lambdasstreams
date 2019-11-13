package com.example.streams.parallel;

import org.junit.Test;

import java.util.concurrent.ForkJoinPool;
import java.util.function.Function;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class TestParallelOperations {

    @Test
    public void calculateSumOfNaturalNumbers() {
        int n = 100_000;
        System.out.println(format("Method", "Duration (µs)", "Sum"));
        System.out.println("---------------------------------------------------------");
        System.out.println(format("iterative", measure(this::iterative, n)));                           // no boxing, iterating and summing at once
        System.out.println(format("sequentialIterateLim", measure(this::sequentialIterateLim, n)));     // boxing/unboxing overhead; unknown stream size: difficult to divide
        System.out.println(format("parallelIterateLim", measure(this::parallelIterateLim, n)));         // idem, plus threading overhead
        System.out.println(format("sequentialIterate", measure(this::sequentialIterate, n)));           // boxing/unboxing overhead; known stream size
        System.out.println(format("parallelIterate", measure(this::parallelIterate, n)));               // idem, plus threading overhead
        System.out.println(format("sequentialRange", measure(this::sequentialRange, n)));               // known size, primitives: no boxing, better to divide
        System.out.println(format("parallelRange", measure(this::parallelRange, n)));                   // idem, plus parallel. good candidate for tasks large enough!
        System.out.println(format("accumulatedRange", measure(this::accumulatedRange, n)));             // must be synchronized, therefore can become slow
        System.out.println(format("forkJoin", measure(this::forkJoin, n)));                             // splitting, forking and joining is costly, executing is pretty good
    }

    private String format(String h1, String h2, String h3) {
        return String.format("%-20s %15s %20s", h1, h2, h3);
    }

    private String format(String method, Result result) {
        return format(method, Long.toString(result.duration), Long.toString(result.sum));
    }

    private long iterative(long n) {
        long result = 0;
        for (long i = 1; i <= n; i++) {
            result += i;
        }
        return result;
    }

    private long sequentialIterateLim(long n) {
        return Stream.iterate(1L, i -> i + 1L)
                .limit(n)
                .reduce(Long::sum)
                .orElse(0L);
    }

    private long sequentialIterate(long n) {
        return Stream.iterate(1L, i -> i <= n, i -> i + 1L)
                .reduce(Long::sum)
                .orElse(0L);
    }

    private long parallelIterateLim(long n) {
        return Stream.iterate(1L, i -> i + 1L)
                .limit(n)
                .parallel()
                .reduce(Long::sum)
                .orElse(0L);
    }

    private long parallelIterate(long n) {
        return Stream.iterate(1L, i -> i <= n, i -> i + 1L)
                .parallel()
                .reduce(Long::sum)
                .orElse(0L);
    }

    private long sequentialRange(long n) {
        return LongStream.rangeClosed(1, n)
                .reduce(Long::sum)
                .orElse(0L);
    }

    private long parallelRange(long n) {
        return LongStream.rangeClosed(1, n)
                .parallel()
                .reduce(Long::sum)
                .orElse(0L);
    }

    private long accumulatedRange(long n) {
        Accumulator accumulator = new Accumulator.AtomicAccumulator();
        LongStream.rangeClosed(1, n)
                .parallel()
                .forEach(accumulator::add);
        return accumulator.getTotal();
    }

    public long forkJoin(long n) {
        long[] numbers = LongStream.rangeClosed(1, n).toArray();
        return new ForkJoinPool().invoke(new ForkJoinSumCalculator(numbers));
    }

    private static Result measure(Function<Long, Long> adder, long n) {
        long fastest = Long.MAX_VALUE;
        long sum = 0;
        for (int i = 0; i < 10; i++) {
            long start = System.nanoTime();
            sum = adder.apply(n);
            long duration = (System.nanoTime() - start) / 1_000;
            if (duration < fastest)
                fastest = duration;
        }

        return new Result(fastest, sum);
    }

}

class Result {
    final long duration;
    final long sum;

    Result(long duration, long sum) {
        this.duration = duration;
        this.sum = sum;
    }

    @Override public String toString() {
        return "duration (µs) = " + duration +
                " \t\tsum = " + sum;
    }
}

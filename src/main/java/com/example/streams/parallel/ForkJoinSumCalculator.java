package com.example.streams.parallel;

import java.util.concurrent.RecursiveTask;
import java.util.concurrent.atomic.AtomicInteger;

public class ForkJoinSumCalculator extends RecursiveTask<Long> {

    public static final long THRESHOLD = 12_500;

    private final long[] numbers;
    private final int start;
    private final int end;
    private static AtomicInteger callNumber = new AtomicInteger(0);
    private final int version;

    public ForkJoinSumCalculator(long[] numbers) {
        this(numbers, 0, numbers.length);
    }

    private ForkJoinSumCalculator(long[] numbers, int start, int end) {
        this.version = callNumber.getAndIncrement();
        // System.out.printf("callNumber  %4d start =  %d  einde = %d\n", version, start, end);
        this.numbers = numbers;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        int length = end - start;
        if (length <= THRESHOLD) {
            long result = computeSequentially();
            // System.out.printf("callNumber  %4d start =  %d  einde = %d  --> result = %d\n", version, start, end, result);
            return result;
        }
        ForkJoinSumCalculator leftTask = new ForkJoinSumCalculator(numbers, start, start + length / 2);
        leftTask.fork();
        ForkJoinSumCalculator rightTask = new ForkJoinSumCalculator(numbers, start + length / 2, end);
        Long rightResult = rightTask.compute();
        Long leftResult = leftTask.join();
        return leftResult + rightResult;
    }

    private long computeSequentially() {
        long sum = 0;
        for (int i = start; i < end; i++) {
            sum += numbers[i];
        }
        return sum;
    }

}
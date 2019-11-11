package com.example.lambdas.calculator;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CalculatorTest {

    @Test
    public void test() {
        Double result =
                Calculator.of(5d)
                        .map(v -> v + 5)
                        .map(v -> v * 2)
                        .map(v -> v / 4)
                        .result();

        assertThat(result, is(5.0));
    }

    @Test
    public void test2() {
        Double result =
                Calculator.of(3d)
                        .map(v -> v + 7)
                        .flatMap(r -> reusableCalculator(r))
                        .accept(System.out::println)
                        .result();

        assertThat(result, is(33.0));
    }

    @Test
    public void test3() {
        Double result =
                Calculator.of(-Math.PI)
                        .map(Math::abs)
                        .map(Math::sin)
                        .map(Math::exp)
                        .map(Math::floor)
                        .flatMap(this::reusableCalculator)
                        .accept(System.out::println)
                        .result();

        assertThat(result, is(6.0));
    }

    private Calculator reusableCalculator(Double r) {
        return Calculator.of(r)
                .map(v -> v + 1)
                .map(v -> v * 3);
    }

}
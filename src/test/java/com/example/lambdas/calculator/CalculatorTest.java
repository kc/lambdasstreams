package com.example.lambdas.calculator;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CalculatorTest {

    @Test
    public void whenCalculateThenResultIsCorrect() {
        Double result =
                Calculator.of(5d)
                        .calculate(v -> v + 5) // 10
                        .calculate(v -> v * 2) // 20
                        .calculate(v -> v / 4) // 5
                        .calculate(v -> v % 2) // 1
                        .result();

        assertThat(result, is(1.0));
    }

    @Test
    public void whenSubCalculateThenResultIsCorrect() {
        Double result =
                Calculator.of(3d)
                        .calculate(v -> v + 7)
                        .subCalculate(r -> reusableCalculator(r))
                        .accept(System.out::println)
                        .result();

        assertThat(result, is(33.0));
    }

    @Test
    public void whenCalculationsCombinedThenResultIsCorrect() {
        Double result =
                Calculator.of(-Math.PI)
                        .calculate(Math::abs)
                        .calculate(Math::sin)
                        .calculate(Math::exp)
                        .calculate(Math::floor)
                        .subCalculate(this::reusableCalculator)
                        .accept(System.out::println)
                        .result();

        assertThat(result, is(6.0));
    }

    private Calculator reusableCalculator(Double r) {
        return Calculator.of(r)
                .calculate(v -> v + 1)
                .calculate(v -> v * 3);
    }

}

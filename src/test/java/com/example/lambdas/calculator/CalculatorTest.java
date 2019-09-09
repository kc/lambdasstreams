package com.example.lambdas.calculator;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CalculatorTest {

    @Test
    public void test() {
        Double result =
                Calculator.of(5d)
                        .calculate(v -> v + 5)
                        .calculate(v -> v * 2)
                        .calculate(v -> v / 4)
                        .result();

        assertThat(result, is(5.0));
    }

    @Test
    public void test2() {
        Double result =
                Calculator.of(-Math.PI)
                        .calculate(Math::abs)
                        .calculate(Math::sin)
                        .calculate(Math::exp)
                        .calculate(Math::floor)
                        .flatMap(this::complex)
                        .accept(System.out::println)
                        .result();

        assertThat(result, is(6.0));
    }


    private Calculator complex(Double r) {
        return Calculator.of(r)
                .calculate(v -> v + 1)
                .calculate(v -> v * 3);
    }

}
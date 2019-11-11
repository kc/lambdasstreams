package com.example.lambdas.calculator;

import java.util.function.Consumer;
import java.util.function.Function;

public class Calculator {

    // private ...;

    private Calculator(Double d) {

    }

    public static Calculator of(Double d) {
        return null;
    }

    public Calculator map(Function<Double, Double> f) {
        return null;
    }

    public Double result() {
        return null;
    }

    public Calculator accept(Consumer<Double> c) {
        return null;
    }

    public Calculator flatMap(Function<Double, Calculator> f) {
        return null;
    }
}

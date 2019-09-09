package com.example.lambdas;

import java.util.function.Consumer;
import java.util.function.Function;

public class Calculator {


    private Calculator(Double i) {
    }

    public static Calculator of(Double i) {
        return null;
    }

    public Calculator calculate(Function<Double, Double> f) {
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

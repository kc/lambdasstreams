package com.example.lambdas.calculator.solution;

import java.util.function.Consumer;
import java.util.function.Function;

public class Calculator {

    private Double value;

    private Calculator(Double i) {
        this.value = i;
    }

    public static Calculator of(Double i) {
        return new Calculator(i);
    }

    public Calculator calculate(Function<Double, Double> f) {
        this.value = f.apply(this.value);
        return this;
    }

    public Double result() {
        return this.value;
    }

    public Calculator accept(Consumer<Double> c) {
        c.accept(this.value);
        return this;

    }

    public Calculator flatMap(Function<Double, Calculator> f) {
        this.value = f.apply(this.value).result();
        return this;
    }
}

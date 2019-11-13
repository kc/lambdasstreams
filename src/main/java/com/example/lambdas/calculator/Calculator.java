package com.example.lambdas.calculator;

import java.util.function.Consumer;
import java.util.function.Function;

public class Calculator {

    // private ...; // TODO

    private Calculator(Double d) {  /*TODO*/ }

    public static Calculator of(Double d) { /*TODO*/return null; }

    public Calculator calculate(Function<Double, Double> f) { /*TODO*/return null; }

    public Calculator subCalculate(Function<Double, Calculator> f) { /*TODO*/return null; }

    public Double result() { /*TODO*/return null; }

    public Calculator accept(Consumer<Double> c) { /*TODO*/return null; }
}

package com.example.lambdas.parametrization.apples;

public class ApplePrinter implements AppleConsumer {
    @Override
    public void accept(Apple apple) {
        System.out.println(apple);
    }
}

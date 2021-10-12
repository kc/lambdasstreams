package com.example.lambdas.parametrization.apples;

import java.util.List;

class AppleService {
    void consumeApples(List<Apple> apples, Consumer<Apple> appleConsumer) {
        for (Apple apple : apples) {
            appleConsumer.accept(apple);
        }
    }
}
package com.example.lambdas.parametrization.apples;

import java.util.List;

@SuppressWarnings({"Convert2Lambda", "Anonymous2MethodRef"})
class AppleService {
    void consumeApples(List<Apple> apples) {
        AppleConsumer consumer = new AppleConsumer() {
            @Override
            public void accept(Apple apple) {
                System.out.println(apple);
            }
        };

        for (Apple apple : apples) {
            consumer.accept(apple);
        }
    }
}
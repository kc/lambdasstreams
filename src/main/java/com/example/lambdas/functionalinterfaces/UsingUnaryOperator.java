package com.example.lambdas.functionalinterfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;

public class UsingUnaryOperator {

    public static <T> List<T> map(List<T> list, UnaryOperator<T> f) {
        List<T> result = new ArrayList<>();
        // ...
        return result;
    }
}

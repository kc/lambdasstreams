package com.example.lambdas.functionalinterfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class UsingSupplier {
    public static List<String> concat(List<String> list, Supplier<String> s) {
        List<String> result = new ArrayList<>();
        list.forEach(str -> result.add(str + s.get()));
        return result;
    }

}


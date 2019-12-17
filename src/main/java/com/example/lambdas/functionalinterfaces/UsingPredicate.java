package com.example.lambdas.functionalinterfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class UsingPredicate {

    public static List<String> filter(List<String> list, Predicate<String> p) {
        List<String> result = new ArrayList<>();
        // TODO: copy the elements from list which meet p to result
        return result;
    }
}


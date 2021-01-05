package com.example.lambdas.functionalinterfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class UsingFunction {
    public static List<Integer> map(List<String> list, Function<String, Integer> f) {
        List<Integer> result = new ArrayList<>();
        // TODO: transform each element in the list using f and put the transformed element in result

        return result;
    }

}


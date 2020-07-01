package com.example.lambdas.functionalinterfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class UsingSupplier {
    public static List<String> concat(List<String> list, Supplier<String> s) {
        List<String> result = new ArrayList<>();
        // TODO: concat each element from list with the result of s and put the new element in result
        return result;
    }

}


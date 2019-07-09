package com.example.lambdas.functionalinterfaces;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static com.example.lambdas.functionalinterfaces.UsingPredicate.filter;

public class UsingPredicateTest {

    @Test
    public void test() {
        List<String> listOfStrings = Arrays.asList("a", "ab", "", "abc");
        List<String> nonEmpt = filter(listOfStrings, s -> !s.isEmpty());

        for (String s : nonEmpt) {
            System.out.println(s);
        }
    }
}


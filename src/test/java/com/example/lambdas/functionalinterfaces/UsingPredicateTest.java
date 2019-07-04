package com.example.lambdas.functionalinterfaces;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import static com.example.lambdas.functionalinterfaces.UsingPredicate.filter;

public class UsingPredicateTest {

    @Test
    public void test() {
        List<String> listOfStrings = Arrays.asList("a", "ab", "", "abc");
        Predicate<String> nonEmptyStringPredicate = (String s) -> !s.isEmpty();
        List<String> nonEmpt = filter(listOfStrings, nonEmptyStringPredicate);

        for (String s : nonEmpt) {
            System.out.println(s);
        }
    }
}


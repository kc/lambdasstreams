package com.example.lambdas.functionalinterfaces;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.example.lambdas.functionalinterfaces.UsingConsumer.forEach;

public class UsingConsumerTest {

    private final List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

    @Test
    public void printIntegers() {
        forEach(list, System.out::println);
    }

    @Test
    public void addIntegers() {
        List<Integer> copy = new ArrayList<>();
        forEach(list, s -> copy.add(s)); // void compatibility: we can pass in a Predicate (lambda returns boolean) as a Consumer! (Boolean) Statement expression is compatible with void.
        forEach(copy, System.out::println);
    }

}
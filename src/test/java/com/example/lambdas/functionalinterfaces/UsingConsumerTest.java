package com.example.lambdas.functionalinterfaces;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static com.example.lambdas.functionalinterfaces.UsingConsumer.forEach;

public class UsingConsumerTest {

    @Test
    public void printIntegers() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        forEach(list, (Integer i) -> System.out.println(i));
        forEach(list, s -> list.add(s)); // void compatibility;
    }

}
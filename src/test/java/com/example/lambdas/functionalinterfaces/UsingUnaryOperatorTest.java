package com.example.lambdas.functionalinterfaces;

import org.junit.Test;

import java.util.List;
import java.util.function.UnaryOperator;

import static com.example.lambdas.functionalinterfaces.UsingConsumer.forEach;
import static com.example.lambdas.functionalinterfaces.UsingUnaryOperator.map;

public class UsingUnaryOperatorTest {

    @Test
    public void negateInts() {
        UnaryOperator<Integer> negate = x -> -1 * x;
        List<Integer> map = map(List.of(1, 2, 3, 4, 5), negate);
        forEach(map, System.out::println);
    }

    @Test
    public void manipulateStrings() {
        UnaryOperator<String> addTxt = s -> s + ".txt";
        map(List.of("1", "2", "3", "4", "5"), addTxt).forEach(System.out::println);
    }
}
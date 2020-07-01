package com.example.lambdas.functionalinterfaces;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static com.example.lambdas.functionalinterfaces.UsingConsumer.forEach;
import static org.assertj.core.api.Assertions.assertThat;

public class UsingConsumerTest {

    private final List<Integer> list = List.of(1, 2, 3, 4, 5);

    @Test
    public void printIntegers() {
        forEach(list, x -> System.out.println(x));
    }

    @Test
    public void addIntegers() {
        List<Integer> copy = new ArrayList<>();
        forEach(list, e -> copy.add(e)); // void compatibility: we can pass in a Predicate (lambda returns boolean) as a Consumer! (Boolean) Statement expression is compatible with void.
        assertThat(copy.size()).isEqualTo(list.size());
    }

}

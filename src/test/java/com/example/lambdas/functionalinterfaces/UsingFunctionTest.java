package com.example.lambdas.functionalinterfaces;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static com.example.lambdas.functionalinterfaces.UsingFunction.map;

public class UsingFunctionTest {

    @Test
    public void mapStringsToIntAccordingToTheirLength() {
        List<Integer> lengths = map(Arrays.asList("lambdas", "in", "action"), (String s) -> s.length());

        for (int length : lengths) {
            System.out.println(length);
        }
    }

}


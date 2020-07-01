package com.example.lambdas.functionalinterfaces;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static com.example.lambdas.functionalinterfaces.UsingFunction.map;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class UsingFunctionTest {

    @Test
    public void mapStringsToIntAccordingToTheirLength() {
        List<String> list = Arrays.asList("lambdas", "in", "action");
        List<Integer> lengths = map(list, s -> s.length());

        assertThat(lengths.size(), is(list.size()));
        for (int i = 0; i < list.size(); i++) {
            assertThat(list.get(i).length(), is(lengths.get(i)));
        }
    }

}


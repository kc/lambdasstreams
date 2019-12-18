package com.example.lambdas.functionalinterfaces;

import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static com.example.lambdas.functionalinterfaces.UsingPredicate.filter;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class UsingPredicateTest {

    @Test
    public void test() {
        List<String> listOfStrings = Arrays.asList("a", "ab", "", "abc");
        List<String> nonEmpt = filter(listOfStrings, s -> !s.isEmpty());

        assertThat(nonEmpt.size(), is(3));
    }
}


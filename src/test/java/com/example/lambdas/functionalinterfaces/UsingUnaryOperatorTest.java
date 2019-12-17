package com.example.lambdas.functionalinterfaces;

import org.junit.Ignore;
import org.junit.Test;

import java.util.List;
import java.util.function.UnaryOperator;

import static com.example.lambdas.functionalinterfaces.UsingConsumer.forEach;
import static com.example.lambdas.functionalinterfaces.UsingUnaryOperator.map;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class UsingUnaryOperatorTest {

    @Ignore // TODO: remove!
    @Test
    public void negateInts() {
        UnaryOperator<Integer> negate = x -> -1 * x;
        List<Integer> input = List.of(1, 2, 3, 4, 5);

        List<Integer> output = map(input, negate);
        forEach(output, System.out::println);

        assertThat(output.size(), is(input.size()));
        for (int i = 0; i < output.size(); i++) {
            assertThat(output.get(i), is(input.get(i) * -1));
        }
    }

    @Ignore // TODO: remove!
    @Test
    public void manipulateStrings() {
        final String ext = ".txt";
        UnaryOperator<String> addTxt = s -> s + ext;
        List<String> input = List.of("1", "2", "3", "4", "5");

        List<String> output = map(input, addTxt);
        output.forEach(System.out::println);

        assertThat(output.size(), is(input.size()));
        output.forEach(s -> assertThat(s, containsString(ext)));
    }
}
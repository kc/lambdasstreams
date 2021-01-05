package com.example.lambdas.methodreferences;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class MethodReferencesTest {

    private final String[] COLORS = {"green", "red", "yellow"};
    private final int[] WEIGHTS = {100, 200, 300, 400};

    @Test
    public void testAppleFactory() {
        MethodReferences f = new MethodReferences();
        List<Apple> apples = f.appleFactory(COLORS, WEIGHTS, Apple::new);
        assertThat(apples.size(), is(COLORS.length * WEIGHTS.length));
    }
}

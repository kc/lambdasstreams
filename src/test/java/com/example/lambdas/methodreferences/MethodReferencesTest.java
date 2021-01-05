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
        int size = COLORS.length * WEIGHTS.length;

        List<Apple> apples1 = f.appleFactory(COLORS, WEIGHTS, (color, weight) -> new Apple(color, weight));
        assertThat(apples1.size(), is(size));

        // with method reference
        List<Apple> apples2 = f.appleFactory(COLORS, WEIGHTS, Apple::new);
        assertThat(apples2.size(), is(size));
    }
}

package com.example.lambdas.methodreferences;

import org.junit.Test;

public class MethodReferencesTest {

    private final String[] COLORS = {"green", "red", "yellow"};
    private final int[] WEIGHTS = {100, 200, 300, 400};

    private MethodReferences target = new MethodReferences();

    @Test
    public void testAppleFactory() {
        // TODO:
        //  - call the appleFactory with COLORS, WEIGHTS, and a lambda to create an apple
        //  - assert that the returned list's length == COLORS.length * WEIGHTS.length
    }
}

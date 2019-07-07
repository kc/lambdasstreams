package com.example.lambdas;

import org.junit.Test;

import java.util.function.IntConsumer;
import java.util.function.IntFunction;
import java.util.function.ObjIntConsumer;

public class MethodReferencesTest {


    @Test
    public void test() {
        MethodReferences methodReferences = new MethodReferences();

        IntFunction<Integer> intConsumer = a -> MethodReferences.x(a); // static method

        ObjIntConsumer<MethodReferences> o = (m, i) -> m.y(i);
        o.accept(methodReferences, 10);

         // instance method
        IntConsumer consumer = (int i) -> methodReferences.y(i);
    }
}
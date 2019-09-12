package com.example.lambdas;

import org.junit.Test;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.IntConsumer;
import java.util.function.IntFunction;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MyMathTest {


    @Test
    public void test() {
        // als een lambda simpelweg delegeert naar een andere methode, kun je in enkele
        // gevallen direct een referentie naar die andere methode meegeven ipv de lambda die hem aanroept

        MyMath myMath = new MyMath(42);

        // a method reference to a static method
        int execute1 = execute(4, (int a) -> a + 1);
        int execute2 = execute(4, (int a) -> MyMath.x(a)); // put 4 into function x
        int execute3 = execute(4, MyMath::x);

        assertThat(execute1, is(execute2));
        assertThat(execute2, is(execute3));

        // a method reference to an instance method
        execute(myMath, 10, (x, y) -> System.out.println("hap" + x.i + y));
        execute(myMath, 10, (m, i) -> m.y(i)); // apply m.y on 10
        execute(myMath, 10, MyMath::y);

        String s1 = execute((s, i) -> s.substring(i), "abcde", 3); // apply substring on abcde, skip 3
        String s2 = execute(String::substring, "abcde", 3);
        System.out.println(s1);
        System.out.println(s2);

        // a method reference to an instance method of an existing object
        execute(9, (int i) -> System.out.println("yummie" + i));
        execute(9, (int i) -> myMath.z(i));
        execute(9, myMath::z);

        // constructor reference
        IntFunction<MyMath> f = MyMath::new;
        MyMath apply = f.apply(100);
        assertThat(apply.i, is(100));
    }

    private int execute(int i, IntFunction<Integer> c) { return c.apply(i); }

    private void execute(MyMath m, int i, BiConsumer<MyMath, Integer> c) {
        c.accept(m, i);
    }

    private String execute(BiFunction<String, Integer, String> stringFunction, String s, int skip) {
        return stringFunction.apply(s, skip);
    }

    private void execute(int i, IntConsumer c) { c.accept(i); }
}
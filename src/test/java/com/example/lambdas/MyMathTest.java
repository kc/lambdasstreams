package com.example.lambdas;

import org.junit.Test;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.function.IntFunction;
import java.util.function.Supplier;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MyMathTest {

    @Test
    public void intro() {
        // als een lambda simpelweg delegeert naar een andere methode, kun je in sommige
        // gevallen een referentie naar die andere methode meegeven ipv de lambda die hem aanroept

        // Stel we hebben (oude stijl):
        Consumer<Integer> c1 = new Consumer<Integer>() {
            @Override
            public void accept(Integer i) {
                System.out.println(i);
            }
        };

        // Accept roept alleen maar println met i aan.

        // Aanroepen van accept:
        c1.accept(1);
        // ... is dus hetzelfde als:
        System.out.println(1);

        // Nieuwe stijl:
        Consumer<Integer> c2 = i -> System.out.println(i);
        c2.accept(2);

        // Daarom kunnen we ook zeggen:
        Consumer<Integer> c3 = System.out::println;
        c3.accept(3);
    }

    @Test
    public void example() {
        MyMath myMath = new MyMath(42);

        // 1. a method reference to a static method
        int mutate0 = mutate(4, a -> a + 1);
        int mutate1 = mutate(4, a -> MyMath.x(a)); // put a into function x
        int mutate2 = mutate(4, MyMath::x); // use function x

        assertThat(mutate0, is(5));
        assertThat(mutate1, is(5));
        assertThat(mutate2, is(5));

        // 2. a method reference to an instance method
        String s1 = mutate("abcde", 3, (s, i) -> s.substring(i));
        String s2 = mutate("abcde", 3, String::substring);
        assertThat(s1, is("de"));
        assertThat(s2, is("de"));

        mutate(myMath, 10, (m, i) -> m.i + i);
        mutate(myMath, 10, (m, i) -> m.y(i)); // apply m.y on 10
        mutate(myMath, 10, MyMath::y);

        // 3. a method reference to an instance method of an existing object
        consume(9, i -> System.out.println(i));
        consume(9, i -> myMath.y(i));
        consume(9, myMath::y);

        // 4. constructor references
        Supplier<MyMath> s = MyMath::new; // no arg constructor
        IntFunction<MyMath> f = MyMath::new; // one (int) arg constructor

        MyMath myMath1 = s.get();
        MyMath myMath2 = f.apply(100);

        assertThat(myMath1.i, is(-1));
        assertThat(myMath2.i, is(100));
    }

    private int mutate(int i, IntFunction<Integer> c) {
        return c.apply(i);
    }

    private String mutate(String s, int skip, BiFunction<String, Integer, String> stringFunction) {
        return stringFunction.apply(s, skip);
    }

    private void consume(MyMath m, int i, BiConsumer<MyMath, Integer> c) {
        c.accept(m, i);
    }

    private int mutate(MyMath m, int i, BiFunction<MyMath, Integer, Integer> c) {
        return c.apply(m, i);
    }

    private void consume(int i, IntConsumer c) {
        c.accept(i);
    }
}

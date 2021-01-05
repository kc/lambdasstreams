package com.example.lambdas.methodreferences;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.function.*;

public class MethodReferences {

    // Lab 3.1
    public void equivalentMethodReferences() {
        ToIntFunction<String> stringToInt1 = (String s) -> Integer.parseInt(s);
        // TODO

        BiPredicate<List<String>, String> contains1 = (list, element) -> list.contains(element);
        // TODO

        Predicate<String> startsWithNumber1 = (String string) -> this.startsWithNumber(string);
        // TODO

        // ----------------------

        // Usage of these lambda's:

        int i42 = parse("42", (String s) -> Integer.parseInt(s));
        check(List.of("1", "2", "3"), "3", (list, element) -> list.contains(element));
        check("1abc", (String string) -> this.startsWithNumber(string));

    }

    // Lab 3.2
    public void systemMethodReferences() {
        // For example:
        Supplier<Console> s = System::console;
        Callable<Console> c = System::console;

        // etc. TODO
    }

    // Lab 3.3
    public void stringMethodReferences() {
        // TODO
    }

    // Lab 3.4
    public List<Apple> appleFactory(String[] colors, int[] weights, BiFunction<String, Integer, Apple> creator) {
        List<Apple> result = new ArrayList<>();

        // TODO: create apples for all combinations of colors and weights

        return result;
    }

    private int parse(String s, ToIntFunction<String> f) {
        return f.applyAsInt(s);
    }

    private boolean check(List<String> strings, String s, BiPredicate<List<String>, String> p) {
        return p.test(strings, s);
    }

    private boolean check(String s, Predicate<String> p) {
        return p.test(s);
    }

    private boolean startsWithNumber(String s) {
        return s.charAt(0) >= 48 && s.charAt(0) < 58;
    }
}

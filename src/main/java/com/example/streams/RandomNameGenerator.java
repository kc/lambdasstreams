package com.example.streams;

import java.util.Random;

import static java.util.stream.Collectors.joining;

public class RandomNameGenerator {

    public static String name(int length) {
        return capitalise(generate(length));
    }

    private static String capitalise(String s) {
        return s.substring(0, 1).toUpperCase() + s.substring(1);
    }

    private static String generate(int length) {
        return new Random().ints(length, 'a', 'z' + 1)
                .mapToObj(Character::toString)
                .collect(joining());
    }
}

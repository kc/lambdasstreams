package com.example.lambdas.passingcode;

import com.example.lambdas.Apple;

import java.util.ArrayList;
import java.util.List;

public class AppleFinderElaborated {

    public static List<Apple> findGreenApples(List<Apple> apples) {
        List<Apple> listOfApples = new ArrayList<>();
        for (Apple apple : apples) {
            if ("green".equalsIgnoreCase(apple.getColor())) {
                listOfApples.add(apple);
            }
        }
        return listOfApples;
    }

    public static List<Apple> findApples(List<Apple> apples, String color, Integer weightMin) {
        List<Apple> listOfApples = new ArrayList<>();
        for (Apple apple : apples) {
            if (color != null && color.equalsIgnoreCase(apple.getColor())) {
                listOfApples.add(apple);
            } else if (weightMin != null && apple.getWeight() >= weightMin) {
                listOfApples.add(apple);
            }
        }
        return listOfApples;
    }

    public static List<Apple> findApplesByPredicate(List<Apple> apples, ApplePredicate predicate) {
        List<Apple> listOfApples = new ArrayList<>();
        for (Apple apple : apples) {
            if (predicate.test(apple)) {
                listOfApples.add(apple);
            }
        }
        return listOfApples;
    }


}


interface ApplePredicate {
    boolean test(Apple a);
}

class IsGreenApple implements ApplePredicate {
    @Override public boolean test(Apple a) {
        return "green".equalsIgnoreCase(a.getColor());
    }
}

class IsHeavyApple implements ApplePredicate {
    @Override public boolean test(Apple a) {
        return a.getWeight() >= 150;
    }
}
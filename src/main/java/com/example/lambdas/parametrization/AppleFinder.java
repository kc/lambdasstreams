package com.example.lambdas.parametrization;

import com.example.lambdas.Apple;

import java.util.ArrayList;
import java.util.List;

public class AppleFinder {

    public static List<Apple> findGreenApples(List<Apple> apples) {
        List<Apple> listOfApples = new ArrayList<>();
        for (Apple apple : apples) {
            if ("green".equalsIgnoreCase(apple.getColor())) {
                listOfApples.add(apple);
            }
        }
        return listOfApples;
    }

}
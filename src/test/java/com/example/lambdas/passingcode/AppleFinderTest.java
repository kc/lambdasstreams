package com.example.lambdas.passingcode;

import com.example.lambdas.Apple;
import org.junit.Test;

import java.util.Comparator;
import java.util.List;

import static com.example.lambdas.AppleStock.appleList;
import static org.junit.Assert.assertEquals;

public class AppleFinderTest {


    @Test
    public void findByColor() {
        List<Apple> greenApples = AppleFinder.findGreenApples(appleList());

        for (Apple greenApple : greenApples) {
            assertEquals("green", greenApple.getColor());
        }
    }

    @Test
    public void sortStock() {
        appleList().sort(new Comparator<Apple>() {
            @Override public int compare(Apple apple1, Apple apple2) {
                int result = apple1.getWeight() - apple2.getWeight();
                return result;
            }
        });
    }

}
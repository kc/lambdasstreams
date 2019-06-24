package com.example.lambdas.passingcode;

import com.example.lambdas.Apple;
import org.junit.Test;

import java.util.Comparator;
import java.util.List;

import static com.example.lambdas.AppleStock.appleList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AppleFinderElaboratedTest {
    @Test
    public void findByColor() {
        List<Apple> greenApples = AppleFinder.findGreenApples(appleList());

        for (Apple greenApple : greenApples) {
            assertEquals("green", greenApple.getColor());
        }
    }

    @Test
    public void findByPredicate() {
        List<Apple> greenApples = AppleFinderElaborated.findApplesByPredicate(appleList(), new IsGreenApple());
        for (Apple greenApple : greenApples) {
            assertEquals("green", greenApple.getColor());
        }

        List<Apple> heavyApples = AppleFinderElaborated.findApplesByPredicate(appleList(), new IsHeavyApple());
        for (Apple a : heavyApples) {
            assertTrue(150 <= a.getWeight());
        }

        List<Apple> redApples = AppleFinderElaborated.findApplesByPredicate(appleList(), new ApplePredicate() {
            @Override public boolean test(Apple a) {
                return "red".equalsIgnoreCase(a.getColor());
            }
        });
        for (Apple a : redApples) {
            assertEquals("red", a.getColor());
        }

    }

    @Test
    public void findByLambda() {
        List<Apple> apples = AppleFinderElaborated.findApplesByPredicate(appleList(), a -> "yellow".equalsIgnoreCase(a.getColor()));
        for (Apple a : apples) {
            assertEquals("yellow", a.getColor());
        }
    }

    @Test
    public void sortStock() {
        appleList().sort(new Comparator<Apple>() {
            @Override public int compare(Apple o1, Apple o2) {
                return 0;
            }
        });
    }
}
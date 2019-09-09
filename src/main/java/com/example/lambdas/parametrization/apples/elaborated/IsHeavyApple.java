package com.example.lambdas.parametrization.apples.elaborated;

import com.example.lambdas.parametrization.apples.Apple;

class IsHeavyApple implements ApplePredicate {
    @Override public boolean test(Apple a) {
        return a.getWeight() >= 150;
    }
}

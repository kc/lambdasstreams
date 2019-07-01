package com.example.lambdas.parametrization.elaborated;

import com.example.lambdas.Apple;

class IsHeavyApple implements ApplePredicate {
    @Override public boolean test(Apple a) {
        return a.getWeight() >= 150;
    }
}

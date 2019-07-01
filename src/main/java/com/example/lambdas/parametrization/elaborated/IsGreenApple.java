package com.example.lambdas.parametrization.elaborated;

import com.example.lambdas.Apple;

class IsGreenApple implements ApplePredicate {
    @Override public boolean test(Apple a) {
        return "green".equalsIgnoreCase(a.getColor());
    }
}

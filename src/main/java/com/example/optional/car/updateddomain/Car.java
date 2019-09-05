package com.example.optional.car.updateddomain;

import java.util.Optional;

public class Car {
    private Insurance insurance;

    public Car(Insurance insurance) {
        this.insurance = insurance;
    }

    public Optional<Insurance> getInsurance() { return Optional.ofNullable(insurance); }
}

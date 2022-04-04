package com.example.optionals.car.updateddomain;

import java.util.Optional;

public class Car {
    private final Insurance insurance;
    private String name = "Skoda";

    public Car(Insurance insurance) {this.insurance = insurance;}

    public Optional<Insurance> getInsurance() {return Optional.ofNullable(insurance);}

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}
}

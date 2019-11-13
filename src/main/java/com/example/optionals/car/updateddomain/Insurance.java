package com.example.optionals.car.updateddomain;

import java.util.Optional;

public class Insurance {
    private Integer years;
    private String name;

    public Insurance(String name) {
        this.name = name;
    }

    public Optional<Integer> getYears() {
        return Optional.of(years);
    }

    public String getName() { return name; }
}

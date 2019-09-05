package com.example.optional.car;

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

package com.example.optionals.car;

import java.util.Optional;

public class Insurance {
    private Integer years;
    private String name;

    public Insurance(String name) {
        this.name = name;
    }

    public Optional<Integer> getYears() {
        return Optional.ofNullable(years);
    }

    public String getName() { return name; }
}

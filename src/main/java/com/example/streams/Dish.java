package com.example.streams;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Dish {

    private final String name;
    private final boolean vegetarian;
    private final int calories;
    private final Dish.Type type;

    public enum Type {MEAT, FISH, OTHER}

}


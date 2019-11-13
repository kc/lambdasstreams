package com.example.optionals.car.updateddomain;


import java.util.Optional;

public class Person {
    private Car car;
    private int age;

    public Person(Car car) {
        this.car = car;
    }

    public Person(Car car, int age) {
        this(car);
        this.age = age;
    }

    public Optional<Car> getCar() {
        return Optional.ofNullable(car);
    }

    public int getAge() {
        return age;
    }
}

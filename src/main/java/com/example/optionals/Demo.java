package com.example.optionals;

import com.example.optionals.car.Car;
import com.example.optionals.car.Insurance;
import com.example.optionals.car.Person;

import java.util.Optional;

public class Demo {

    public static void main(String[] args) {
        Person p = new Person(new Car(new Insurance("WA")));
        Person p2 = new Person(null);

        printInsuranceName(p);
        printInsuranceName(p2);
        printInsuranceName(null);
    }

    private static void printInsuranceName(Person per) {
        System.out.println(
                Optional.ofNullable(per)
                        .map(Person::getCar)
                        .map(Car::getInsurance)
                        .map(Insurance::getName)
                        .filter(n -> n.startsWith("W"))
                        .map(String::length)
                        .orElse(-1));
    }
}

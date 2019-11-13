package com.example.optionals;

import java.util.Optional;

public class PersonService {

    public void raiseSalary0(Person p, String name, int raise) {
        if (p != null) {
            if (p.getName() != null)
                if (p.getName().contains(name)) {
                    p.setSalary(p.getSalary() + raise);
                }
        }
    }

    public void raiseSalary1(Person person, String name, int raise) {
        if (hasName(person, name)) {
            person.raiseSalary(raise);
        }
    }

    public void raiseSalary2(Person person, String name, int raise) {
        Optional.ofNullable(person)
                .filter(p -> hasName(p, name))
                .ifPresent(p -> p.raiseSalary(raise));
    }

    private boolean hasName(Person person, String name) {
        return Optional.ofNullable(person)
                .map(Person::getName)
                .filter(n -> n.contains(name))
                .isPresent();
    }

}

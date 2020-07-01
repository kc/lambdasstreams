package com.example.optionals;

import java.util.Optional;

/**
 * Null safe person service to optionally raise salary when given name is equal to person's name.
 */
public class PersonService {

    public void raiseSalaryOldStyle(Person p, String name, int amount) {
        if (p != null) {
            if (p.getName() != null)
                if (p.getName().contains(name)) {
                    p.setSalary(p.getSalary() + amount);
                }
        }
    }

    public void raiseSalaryNewStyle1(Person person, String name, int amount) {
        if (hasName(person, name)) {
            person.raiseSalary(amount);
        }
    }

    public void raiseSalaryNewStyle2(Person person, String name, int amount) {
        Optional.ofNullable(person)
                .filter(p -> hasName(p, name))
                .ifPresent(p -> p.raiseSalary(amount));
    }

    private boolean hasName(Person person, String name) {
        return Optional.ofNullable(person)
                .map(Person::getName)
                .filter(n -> n.contains(name))
                .isPresent();
    }

}

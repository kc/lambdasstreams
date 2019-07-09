package com.example.optional;

import java.util.Optional;

public class PersonService {
    public void raiseSalaryOldStyle(Person p, String name) {
        if (p != null) {
            if (p.getName() != null)
                if (p.getName().contains(name)) {
                    p.setSalary(p.getSalary() + 100);
                }
        }
    }

    public void raiseSalary(Person p, String name) {
        if (hasName(p, name)) {
            p.setSalary(p.getSalary() + 100);
        }
    }

    private boolean hasName(Person p, String name) {
        return Optional.ofNullable(p)
                .map(Person::getName)
                .filter(n -> n.contains(name))
                .isPresent();
    }

}

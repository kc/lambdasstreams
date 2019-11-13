package com.example.optionals.car.updateddomain;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public class Optionals {

    public static final String unknown = "Unknown";

    public static String getCarInsuranceName(Person person) {
        return unknown + "?"; // TODO; hint: use (flat)map
    }

    public static String getCarInsuranceName(Person person, int minAge) {
        return unknown + "?"; // TODO; hint: use Optional.filter
    }

    public static Set<String> getCarInsuranceNames(List<Person> persons) {
        return Set.of(unknown + "?");
        // TODO; use the code below as a starting point:
        // return persons.stream().
        // ....;
    }

    public static Optional<Insurance> nullSafeFindCheapestInsurance(Optional<Person> person,
                                                                    Optional<Car> car) {
        if (person.isPresent() && car.isPresent()) {
            return Optional.of(findCheapestInsurance(person.get(), car.get()));
        } else {
            return Optional.empty();
        }
        // TODO
        // rewrite to single return statement:
        // return .........;
    }

    private static Insurance findCheapestInsurance(Person person, Car car) {
        return new Insurance("El Cheapo");
    }

}
package com.example.optionals.car.updateddomain;

import java.util.List;
import java.util.Optional;
import java.util.Set;

// Example of a utility class implemented as an interface with default methods.
public interface Optionals {

    String unknown = "Unknown";

    default String getCarInsuranceName(Person person) {
        // TODO; hint: use Optional.(flat)map
        return unknown + "?";
    }

    default String getCarInsuranceName(Person person, int minAge) {
        // TODO; hint: use Optional.filter
        return unknown + "?";
    }

    default Set<String> getCarInsuranceNames(List<Person> persons) {
        return Set.of(unknown + "?");
        // TODO; use the code below as a starting point:
        // return persons.stream().
        //          ....;
    }

    default Insurance findCheapestInsurance(Person person, Car car) {
        // This method is NOT null safe...
        if (person.getAge() > 25 && !car.getName().equals("VW Golf")) {
            return new Insurance("El Cheapo");        // perform some database query ...
        } else {
            return new Insurance("Normal insurance"); // perform some other database query ...
        }
    }

    default Optional<Insurance> findCheapestInsuranceNullSafe(Person person, Car car) {
        Optional<Person> optPerson = Optional.ofNullable(person);
        Optional<Car> optCar = Optional.ofNullable(car);

        if (optPerson.isPresent() && optCar.isPresent()) {
            return Optional.of(findCheapestInsurance(optPerson.get(), optCar.get()));
        } else {
            return Optional.empty();
        }

        // TODO
        // rewrite above to a single return statement:
        // return .........;
    }
}

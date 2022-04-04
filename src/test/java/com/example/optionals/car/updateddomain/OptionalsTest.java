package com.example.optionals.car.updateddomain;

import org.junit.Test;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNot.not;

public class OptionalsTest implements Optionals { // Inherits all utility methods

    private static final String wa = "WA";

    @Test
    public void getOptionalCarInsuranceNameReturnsUnknown() {
        Person person = null;
        String name = getCarInsuranceName(person);
        assertThat(name, is(unknown));
    }

    @Test
    public void getOptionalCarInsuranceNameReturnsName() {
        Person person = new Person(new Car(new Insurance(wa)));
        String name = getCarInsuranceName(person);
        assertThat(name, is(wa));
    }

    @Test
    public void getOptionalCarInsuranceNameWithAgeHighEnoughReturnsName() {
        Person person = new Person(new Car(new Insurance(wa)), 20);
        String name = getCarInsuranceName(person, 18);
        assertThat(name, is(wa));
    }

    @Test
    public void getOptionalCarInsuranceNameWithAgeTooLowReturnsUnknown() {
        Person person = new Person(new Car(new Insurance(wa)), 16);
        String name = getCarInsuranceName(person, 18);
        assertThat(name, is(unknown));
    }

    @Test
    public void getOptionalCarInsuranceNamesReturnsUniqueNames() {
        Set<String> names = getCarInsuranceNames(people());
        assertThat(names.size(), is(4));
    }

    @Test(expected = NullPointerException.class)
    public void findCheapestInsuranceOnNullPersonAndCarIsNotNullSafe() {
        Car c = null;
        Person p = null;

        Insurance insurance = findCheapestInsurance(p, c);
    }

    @Test
    public void findCheapestInsuranceNullSafeOnNullPersonAndCarFindsUnknownInsurance() {
        Car c = null;
        Person p = null;

        Optional<Insurance> insurance = findCheapestInsuranceNullSafe(p, c);
        assertThat(insurance.isPresent(), is(false));

        String name = insurance.map(Insurance::getName).orElse(unknown);
        assertThat(name, is(unknown));
    }

    @Test
    public void findCheapestInsuranceNullSafeOnExistingPersonAndCarFindsCheapestInsurance() {
        Car c = new Car(new Insurance(wa));
        Person p = new Person(c, 20);

        Optional<Insurance> insurance = findCheapestInsuranceNullSafe(p, c);
        assertThat(insurance.isPresent(), is(true));

        String name = insurance.map(Insurance::getName).orElse(unknown);
        assertThat(name, is(not(unknown)));
    }

    private List<Person> people() {
        List<Person> people = peopleWithCarsAndInsurances();

        people.addAll(peopleWithCarsWithoutInsurances());
        people.addAll(peopleWithoutCars());

        return people;
    }

    private List<Person> peopleWithCarsAndInsurances() {
        return Stream.of("A", "A", "B", "C", "D", "C")
                .map(Insurance::new)
                .map(Car::new)
                .map(Person::new)
                .collect(toList());
    }

    private List<Person> peopleWithCarsWithoutInsurances() {
        return Stream.iterate(0, i -> i + 1)
                .limit(10)
                .map(i -> new Car(null))
                .map(Person::new)
                .collect(toList());
    }

    private List<Person> peopleWithoutCars() {
        return Stream.iterate(0, i -> i + 1)
                .limit(20)
                .map(i -> new Person(null))
                .collect(toList());
    }
}

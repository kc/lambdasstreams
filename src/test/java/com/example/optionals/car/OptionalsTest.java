package com.example.optionals.car;

import org.junit.Test;

import static com.example.optionals.car.updateddomain.Optionals.unknown;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class OptionalsTest {

    @Test(expected = NullPointerException.class)
    public void getCarInsuranceNameNotSafeThrowsNullPointerException() {
        Person person = null;
        String name = Optionals.getCarInsuranceNameNotSafe(person);
        assertThat(name, nullValue());
    }

    @Test
    public void getCarInsuranceNameNestedReturnsUnknown() {
        Person person = null;
        String name = Optionals.getCarInsuranceNameNested(person);
        assertThat(name, is(unknown));
    }

    @Test
    public void getCarInsuranceNameMultipleExitPointsReturnsUnknown() {
        Person person = null;
        String name = Optionals.getCarInsuranceNameMultipleExitPoints(person);
        assertThat(name, is(unknown));
    }

    @Test
    public void getOptionalCarInsuranceNameReturnsUnknown() {
        Person person = null;
        String name = Optionals.getCarInsuranceName(person);
        assertThat(name, is(unknown));
    }

    @Test
    public void getOptionalCarInsuranceNameReturnsName() {
        Person person = new Person(new Car(new Insurance("WA")));
        String name = Optionals.getCarInsuranceName(person);
        assertThat(name, is("WA"));
    }
    
    @Test
    public void getCarInsuranceNameWithNullCar() {
        Person person = new Person(null);
        String name = Optionals.getCarInsuranceName(person);
        assertThat(name, is(unknown));
    }

    @Test
    public void getCarInsuranceNameWithNullInsurance() {
        Person person = new Person(new Car(null));
        String name = Optionals.getCarInsuranceName(person);
        assertThat(name, is(unknown));
    }

    @Test
    public void getCarInsuranceNameWithNullInsuranceName() {
        Person person = new Person(new Car(new Insurance(null)));
        String name = Optionals.getCarInsuranceName(person);
        assertThat(name, is(unknown));
    }
}

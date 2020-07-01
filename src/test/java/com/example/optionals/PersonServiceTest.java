package com.example.optionals;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class PersonServiceTest {

    private final PersonService personService = new PersonService();

    @Test
    public void raiseSalaryOnAnyPersonIsNullSafeAndSalaryIsRaisedCorrectly() {
        String name = "Bram";

        Person p1 = null;
        Person p2 = new Person(null);
        Person p3 = new Person(name);

        personService.raiseSalaryOldStyle(p1, name, 100);
        personService.raiseSalaryOldStyle(p2, name, 100);
        personService.raiseSalaryOldStyle(p3, name, 100);

        personService.raiseSalaryNewStyle1(p1, name, 100);
        personService.raiseSalaryNewStyle1(p2, name, 100);
        personService.raiseSalaryNewStyle1(p3, name, 100);

        personService.raiseSalaryNewStyle2(p1, name, 100);
        personService.raiseSalaryNewStyle2(p2, name, 100);
        personService.raiseSalaryNewStyle2(p3, name, 100);

        // No NullPointerExceptions have been thrown.

        assertNull(p1);
        assertEquals(p2.getSalary(), 0);
        assertEquals(p3.getSalary(), 300);
    }

}

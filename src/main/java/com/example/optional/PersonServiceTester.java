package com.example.optional;

public class PersonServiceTester {

    public static void main(String[] args) {
        String name = "Bram";

        Person p1 = null;
        Person p2 = new Person();
        Person p3 = new Person(name);

        PersonService personService = new PersonService();

        personService.raiseSalaryOldStyle(p1, name);
        personService.raiseSalaryOldStyle(p2, name);
        personService.raiseSalaryOldStyle(p3, name + "Foo");

        personService.raiseSalary(p1, name);
        personService.raiseSalary(p2, name);
        personService.raiseSalary(p3, name);

        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
    }


}

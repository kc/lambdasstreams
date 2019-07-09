package com.example.optional;

public class PersonServiceTester {

    public static void main(String[] args) {
        String name = "Bram";

        Person p1 = null;
        Person p2 = new Person();
        Person p3 = new Person(name);

        PersonService personService = new PersonService();

        personService.raiseSalary0(p1, name, 100);
        personService.raiseSalary0(p2, name, 100);
        personService.raiseSalary0(p3, "Foo", 100);

        personService.raiseSalary1(p1, name, 100);
        personService.raiseSalary1(p2, name, 100);
        personService.raiseSalary2(p3, name, 100);

        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
    }


}

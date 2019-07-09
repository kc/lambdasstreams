package com.example.optional;

public class PersonServiceTester {

    public static void main(String[] args) {
        Person p1 = null;
        Person p2 = new Person();
        Person p3 = new Person();
        p3.setName("Bram");

        PersonService personService = new PersonService();

        personService.raiseSalary(p1, "Bram");
        personService.raiseSalary(p2,"Bram");
        personService.raiseSalary(p3,"Bram");

        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);


    }


}

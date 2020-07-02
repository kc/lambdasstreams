package com.example.streams;


public class Person {
    public final String name;
    public final int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    @Override
    public boolean equals(Object obj) {
        Person  p = (Person) obj;
        if(this.name.equals(p.name) && this.age == p.age)
            return true;
        else
            return false;
    }

    @Override
    public int hashCode() {
        return name.hashCode() + age;
    }

    @Override public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

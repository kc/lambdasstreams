package com.example.streams.scottdb;

import java.util.ArrayList;
import java.util.List;

public class Department extends Object {

    private final int id;
    private final String name;
    private final String location;
    private final List<Employee> employees;

    public Department(int id, String name, String location) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.employees = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    @Override
    public String toString() {
        return "Department [id=" + id + ", name=" + name + ", location=" + location + "]";
    }
}

package com.example.streams.pubsdb.domain.model;

import com.example.streams.pubsdb.domain.model.helpers.Idable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * The persistent class for the publisher database table.
 */

public class Publisher implements Serializable, Idable<String> {
    private static final long serialVersionUID = 1L;

    private String id;

    private String city;

    private String country;

    private String pubName;

    private String state;

    //bi-directional many-to-one association to Employee

    private List<Employee> employees = new ArrayList<Employee>();

    //bi-directional one-to-one association to PubInfo
    private PubInfo pubInfo;

    //bi-directional many-to-one association to Title

    private List<Title> titles = new ArrayList<>();

    public Publisher() {
    }

    public Publisher(String id, String city, String country, String pubName, String state) {
        super();
        this.id = id;
        this.city = city;
        this.country = country;
        this.pubName = pubName;
        this.state = state;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPubName() {
        return this.pubName;
    }

    public void setPubName(String pubName) {
        this.pubName = pubName;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public List<Employee> getEmployees() {
        return this.employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public Employee addEmployee(Employee employee) {
        getEmployees().add(employee);
        employee.setPublisher(this);

        return employee;
    }

    public Employee removeEmployee(Employee employee) {
        getEmployees().remove(employee);
        employee.setPublisher(null);

        return employee;
    }

    public PubInfo getPubInfo() {
        return this.pubInfo;
    }

    public void setPubInfo(PubInfo pubInfo) {
        this.pubInfo = pubInfo;
    }

    public List<Title> getTitles() {
        return this.titles;
    }

    public void setTitles(List<Title> titles) {
        this.titles = titles;
    }

    public Title addTitle(Title title) {
        getTitles().add(title);
        title.setPublisher(this);

        return title;
    }

    public Title removeTitle(Title title) {
        getTitles().remove(title);
        title.setPublisher(null);

        return title;
    }
}

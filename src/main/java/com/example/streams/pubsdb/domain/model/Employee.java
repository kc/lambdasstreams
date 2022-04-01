package com.example.streams.pubsdb.domain.model;

import com.example.streams.pubsdb.domain.model.helpers.Idable;
import com.example.streams.pubsdb.domain.model.helpers.MySimpleDateFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * The persistent class for the employee database table.
 */


public class Employee implements Serializable, Idable<String> {
    private static final long serialVersionUID = 1L;


    private String id;


    private String firstname;


    private String lastname;


    private Date hireDate;


    private BigDecimal jobLvl;

    private String minit;

    //bi-directional many-to-one association to Job


    private Job job;

    //bi-directional many-to-one association to Publisher


    private Publisher publisher;

    public Employee() {
    }

    public Employee(String id, String firstname, String lastname, String hireDate, String jobLvl, String minit) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.hireDate = new MySimpleDateFormat().parse(hireDate);
        this.jobLvl = new BigDecimal(jobLvl);
        this.minit = minit;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Date getHireDate() {
        return this.hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public BigDecimal getJobLvl() {
        return this.jobLvl;
    }

    public void setJobLvl(BigDecimal jobLvl) {
        this.jobLvl = jobLvl;
    }


    public String getMinit() {
        return this.minit;
    }

    public void setMinit(String minit) {
        this.minit = minit;
    }

    public Job getJob() {
        return this.job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public Publisher getPublisher() {
        return this.publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

}

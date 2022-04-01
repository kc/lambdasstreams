package com.example.streams.pubsdb.domain.model;

import com.example.streams.pubsdb.domain.model.helpers.Idable;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * The persistent class for the job database table.
 */

public class Job implements Serializable, Idable<String> {
    private static final long serialVersionUID = 1L;

    private String id;

    private String jobDesc;

    private BigDecimal maxLvl;

    private BigDecimal minLvl;

    //bi-directional many-to-one association to Employee

    private List<Employee> employees = new ArrayList<Employee>();

    public Job() {
    }

    public Job(String id, String jobDesc, String maxLvl, String minLvl) {
        super();
        this.id = id;
        this.jobDesc = jobDesc;
        this.maxLvl = new BigDecimal(maxLvl);
        this.minLvl = new BigDecimal(minLvl);
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJobDesc() {
        return this.jobDesc;
    }

    public void setJobDesc(String jobDesc) {
        this.jobDesc = jobDesc;
    }

    public BigDecimal getMaxLvl() {
        return this.maxLvl;
    }

    public void setMaxLvl(BigDecimal maxLvl) {
        this.maxLvl = maxLvl;
    }

    public BigDecimal getMinLvl() {
        return this.minLvl;
    }

    public void setMinLvl(BigDecimal minLvl) {
        this.minLvl = minLvl;
    }

    public List<Employee> getEmployees() {
        return this.employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public Employee addEmployee(Employee employee) {
        getEmployees().add(employee);
        employee.setJob(this);

        return employee;
    }

    public Employee removeEmployee(Employee employee) {
        getEmployees().remove(employee);
        employee.setJob(null);

        return employee;
    }
}

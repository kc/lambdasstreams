package com.example.streams.scottdb;

import java.time.LocalDate;

public class Employee {

    private final int id;
    private final Double commission;
    private final LocalDate hiredate;
    private final String name;
    private final String job;
    private final double salary;
    private final Integer managerId;
    private final int departmentId;
    private Employee manager;
    private Department department;

    public Employee(int id, Double commission, LocalDate hiredate, String name, String job, double salary, Integer managerId, int departmentId) {
        this.id = id;
        this.commission = commission;
        this.hiredate = hiredate;
        this.name = name;
        this.job = job;
        this.salary = salary;
        this.managerId = managerId;
        this.departmentId = departmentId;
    }

    public Integer getId() {
        return id;
    }

    Integer getManagerId() {
        return managerId;
    }

    public Double getCommission() {
        return commission;
    }

    public LocalDate getHiredate() {
        return hiredate;
    }

    public String getName() {
        return name;
    }

    public String getJob() {
        return job;
    }

    public double getSalary() {
        return salary;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public Employee getManager() {
        return null;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }

	public Department getDepartment() {
		return department;
	}

	public String getDepartmentName() {
        return department.getName();
    }

	public void setDepartment(Department department) {
		this.department = department;
	}

    @Override
    public String toString() {
        return "Employee [id=" + id + ", commission=" + commission
            + ", hiredate=" + hiredate + ", name=" + name + ", job=" + job
            + ", salary=" + salary + ", managerId=" + managerId
            + ", departmentId=" + departmentId + "]";
    }
}

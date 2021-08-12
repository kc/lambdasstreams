package com.example.streams.scottdb;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemoryScottDB {

    private final List<Department> departments;
    private final List<Employee> employees;
    private final List<SalaryGrades> salaryGrades;

    public MemoryScottDB() {
        this.departments = Arrays.asList(
            new Department(10, "ACCOUNTING", "NEW YORK"),
            new Department(20, "RESEARCH", "DALLAS"),
            new Department(30, "SALES", "CHICAGO"),
            new Department(40, "OPERATIONS", "BOSTON")
        );
        this.salaryGrades = Arrays.asList(
            new SalaryGrades(1, 1200, 700),
            new SalaryGrades(2, 1400, 1201),
            new SalaryGrades(3, 2000, 1401),
            new SalaryGrades(4, 3000, 2001),
            new SalaryGrades(5, 9999, 3001)
        );
        this.employees = setEmployees();
        setReferences();
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public List<SalaryGrades> getSalaryGrades() {
        return salaryGrades;
    }

    private List<Employee> setEmployees() {
        return Arrays.asList(
            new Employee(7839, null, LocalDate.of(1981, 11, 17), "KING", "PRESIDENT", 5000, null, 10),
            new Employee(7566, null, LocalDate.of(1981, 4, 2), "JONES", "MANAGER", 2975, 7839, 20),
            new Employee(7698, null, LocalDate.of(1981, 5, 1), "BLAKE", "MANAGER", 2850, 7839, 30),
            new Employee(7782, null, LocalDate.of(1981, 6, 9), "CLARK", "MANAGER", 2450, 7839, 10),
            new Employee(7902, null, LocalDate.of(1981, 12, 3), "FORD", "ANALYST", 3000, 7566, 20),
            new Employee(7788, null, LocalDate.of(1987, 4, 19), "SCOTT", "ANALYST", 3000, 7566, 20),
            new Employee(7369, null, LocalDate.of(1980, 12, 17), "SMITH", "CLERK", 800, 7902, 20),
            new Employee(7499, 300., LocalDate.of(1981, 2, 20), "ALLEN", "SALESMAN", 1600, 7698, 30),
            new Employee(7521, 500., LocalDate.of(1981, 2, 22), "WARD", "SALESMAN", 1250, 7698, 30),
            new Employee(7654, 1400., LocalDate.of(1981, 9, 28), "MARTIN", "SALESMAN", 1250, 7698, 30),
            new Employee(7844, 0., LocalDate.of(1981, 9, 8), "TURNER", "SALESMAN", 1500, 7698, 30),
            new Employee(7876, null, LocalDate.of(1987, 5, 23), "ADAMS", "CLERK", 1100, 7788, 20),
            new Employee(7900, null, LocalDate.of(1981, 12, 3), "JAMES", "CLERK", 950, 7698, 30),
            new Employee(7934, null, LocalDate.of(1982, 1, 23), "MILLER", "CLERK", 1300, 7782, 10)
        );
    }

    private void setReferences() {
        final Map<Integer, Employee> employeeById = new HashMap<>();
        for (Employee employee: employees) {
            employeeById.put(employee.getId(), employee);
            employee.setManager(employeeById.get(employee.getManagerId()));
            for(Department department: departments) {
                if (department.getId() == employee.getDepartmentId()) {
                    employee.setDepartment(department);
                    department.getEmployees().add(employee);
                }
            }
        }
    }
}

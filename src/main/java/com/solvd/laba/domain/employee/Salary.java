package com.solvd.laba.domain.employee;

public class Salary {
    private int employeeId;
    private double salary;

    public Salary(int employeeId, double salary) {
        this.employeeId = employeeId;
        this.salary = salary;
    }

    public Salary() {
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Salary{" +
                "employeeId=" + employeeId +
                ", salary=" + salary +
                '}';
    }
}

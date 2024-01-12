package com.solvd.laba.service.employeeService;

import com.solvd.laba.domain.employee.Employee;

import java.util.List;

public interface IEmployeeService {
    Employee getById(int id);
    List<Employee> getAllEmployees();
    void insert(Employee employee);
    void update(Employee employee);
    void delete(Employee employee);
}

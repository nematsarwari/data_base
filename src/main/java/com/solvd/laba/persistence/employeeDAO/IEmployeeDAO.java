package com.solvd.laba.persistence.employeeDAO;

import com.solvd.laba.domain.employee.Department;
import com.solvd.laba.domain.employee.Employee;

import java.util.List;

public interface IEmployeeDAO {
    Employee getById(int id);
    List<Employee> getAllEmployees();
    void insert(Employee employee);
    void update(Employee employee);
    void delete(Employee employee);
}

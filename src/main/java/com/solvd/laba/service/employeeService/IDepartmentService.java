package com.solvd.laba.service.employeeService;

import com.solvd.laba.domain.employee.Department;

import java.util.List;

public interface IDepartmentService {
    Department getById(int id);
    List<Department> getAllDepartments();
    void insert(Department department);
    void update(Department department);
    void delete(Department department);
}

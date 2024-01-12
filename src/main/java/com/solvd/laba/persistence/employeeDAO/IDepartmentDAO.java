package com.solvd.laba.persistence.employeeDAO;

import com.solvd.laba.domain.employee.Department;
import com.solvd.laba.domain.hospital.Hospital;

import java.util.List;

public interface IDepartmentDAO {
    Department getById(int id);
    List<Department> getAllDepartments();
    void insert(Department department);
    void update(Department department);
    void delete(Department department);
}

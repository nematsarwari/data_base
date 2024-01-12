package com.solvd.laba.persistence.employeeDAO;

import com.solvd.laba.domain.employee.Employee;
import com.solvd.laba.domain.employee.Salary;

import java.util.List;

public interface ISalaryDAO {
    Salary getById(int id);
    List<Salary> getAllSalaries();
    void insert(Salary salary);
    void update(Salary salary);
    void delete(Salary salary);
}

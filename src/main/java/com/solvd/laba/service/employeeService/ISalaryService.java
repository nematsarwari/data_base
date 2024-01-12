package com.solvd.laba.service.employeeService;

import com.solvd.laba.domain.employee.Salary;

import java.util.List;

public interface ISalaryService {
    Salary getById(int id);
    List<Salary> getAllSalaries();
    void insert(Salary salary);
    void update(Salary salary);
    void delete(Salary salary);
}

package com.solvd.laba.service.employeeService.employeeServiceImpl;

import com.solvd.laba.domain.employee.Employee;
import com.solvd.laba.persistence.employeeDAO.IEmployeeDAO;
import com.solvd.laba.persistence.employeeDAO.employeeDAOImpl.EmployeeDAOImpl;
import com.solvd.laba.service.employeeService.IEmployeeService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.invoke.MethodHandles;
import java.util.List;

public class EmployeeServiceImpl implements IEmployeeService {
    private static final Logger LOGGER = LogManager.getLogger(MethodHandles.lookup().lookupClass());
    private IEmployeeDAO iEmployeeDAO = new EmployeeDAOImpl();
    @Override
    public Employee getById(int id) {
        return iEmployeeDAO.getById(id);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return iEmployeeDAO.getAllEmployees();
    }

    @Override
    public void insert(Employee employee) {
        iEmployeeDAO.insert(employee);
    }

    @Override
    public void update(Employee employee) {
        iEmployeeDAO.update(employee);
    }

    @Override
    public void delete(Employee employee) {
        iEmployeeDAO.delete(employee);
    }
}

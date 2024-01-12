package com.solvd.laba.service.employeeService.employeeServiceImpl;

import com.solvd.laba.domain.employee.Department;
import com.solvd.laba.domain.employee.Employee;
import com.solvd.laba.domain.patient.Patient;
import com.solvd.laba.persistence.employeeDAO.IDepartmentDAO;
import com.solvd.laba.persistence.employeeDAO.IEmployeeDAO;
import com.solvd.laba.persistence.employeeDAO.employeeDAOImpl.DepartmentDAOImpl;
import com.solvd.laba.persistence.employeeDAO.employeeDAOImpl.EmployeeDAOImpl;
import com.solvd.laba.service.employeeService.IDepartmentService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.List;

public class DepartmentServiceImpl implements IDepartmentService {
    private static final Logger LOGGER = LogManager.getLogger(MethodHandles.lookup().lookupClass());
    private IDepartmentDAO iDepartmentDAO = new DepartmentDAOImpl();
    private IEmployeeDAO iEmployeeDAO = new EmployeeDAOImpl();
    @Override
    public Department getById(int id) {
        Department department = iDepartmentDAO.getById(id);
        List<Employee> employees = iEmployeeDAO.getAllEmployees();
        List<Employee> d = new ArrayList<>();
        for (Employee employee : employees) {
            if(employee.getDepartmentId() == id){
                d.add(employee);
            }
        }
        department.setEmployees(d);
        return department;
    }

    @Override
    public List<Department> getAllDepartments() {
        return iDepartmentDAO.getAllDepartments();
    }

    @Override
    public void insert(Department department) {
        iDepartmentDAO.insert(department);
    }

    @Override
    public void update(Department department) {
        iDepartmentDAO.update(department);
    }

    @Override
    public void delete(Department department) {
        iDepartmentDAO.delete(department);
    }
}

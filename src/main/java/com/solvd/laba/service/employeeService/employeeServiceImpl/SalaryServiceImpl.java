package com.solvd.laba.service.employeeService.employeeServiceImpl;

import com.solvd.laba.domain.employee.Salary;
import com.solvd.laba.persistence.employeeDAO.ISalaryDAO;
import com.solvd.laba.persistence.employeeDAO.employeeDAOImpl.SalaryDAOImpl;
import com.solvd.laba.service.employeeService.ISalaryService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.invoke.MethodHandles;
import java.util.List;

public class SalaryServiceImpl implements ISalaryService {
    private static final Logger LOGGER = LogManager.getLogger(MethodHandles.lookup().lookupClass());
    private ISalaryDAO iSalaryDAO = new SalaryDAOImpl();
    @Override
    public Salary getById(int id) {
        return iSalaryDAO.getById(id);
    }

    @Override
    public List<Salary> getAllSalaries() {
        return iSalaryDAO.getAllSalaries();
    }

    @Override
    public void insert(Salary salary) {
        iSalaryDAO.insert(salary);
    }

    @Override
    public void update(Salary salary) {
        iSalaryDAO.update(salary);
    }

    @Override
    public void delete(Salary salary) {
        iSalaryDAO.delete(salary);
    }
}

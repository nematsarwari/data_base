package com.solvd.laba.persistence.employeeDAO.employeeDAOImpl;

import com.solvd.laba.domain.employee.Department;
import com.solvd.laba.domain.employee.Salary;
import com.solvd.laba.persistence.ConnectionPool;
import com.solvd.laba.persistence.employeeDAO.ISalaryDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.invoke.MethodHandles;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SalaryDAOImpl implements ISalaryDAO {
    private  final Logger LOGGER = LogManager.getLogger(MethodHandles.lookup().lookupClass());
    private static final ConnectionPool CONNECTION_POOL = ConnectionPool.getInstance();
    private  final String GET_BY_ID_QUERY = "select * from Salaries where employee_id = ?";
    private  final String GET_ALL_QUERY = "SELECT * FROM salaries";
    private  final String CREATE_QUERY = "INSERT INTO salaries(employee_id, salary) VALUES (?, ?)";
    private  final String UPDATE_QUERY = "UPDATE salaries SET salary = ? WHERE employee_id = ?";
    private  final String DELETE_QUERY = "DELETE FROM salaries WHERE employee_id = ?";
    @Override
    public Salary getById(int id) {
        Connection con = CONNECTION_POOL.getConnection();
        Salary salary = new Salary();
        try {
            PreparedStatement ps = con.prepareStatement(GET_BY_ID_QUERY);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                salary.setEmployeeId(rs.getInt("employee_id"));
                salary.setSalary(rs.getDouble("salary"));
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        }finally{
            CONNECTION_POOL.releaseConnection(con);
        }
        return salary;
    }

    @Override
    public List<Salary> getAllSalaries() {
        Connection con = CONNECTION_POOL.getConnection();
        List<Salary> salaries = new ArrayList<>();
        try (PreparedStatement statement = con.prepareStatement(GET_ALL_QUERY);
             ResultSet rs = statement.executeQuery()) {
            while (rs.next()) {
                Salary salary = new Salary();
                salary.setEmployeeId(rs.getInt("employee_id"));
                salary.setSalary(rs.getDouble("salary"));
                salaries.add(salary);
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        }finally{
            CONNECTION_POOL.releaseConnection(con);
        }
        return salaries;
    }

    @Override
    public void insert(Salary salary) {
        Connection con = CONNECTION_POOL.getConnection();
        try {
            PreparedStatement ps = con.prepareStatement(CREATE_QUERY);
            ps.setInt(1, salary.getEmployeeId());
            ps.setDouble(2, salary.getSalary());
            ps.executeUpdate();
            LOGGER.info("Salary inserted");
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        } finally {
            CONNECTION_POOL.releaseConnection(con);
        }
    }

    @Override
    public void update(Salary salary) {
        Connection con = CONNECTION_POOL.getConnection();
        try {
            PreparedStatement ps  = con.prepareStatement(UPDATE_QUERY);
            ps.setDouble(1, salary.getSalary());
            ps.setInt(2, salary.getEmployeeId());
            ps.executeUpdate();
            LOGGER.info("Salary updated");
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        } finally {
            CONNECTION_POOL.releaseConnection(con);
        }
    }

    @Override
    public void delete(Salary salary) {
        Connection con = CONNECTION_POOL.getConnection();
        try {
            PreparedStatement ps = con.prepareStatement(DELETE_QUERY);
            ps.setInt(1, salary.getEmployeeId());
            ps.executeUpdate();
            LOGGER.info("one Salary deleted");
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        } finally {
            CONNECTION_POOL.releaseConnection(con);
        }
    }
}

package com.solvd.laba.persistence.employeeDAO.employeeDAOImpl;

import com.solvd.laba.domain.employee.Department;
import com.solvd.laba.domain.employee.Employee;
import com.solvd.laba.persistence.ConnectionPool;
import com.solvd.laba.persistence.employeeDAO.IEmployeeDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.invoke.MethodHandles;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements IEmployeeDAO {
    private  final Logger LOGGER = LogManager.getLogger(MethodHandles.lookup().lookupClass());
    private static final ConnectionPool CONNECTION_POOL = ConnectionPool.getInstance();
    private  final String GET_BY_ID_QUERY = "select * from employees where employee_id = ?";
    private  final String GET_ALL_QUERY = "SELECT * FROM Employees";
    private  final String CREATE_QUERY = "INSERT INTO Employees (employee_id, first_name, last_name, department_id, hospital_id) VALUES (?, ?, ?, ?, ?)";
    private  final String UPDATE_QUERY = "UPDATE Employees SET first_name = ?, last_name = ?, department_id = ?, hospital_id = ? WHERE employee_id = ?";
    private  final String DELETE_QUERY = "DELETE FROM Employees WHERE employee_id = ?";

    @Override
    public Employee getById(int id) {
        Connection con = CONNECTION_POOL.getConnection();
        Employee employee = new Employee();
        try {
            PreparedStatement ps = con.prepareStatement(GET_BY_ID_QUERY);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                employee.setEmployeeId(rs.getInt("employee_id"));
                employee.setFirstName(rs.getString("first_name"));
                employee.setLastName(rs.getString("last_name"));
                employee.setHospitalId(rs.getInt("department_id"));
                employee.setDepartmentId(rs.getInt("hospital_id"));
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        }finally{
            CONNECTION_POOL.releaseConnection(con);
        }
        return employee;
    }

    @Override
    public List<Employee> getAllEmployees() {
        Connection con = CONNECTION_POOL.getConnection();
        List<Employee> employees = new ArrayList<>();
        try (PreparedStatement statement = con.prepareStatement(GET_ALL_QUERY);
             ResultSet rs = statement.executeQuery()) {
            while (rs.next()) {
                Employee employee = new Employee();
                employee.setEmployeeId(rs.getInt("employee_id"));
                employee.setFirstName(rs.getString("first_name"));
                employee.setLastName(rs.getString("last_name"));
                employee.setHospitalId(rs.getInt("department_id"));
                employee.setDepartmentId(rs.getInt("hospital_id"));
                employees.add(employee);
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        }finally{
            CONNECTION_POOL.releaseConnection(con);
        }
        return employees;
    }

    @Override
    public void insert(Employee employee) {
        Connection con = CONNECTION_POOL.getConnection();
        try {
            PreparedStatement ps = con.prepareStatement(CREATE_QUERY);
            ps.setInt(1, employee.getEmployeeId());
            ps.setString(2, employee.getFirstName());
            ps.setString(3, employee.getLastName());
            ps.setInt(4, employee.getDepartmentId());
            ps.setInt(5, employee.getHospitalId());
            ps.executeUpdate();
            LOGGER.info("Employee inserted");
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        } finally {
            CONNECTION_POOL.releaseConnection(con);
        }
    }

    @Override
    public void update(Employee employee) {
        Connection con = CONNECTION_POOL.getConnection();
        try {
            PreparedStatement ps  = con.prepareStatement(UPDATE_QUERY);
            ps.setString(1, employee.getLastName());
            ps.setString(2, employee.getLastName());
            ps.setInt(3, employee.getDepartmentId());
            ps.setInt(4, employee.getHospitalId());
            ps.setInt(5, employee.getEmployeeId());
            ps.executeUpdate();
            LOGGER.info("Employee updated");
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        } finally {
            CONNECTION_POOL.releaseConnection(con);
        }
    }

    @Override
    public void delete(Employee employee) {
        Connection con = CONNECTION_POOL.getConnection();
        try {
            PreparedStatement ps = con.prepareStatement(DELETE_QUERY);
            ps.setInt(1, employee.getEmployeeId());
            ps.executeUpdate();
            LOGGER.info("one Employee deleted");
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        } finally {
            CONNECTION_POOL.releaseConnection(con);
        }
    }
}

package com.solvd.laba.persistence.employeeDAO.employeeDAOImpl;

import com.solvd.laba.domain.employee.Department;
import com.solvd.laba.domain.hospital.Hospital;
import com.solvd.laba.persistence.ConnectionPool;
import com.solvd.laba.persistence.employeeDAO.IDepartmentDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.invoke.MethodHandles;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDAOImpl implements IDepartmentDAO {
    private  final Logger LOGGER = LogManager.getLogger(MethodHandles.lookup().lookupClass());
    private static final ConnectionPool CONNECTION_POOL = ConnectionPool.getInstance();
    private  final String GET_BY_ID_QUERY = "select * from departments where department_id = ?";
    private  final String GET_ALL_QUERY = "SELECT * FROM departments";
    private  final String CREATE_QUERY = "INSERT INTO departments (department_id, department_name) VALUES (?, ?)";
    private  final String UPDATE_QUERY = "UPDATE departments SET department_name = ? WHERE department_id = ?";
    private  final String DELETE_QUERY = "DELETE FROM departments WHERE department_id = ?";
    private  final String GET_LIST_EMPLOYEES = "JOIN employees e ON d.department_id = e.department_id WHERE d.department_id = ?";

    @Override
    public Department getById(int id) {
        Connection con = CONNECTION_POOL.getConnection();
        Department department = new Department();
        try {
            PreparedStatement ps = con.prepareStatement(GET_BY_ID_QUERY);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                department.setDepartmentId(rs.getInt("department_id"));
                department.setDepartmentName(rs.getString("department_name"));
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        }finally{
            CONNECTION_POOL.releaseConnection(con);
        }
        return department;
    }

    @Override
    public List<Department> getAllDepartments() {
        Connection con = CONNECTION_POOL.getConnection();
        List<Department> departments = new ArrayList<>();
        try (PreparedStatement statement = con.prepareStatement(GET_ALL_QUERY);
             ResultSet rs = statement.executeQuery()) {
            while (rs.next()) {
                Department department = new Department();
                department.setDepartmentId(rs.getInt("department_id"));
                department.setDepartmentName(rs.getString("department_name"));
                departments.add(department);
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        }finally{
            CONNECTION_POOL.releaseConnection(con);
        }
        return departments;
    }

    @Override
    public void insert(Department department) {
        Connection con = CONNECTION_POOL.getConnection();
        try {
            PreparedStatement ps = con.prepareStatement(CREATE_QUERY);
            ps.setInt(1, department.getDepartmentId());
            ps.setString(2, department.getDepartmentName());
            ps.executeUpdate();
            LOGGER.info("Department inserted");
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        } finally {
            CONNECTION_POOL.releaseConnection(con);
        }
    }

    @Override
    public void update(Department department) {
        Connection con = CONNECTION_POOL.getConnection();
        try {
            PreparedStatement ps  = con.prepareStatement(UPDATE_QUERY);
            ps.setString(1, department.getDepartmentName());
            ps.setInt(2, department.getDepartmentId());
            ps.executeUpdate();
            LOGGER.info("Department updated");
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        } finally {
            CONNECTION_POOL.releaseConnection(con);
        }
    }

    @Override
    public void delete(Department department) {
        Connection con = CONNECTION_POOL.getConnection();
        try {
            PreparedStatement ps = con.prepareStatement(DELETE_QUERY);
            ps.setInt(1, department.getDepartmentId());
            ps.executeUpdate();
            LOGGER.info("one Department deleted");
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        } finally {
            CONNECTION_POOL.releaseConnection(con);
        }
    }
}

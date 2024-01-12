package com.solvd.laba.persistence.hospitalDAO.hospitalDAOImpl;

import com.solvd.laba.domain.employee.Employee;
import com.solvd.laba.domain.hospital.Hospital;
import com.solvd.laba.domain.patient.Patient;
import com.solvd.laba.persistence.ConnectionPool;
import com.solvd.laba.persistence.hospitalDAO.IHospitalDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.invoke.MethodHandles;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HospitalDAOImpl implements IHospitalDAO {
    private  final Logger LOGGER = LogManager.getLogger(MethodHandles.lookup().lookupClass());
    private static final ConnectionPool CONNECTION_POOL = ConnectionPool.getInstance();
    private  final String GET_BY_ID_QUERY = "select * from hospitals where id = ?";
    private  final String GET_ALL_QUERY = "SELECT * FROM hospitals";
    private  final String CREATE_QUERY = "insert into hospitals(id, hospital_name) values (?, ?)";
    private  final String UPDATE_QUERY = "UPDATE hospitals SET hospital_name = ? WHERE id = ?";
    private  final String DELETE_QUERY = "DELETE FROM hospitals WHERE id = ?";
    private final String GET_LIST_EMPLOYEES = "SELECT * FROM hospitals h JOIN employees e ON h.id = e.hospital_id WHERE h.id = ?";
    private  final String GET_LIST_PATIENTS = "SELECT * FROM hospitals h JOIN patients p ON h.id = p.hospital_id WHERE h.id = ?";
    public List<Employee> getEmployeesByHospitalId(int hospitalId){
        Connection con = CONNECTION_POOL.getConnection();
        List<Employee> employees = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(GET_LIST_EMPLOYEES);
            ps.setInt(1, hospitalId);
            ResultSet rs = ps.executeQuery();
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
    public List<Patient> getPatientsByHospitalId(int hospitalId){
        Connection con = CONNECTION_POOL.getConnection();
        List<Patient> patients = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(GET_LIST_PATIENTS);
            ps.setInt(1, hospitalId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Patient patient = new Patient();
                patient.setPatientId(rs.getInt("patient_id"));
                patient.setFirstName(rs.getString("first_name"));
                patient.setLastName(rs.getString("last_name"));
                patient.setHospitalId(rs.getInt("hospital_id"));
                patients.add(patient);
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        }finally{
            CONNECTION_POOL.releaseConnection(con);
        }
        return patients;
    }
    @Override
    public Hospital getById(int id) {

        Connection con = CONNECTION_POOL.getConnection();
        Hospital hospital = new Hospital();
        try {
        PreparedStatement ps = con.prepareStatement(GET_BY_ID_QUERY);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            hospital.setHospitalId(rs.getInt("id"));
            hospital.setHospitalName(rs.getString("hospital_name"));
        }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        }finally{
            CONNECTION_POOL.releaseConnection(con);
        }
        return hospital;
    }

    @Override
    public List<Hospital> getAllHospitals() {
        Connection con = CONNECTION_POOL.getConnection();
        List<Hospital> hospitals = new ArrayList<>();
        try (PreparedStatement statement = con.prepareStatement(GET_ALL_QUERY);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Hospital hospital = new Hospital();
                hospital.setHospitalId(resultSet.getInt("id"));
                hospital.setHospitalName(resultSet.getString("hospital_name"));
                hospitals.add(hospital);
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        }finally{
            CONNECTION_POOL.releaseConnection(con);
        }
        return hospitals;
    }

    @Override
    public void insert(Hospital hospital) {
        Connection con = CONNECTION_POOL.getConnection();
        try {
            PreparedStatement ps = con.prepareStatement(CREATE_QUERY);
            ps.setInt(1, hospital.getHospitalId());
            ps.setString(2, hospital.getHospitalName());
            ps.executeUpdate();
            LOGGER.info("Hospital inserted");
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        } finally {
            CONNECTION_POOL.releaseConnection(con);
        }
    }

    @Override
    public void update(Hospital hospital) {
        Connection con = CONNECTION_POOL.getConnection();
        try {
            PreparedStatement ps  = con.prepareStatement(UPDATE_QUERY);
            ps.setString(1, hospital.getHospitalName());
            ps.setInt(2, hospital.getHospitalId());
            ps.executeUpdate();
            LOGGER.info("Hospital updated");
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        } finally {
            CONNECTION_POOL.releaseConnection(con);
        }
    }

    @Override
    public void delete(Hospital hospital) {
        Connection con = CONNECTION_POOL.getConnection();
        try {
            PreparedStatement ps = con.prepareStatement(DELETE_QUERY);
            ps.setInt(1, hospital.getHospitalId());
            ps.executeUpdate();
            LOGGER.info("one Hospital deleted");
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        } finally {
            CONNECTION_POOL.releaseConnection(con);
        }
    }
}

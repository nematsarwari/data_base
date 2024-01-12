package com.solvd.laba.persistence.patientDAO.patientDAOImpl;

import com.solvd.laba.domain.patient.Patient;
import com.solvd.laba.persistence.ConnectionPool;
import com.solvd.laba.persistence.patientDAO.IPatientDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.invoke.MethodHandles;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PatientDAOImpl implements IPatientDAO {
    private  final Logger LOGGER = LogManager.getLogger(MethodHandles.lookup().lookupClass());
    private static final ConnectionPool CONNECTION_POOL = ConnectionPool.getInstance();
    private  final String GET_BY_ID_QUERY = "select * from patients where patient_id = ?";
    private  final String GET_ALL_QUERY = "SELECT * FROM patients";
    private  final String CREATE_QUERY = "INSERT INTO patients (patient_id, first_name, last_name, hospital_id) VALUES (?, ?, ?, ?)";
    private  final String UPDATE_QUERY = "UPDATE patients SET first_name = ?, last_name = ?, hospital_id = ? WHERE patient_id = ?";
    private  final String DELETE_QUERY = "DELETE FROM patients WHERE patient_id = ?";
    private  final String GET_LIST_APPOINTMENTS = "SELECT * FROM patients p LEFT JOIN appointments a ON p.patient_id = a.patient_id WHERE p.patient_id = ?";
    private  final String GET_LIST_MEDICATIONS = "SELECT * FROM patients p JOIN medications m ON p.patient_id = m.patient_id WHERE p.patient_id = ?";
    private  final String GET_LIST_BILLS = "SELECT * FROM patients p LEFT JOIN billings b ON p.patient_id = b.patient_id WHERE p.patient_id = ?";

    @Override
    public Patient getById(int id) {
        Connection con = CONNECTION_POOL.getConnection();
        Patient patient = new Patient();
        try {
            PreparedStatement ps = con.prepareStatement(GET_BY_ID_QUERY);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                patient.setPatientId(rs.getInt("patient_id"));
                patient.setFirstName(rs.getString("first_name"));
                patient.setLastName(rs.getString("last_name"));
                patient.setHospitalId(rs.getInt("hospital_id"));
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        }finally{
            CONNECTION_POOL.releaseConnection(con);
        }
        return patient;
    }

    @Override
    public List<Patient> getAllPatients() {
        Connection con = CONNECTION_POOL.getConnection();
        List<Patient> patients = new ArrayList<>();
        try (PreparedStatement statement = con.prepareStatement(GET_ALL_QUERY);
             ResultSet rs = statement.executeQuery()) {
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
    public void insert(Patient patient) {
        Connection con = CONNECTION_POOL.getConnection();
        try {
            PreparedStatement ps = con.prepareStatement(CREATE_QUERY);
            ps.setInt(1, patient.getPatientId());
            ps.setString(2, patient.getFirstName());
            ps.setString(3, patient.getLastName());
            ps.setInt(4, patient.getHospitalId());
            ps.executeUpdate();
            LOGGER.info("Patient inserted");
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        } finally {
            CONNECTION_POOL.releaseConnection(con);
        }
    }

    @Override
    public void update(Patient patient) {
        Connection con = CONNECTION_POOL.getConnection();
        try {
            PreparedStatement ps  = con.prepareStatement(UPDATE_QUERY);
            ps.setString(1, patient.getFirstName());
            ps.setString(2, patient.getLastName());
            ps.setInt(3, patient.getHospitalId());
            ps.setInt(4, patient.getPatientId());
            ps.executeUpdate();
            LOGGER.info("Patient updated");
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        } finally {
            CONNECTION_POOL.releaseConnection(con);
        }
    }

    @Override
    public void delete(Patient patient) {
        Connection con = CONNECTION_POOL.getConnection();
        try {
            PreparedStatement ps = con.prepareStatement(DELETE_QUERY);
            ps.setInt(1, patient.getPatientId());
            ps.executeUpdate();
            LOGGER.info("one Patient deleted");
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        } finally {
            CONNECTION_POOL.releaseConnection(con);
        }
    }
}

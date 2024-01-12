package com.solvd.laba.persistence.patientDAO.patientDAOImpl;

import com.solvd.laba.domain.patient.Appointment;
import com.solvd.laba.domain.patient.LaboratoryTest;
import com.solvd.laba.domain.patient.Medication;
import com.solvd.laba.persistence.ConnectionPool;
import com.solvd.laba.persistence.patientDAO.IMedicationDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.invoke.MethodHandles;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MedicationDAOImpl implements IMedicationDAO {
    private  final Logger LOGGER = LogManager.getLogger(MethodHandles.lookup().lookupClass());
    private static final ConnectionPool CONNECTION_POOL = ConnectionPool.getInstance();
    private  final String GET_BY_ID_QUERY = "select * from medications where id = ?";
    private  final String GET_ALL_QUERY = "SELECT * FROM medications";
    private  final String CREATE_QUERY = "INSERT INTO medications (id, medication_name, medication_details, patient_id) VALUES (?, ?, ?, ?)";
    private  final String UPDATE_QUERY = "UPDATE medications SET medication_name = ?, medication_details = ?, patient_id = ? WHERE id = ?";
    private  final String DELETE_QUERY = "DELETE FROM medications WHERE id = ?";
    @Override
    public Medication getById(int id) {
        Connection con = CONNECTION_POOL.getConnection();
        Medication medication = new Medication();
        try {
            PreparedStatement ps = con.prepareStatement(GET_BY_ID_QUERY);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                medication.setMedicationId(rs.getInt("id"));
                medication.setMedicationName(rs.getString("medication_name"));
                medication.setMedicationDetail(rs.getString("medication_details"));
                medication.setPatientId(rs.getInt("patient_id"));
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        }finally{
            CONNECTION_POOL.releaseConnection(con);
        }
        return medication;
    }

    @Override
    public List<Medication> getAllMedications() {
        Connection con = CONNECTION_POOL.getConnection();
        List<Medication> medications = new ArrayList<>();
        try (PreparedStatement statement = con.prepareStatement(GET_ALL_QUERY);
             ResultSet rs = statement.executeQuery()) {
            while (rs.next()) {
                Medication medication = new Medication();
                medication.setMedicationId(rs.getInt("id"));
                medication.setMedicationName(rs.getString("medication_name"));
                medication.setMedicationDetail(rs.getString("medication_details"));
                medication.setPatientId(rs.getInt("patient_id"));
                medications.add(medication);
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        }finally{
            CONNECTION_POOL.releaseConnection(con);
        }
        return medications;
    }

    @Override
    public void insert(Medication medication) {
        Connection con = CONNECTION_POOL.getConnection();
        try {
            PreparedStatement ps = con.prepareStatement(CREATE_QUERY);
            ps.setInt(1, medication.getMedicationId());
            ps.setString(2, medication.getMedicationName());
            ps.setString(3, medication.getMedicationDetail());
            ps.setInt(4, medication.getPatientId());
            ps.executeUpdate();
            LOGGER.info("Medication inserted");
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        } finally {
            CONNECTION_POOL.releaseConnection(con);
        }
    }

    @Override
    public void update(Medication medication) {
        Connection con = CONNECTION_POOL.getConnection();
        try {
            PreparedStatement ps  = con.prepareStatement(UPDATE_QUERY);
            ps.setString(1, medication.getMedicationName());
            ps.setString(2, medication.getMedicationDetail());
            ps.setInt(3, medication.getPatientId());
            ps.setInt(4, medication.getMedicationId());
            ps.executeUpdate();
            LOGGER.info("Medication updated");
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        } finally {
            CONNECTION_POOL.releaseConnection(con);
        }
    }

    @Override
    public void delete(Medication medication) {
        Connection con = CONNECTION_POOL.getConnection();
        try {
            PreparedStatement ps = con.prepareStatement(DELETE_QUERY);
            ps.setInt(1, medication.getMedicationId());
            ps.executeUpdate();
            LOGGER.info("one Medication deleted");
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        } finally {
            CONNECTION_POOL.releaseConnection(con);
        }
    }
}

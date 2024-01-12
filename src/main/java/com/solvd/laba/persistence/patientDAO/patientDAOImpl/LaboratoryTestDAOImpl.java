package com.solvd.laba.persistence.patientDAO.patientDAOImpl;

import com.solvd.laba.domain.patient.Billing;
import com.solvd.laba.domain.patient.LaboratoryTest;
import com.solvd.laba.persistence.ConnectionPool;
import com.solvd.laba.persistence.patientDAO.ILaboratoryTestDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.invoke.MethodHandles;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LaboratoryTestDAOImpl implements ILaboratoryTestDAO {
    private  final Logger LOGGER = LogManager.getLogger(MethodHandles.lookup().lookupClass());
    private static final ConnectionPool CONNECTION_POOL = ConnectionPool.getInstance();
    private  final String GET_BY_ID_QUERY = "select * from laboratory_tests where id = ?";
    private  final String GET_ALL_QUERY = "SELECT * FROM laboratory_tests";
    private  final String CREATE_QUERY = "INSERT INTO laboratory_tests (id, test_details, patient_id) VALUES (?, ?, ?)";
    private  final String UPDATE_QUERY = "UPDATE laboratory_tests SET test_details = ?, patient_id = ? WHERE id = ?";
    private  final String DELETE_QUERY = "DELETE FROM laboratory_tests WHERE id = ?";
    @Override
    public LaboratoryTest getById(int id) {
        Connection con = CONNECTION_POOL.getConnection();
        LaboratoryTest laboratoryTest = new LaboratoryTest();
        try {
            PreparedStatement ps = con.prepareStatement(GET_BY_ID_QUERY);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                laboratoryTest.setId(rs.getInt("id"));
                laboratoryTest.setTestDetails(rs.getString("test_details"));
                laboratoryTest.setPatientId(rs.getInt("patient_id"));
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        }finally{
            CONNECTION_POOL.releaseConnection(con);
        }
        return laboratoryTest;
    }

    @Override
    public List<LaboratoryTest> getAllLaboratoryTests() {
        Connection con = CONNECTION_POOL.getConnection();
        List<LaboratoryTest> laboratoryTests = new ArrayList<>();
        try (PreparedStatement statement = con.prepareStatement(GET_ALL_QUERY);
             ResultSet rs = statement.executeQuery()) {
            while (rs.next()) {
                LaboratoryTest laboratoryTest = new LaboratoryTest();
                laboratoryTest.setId(rs.getInt("id"));
                laboratoryTest.setTestDetails(rs.getString("test_details"));
                laboratoryTest.setPatientId(rs.getInt("patient_id"));
                laboratoryTests.add(laboratoryTest);
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        }finally{
            CONNECTION_POOL.releaseConnection(con);
        }
        return laboratoryTests;
    }

    @Override
    public void insert(LaboratoryTest laboratoryTest) {
        Connection con = CONNECTION_POOL.getConnection();
        try {
            PreparedStatement ps = con.prepareStatement(CREATE_QUERY);
            ps.setInt(1, laboratoryTest.getId());
            ps.setString(2, laboratoryTest.getTestDetails());
            ps.setInt(3, laboratoryTest.getPatientId());
            ps.executeUpdate();
            LOGGER.info("LaboratoryTest inserted");
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        } finally {
            CONNECTION_POOL.releaseConnection(con);
        }
    }

    @Override
    public void update(LaboratoryTest laboratoryTest) {
        Connection con = CONNECTION_POOL.getConnection();
        try {
            PreparedStatement ps  = con.prepareStatement(UPDATE_QUERY);
            ps.setString(1, laboratoryTest.getTestDetails());
            ps.setInt(2, laboratoryTest.getPatientId());
            ps.setInt(3, laboratoryTest.getPatientId());
            ps.executeUpdate();
            LOGGER.info("LaboratoryTest updated");
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        } finally {
            CONNECTION_POOL.releaseConnection(con);
        }
    }

    @Override
    public void delete(LaboratoryTest laboratoryTest) {
        Connection con = CONNECTION_POOL.getConnection();
        try {
            PreparedStatement ps = con.prepareStatement(DELETE_QUERY);
            ps.setInt(1, laboratoryTest.getId());
            ps.executeUpdate();
            LOGGER.info("one LaboratoryTest deleted");
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        } finally {
            CONNECTION_POOL.releaseConnection(con);
        }
    }
}

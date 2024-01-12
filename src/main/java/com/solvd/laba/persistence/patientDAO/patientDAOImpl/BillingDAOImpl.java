package com.solvd.laba.persistence.patientDAO.patientDAOImpl;

import com.solvd.laba.domain.patient.Appointment;
import com.solvd.laba.domain.patient.Billing;
import com.solvd.laba.persistence.ConnectionPool;
import com.solvd.laba.persistence.patientDAO.IBillingDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.invoke.MethodHandles;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BillingDAOImpl implements IBillingDAO {
    private  final Logger LOGGER = LogManager.getLogger(MethodHandles.lookup().lookupClass());
    private static final ConnectionPool CONNECTION_POOL = ConnectionPool.getInstance();
    private  final String GET_BY_ID_QUERY = "select * from billings where bill_number = ?";
    private  final String GET_ALL_QUERY = "SELECT * FROM billings";
    private  final String CREATE_QUERY = "INSERT INTO billings (bill_number, bill_details, amount, patient_id) VALUES (?, ?, ?, ?)";
    private  final String UPDATE_QUERY = "UPDATE billings SET bill_details = ?, amount = ?, patient_id = ? WHERE bill_number = ?";
    private  final String DELETE_QUERY = "DELETE FROM billings WHERE bill_number = ?";
    @Override
    public Billing getById(int id) {
        Connection con = CONNECTION_POOL.getConnection();
        Billing billing = new Billing();
        try {
            PreparedStatement ps = con.prepareStatement(GET_BY_ID_QUERY);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                billing.setBillNumber(rs.getInt("bill_number"));
                billing.setBillDetails(rs.getString("bill_details"));
                billing.setAmount(rs.getDouble("amount"));
                billing.setPatientId(rs.getInt("patient_id"));
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        }finally{
            CONNECTION_POOL.releaseConnection(con);
        }
        return billing;
    }

    @Override
    public List<Billing> getAllBillings() {
        Connection con = CONNECTION_POOL.getConnection();
        List<Billing> billings = new ArrayList<>();
        try (PreparedStatement statement = con.prepareStatement(GET_ALL_QUERY);
             ResultSet rs = statement.executeQuery()) {
            while (rs.next()) {
                Billing billing = new Billing();
                billing.setBillNumber(rs.getInt("bill_number"));
                billing.setBillDetails(rs.getString("bill_details"));
                billing.setAmount(rs.getDouble("amount"));
                billing.setPatientId(rs.getInt("patient_id"));
                billings.add(billing);
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        }finally{
            CONNECTION_POOL.releaseConnection(con);
        }
        return billings;
    }

    @Override
    public void insert(Billing billing) {
        Connection con = CONNECTION_POOL.getConnection();
        try {
            PreparedStatement ps = con.prepareStatement(CREATE_QUERY);
            ps.setInt(1, billing.getBillNumber());
            ps.setString(2, billing.getBillDetails());
            ps.setDouble(3, billing.getAmount());
            ps.setInt(4, billing.getPatientId());
            ps.executeUpdate();
            LOGGER.info("Bill inserted");
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        } finally {
            CONNECTION_POOL.releaseConnection(con);
        }
    }

    @Override
    public void update(Billing billing) {
        Connection con = CONNECTION_POOL.getConnection();
        try {
            PreparedStatement ps  = con.prepareStatement(UPDATE_QUERY);
            ps.setString(1, billing.getBillDetails());
            ps.setDouble(2, billing.getAmount());
            ps.setInt(3, billing.getPatientId());
            ps.setInt(4, billing.getBillNumber());
            ps.executeUpdate();
            LOGGER.info("Bill updated");
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        } finally {
            CONNECTION_POOL.releaseConnection(con);
        }
    }

    @Override
    public void delete(Billing billing) {
        Connection con = CONNECTION_POOL.getConnection();
        try {
            PreparedStatement ps = con.prepareStatement(DELETE_QUERY);
            ps.setInt(1, billing.getBillNumber());
            ps.executeUpdate();
            LOGGER.info("one Bill deleted");
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        } finally {
            CONNECTION_POOL.releaseConnection(con);
        }
    }
}

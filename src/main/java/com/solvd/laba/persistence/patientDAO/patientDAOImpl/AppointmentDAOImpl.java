package com.solvd.laba.persistence.patientDAO.patientDAOImpl;

import com.solvd.laba.domain.employee.Salary;
import com.solvd.laba.domain.hospital.Hospital;
import com.solvd.laba.domain.patient.Appointment;
import com.solvd.laba.persistence.ConnectionPool;
import com.solvd.laba.persistence.patientDAO.IAppointmentDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.invoke.MethodHandles;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AppointmentDAOImpl implements IAppointmentDAO {
    private  final Logger LOGGER = LogManager.getLogger(MethodHandles.lookup().lookupClass());
    private static final ConnectionPool CONNECTION_POOL = ConnectionPool.getInstance();
    private  final String GET_BY_ID_QUERY = "select * from appointments where id = ?";
    private  final String CREATE_QUERY = "INSERT INTO appointments (id, appointment_details, patient_id) VALUES (?, ?, ?)";
    private  final String UPDATE_QUERY = "UPDATE appointments SET appointment_details = ?, patient_id = ? WHERE id = ?";
    private  final String DELETE_QUERY = "DELETE FROM appointments WHERE id = ?";
    private  final String GET_ALL_QUERY = "SELECT * FROM appointments";

    @Override
    public Appointment getById(int id) {
        Connection con = CONNECTION_POOL.getConnection();
        Appointment appointment = new Appointment();
        try {
            PreparedStatement ps = con.prepareStatement(GET_BY_ID_QUERY);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                appointment.setAppointmentId(rs.getInt("id"));
                appointment.setAppointmentDetails(rs.getString("appointment_details"));
                appointment.setPatientId(rs.getInt("patient_id"));
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        }finally{
            CONNECTION_POOL.releaseConnection(con);
        }

        return appointment;
    }

    @Override
    public List<Appointment> getAllAppointments() {
        Connection con = CONNECTION_POOL.getConnection();
        List<Appointment> appointments = new ArrayList<>();
        try (PreparedStatement statement = con.prepareStatement(GET_ALL_QUERY);
             ResultSet rs = statement.executeQuery()) {
            while (rs.next()) {
                Appointment appointment = new Appointment();
                appointment.setAppointmentId(rs.getInt("id"));
                appointment.setAppointmentDetails(rs.getString("appointment_details"));
                appointment.setPatientId(rs.getInt("patient_id"));
                appointments.add(appointment);
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        }finally{
            CONNECTION_POOL.releaseConnection(con);
        }
        return appointments;
    }

    @Override
    public void insert(Appointment appointment) {
        Connection con = CONNECTION_POOL.getConnection();
        try {
            PreparedStatement ps = con.prepareStatement(CREATE_QUERY);
            ps.setInt(1, appointment.getAppointmentId());
            ps.setString(2, appointment.getAppointmentDetails());
            ps.setInt(3, appointment.getPatientId());
            ps.executeUpdate();
            LOGGER.info("Appointment inserted");
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        } finally {
            CONNECTION_POOL.releaseConnection(con);
        }
    }

    @Override
    public void update(Appointment appointment) {
        Connection con = CONNECTION_POOL.getConnection();
        try {
            PreparedStatement ps  = con.prepareStatement(UPDATE_QUERY);
            ps.setString(1, appointment.getAppointmentDetails());
            ps.setInt(2, appointment.getPatientId());
            ps.setInt(3, appointment.getAppointmentId());
            ps.executeUpdate();
            LOGGER.info("Appointment updated");
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        } finally {
            CONNECTION_POOL.releaseConnection(con);
        }
    }

    @Override
    public void delete(Appointment appointment) {
        Connection con = CONNECTION_POOL.getConnection();
        try {
            PreparedStatement ps = con.prepareStatement(DELETE_QUERY);
            ps.setInt(1, appointment.getAppointmentId());
            ps.executeUpdate();
            LOGGER.info("one Appointment deleted");
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        } finally {
            CONNECTION_POOL.releaseConnection(con);
        }
    }
}

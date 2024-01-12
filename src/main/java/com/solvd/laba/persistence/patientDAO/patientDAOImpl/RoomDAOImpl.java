package com.solvd.laba.persistence.patientDAO.patientDAOImpl;

import com.solvd.laba.domain.patient.Appointment;
import com.solvd.laba.domain.patient.Patient;
import com.solvd.laba.domain.patient.Room;
import com.solvd.laba.persistence.ConnectionPool;
import com.solvd.laba.persistence.patientDAO.IRoomDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.invoke.MethodHandles;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoomDAOImpl implements IRoomDAO {
    private  final Logger LOGGER = LogManager.getLogger(MethodHandles.lookup().lookupClass());
    private static final ConnectionPool CONNECTION_POOL = ConnectionPool.getInstance();
    private  final String GET_BY_ID_QUERY = "select * from rooms where room_number = ?";
    private  final String GET_ALL_QUERY = "SELECT * FROM rooms";
    private  final String CREATE_QUERY = "INSERT INTO rooms (room_number, patient_id) VALUES (?, ?)";
    private  final String UPDATE_QUERY = "UPDATE rooms SET patient_id = ? WHERE room_number = ?";
    private  final String DELETE_QUERY = "DELETE FROM rooms WHERE room_number = ?";
    @Override
    public Room getById(int id) {
        Connection con = CONNECTION_POOL.getConnection();
        Room room = new Room();
        try {
            PreparedStatement ps = con.prepareStatement(GET_BY_ID_QUERY);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                room.setPatientId(rs.getInt("room_number"));
                room.setPatientId(rs.getInt("patient_id"));
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        }finally{
            CONNECTION_POOL.releaseConnection(con);
        }
        return room;
    }

    @Override
    public List<Room> getAllRooms() {
        Connection con = CONNECTION_POOL.getConnection();
        List<Room> rooms = new ArrayList<>();
        try (PreparedStatement statement = con.prepareStatement(GET_ALL_QUERY);
             ResultSet rs = statement.executeQuery()) {
            while (rs.next()) {
                Room room = new Room();
                room.setPatientId(rs.getInt("room_number"));
                room.setPatientId(rs.getInt("patient_id"));
                rooms.add(room);
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        }finally{
            CONNECTION_POOL.releaseConnection(con);
        }
        return rooms;
    }

    @Override
    public void insert(Room room) {
        Connection con = CONNECTION_POOL.getConnection();
        try {
            PreparedStatement ps = con.prepareStatement(CREATE_QUERY);
            ps.setInt(1, room.getRoomNumber());
            ps.setInt(2, room.getPatientId());
            ps.executeUpdate();
            LOGGER.info("Room inserted");
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        } finally {
            CONNECTION_POOL.releaseConnection(con);
        }
    }

    @Override
    public void update(Room room) {
        Connection con = CONNECTION_POOL.getConnection();
        try {
            PreparedStatement ps  = con.prepareStatement(UPDATE_QUERY);
            ps.setInt(1, room.getPatientId());
            ps.setInt(2, room.getRoomNumber());
            ps.executeUpdate();
            LOGGER.info("Room updated");
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        } finally {
            CONNECTION_POOL.releaseConnection(con);
        }
    }

    @Override
    public void delete(Room room) {
        Connection con = CONNECTION_POOL.getConnection();
        try {
            PreparedStatement ps = con.prepareStatement(DELETE_QUERY);
            ps.setInt(1, room.getRoomNumber());
            ps.executeUpdate();
            LOGGER.info("one Room deleted");
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        } finally {
            CONNECTION_POOL.releaseConnection(con);
        }
    }
}

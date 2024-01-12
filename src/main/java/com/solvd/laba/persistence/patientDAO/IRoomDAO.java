package com.solvd.laba.persistence.patientDAO;

import com.solvd.laba.domain.patient.Patient;
import com.solvd.laba.domain.patient.Room;

import java.util.List;

public interface IRoomDAO {
    Room getById(int id);
    List<Room> getAllRooms();
    void insert(Room room);
    void update(Room room);
    void delete(Room room);
}

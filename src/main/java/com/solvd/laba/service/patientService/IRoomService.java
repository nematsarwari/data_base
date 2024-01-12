package com.solvd.laba.service.patientService;

import com.solvd.laba.domain.patient.Room;

import java.util.List;

public interface IRoomService {
    Room getById(int id);
    List<Room> getAllRooms();
    void insert(Room room);
    void update(Room room);
    void delete(Room room);
} 

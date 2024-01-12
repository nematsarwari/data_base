package com.solvd.laba.service.patientService.patientServiceImpl;

import com.solvd.laba.domain.patient.Room;
import com.solvd.laba.persistence.patientDAO.IRoomDAO;
import com.solvd.laba.persistence.patientDAO.patientDAOImpl.RoomDAOImpl;
import com.solvd.laba.service.patientService.IRoomService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.invoke.MethodHandles;
import java.util.List;

public class RoomServiceImpl implements IRoomService {
    private static final Logger LOGGER = LogManager.getLogger(MethodHandles.lookup().lookupClass());
    private IRoomDAO iRoomDAO = new RoomDAOImpl();
    @Override
    public Room getById(int id) {
        return iRoomDAO.getById(id);
    }

    @Override
    public List<Room> getAllRooms() {
        return iRoomDAO.getAllRooms();
    }

    @Override
    public void insert(Room room) {
        iRoomDAO.insert(room);
    }

    @Override
    public void update(Room room) {
        iRoomDAO.update(room);
    }

    @Override
    public void delete(Room room) {
        iRoomDAO.delete(room);

    }
}

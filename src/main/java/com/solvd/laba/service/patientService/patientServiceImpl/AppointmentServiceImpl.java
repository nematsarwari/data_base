package com.solvd.laba.service.patientService.patientServiceImpl;

import com.solvd.laba.domain.patient.Appointment;
import com.solvd.laba.persistence.patientDAO.IAppointmentDAO;
import com.solvd.laba.persistence.patientDAO.patientDAOImpl.AppointmentDAOImpl;
import com.solvd.laba.service.patientService.IAppointmentService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.invoke.MethodHandles;
import java.util.List;

public class AppointmentServiceImpl implements IAppointmentService {
    private static final Logger LOGGER = LogManager.getLogger(MethodHandles.lookup().lookupClass());
    private IAppointmentDAO iAppointmentDAO = new AppointmentDAOImpl();
    @Override
    public Appointment getById(int id) {
        return iAppointmentDAO.getById(id);
    }

    @Override
    public List<Appointment> getAllAppointments() {
        return iAppointmentDAO.getAllAppointments();
    }

    @Override
    public void insert(Appointment appointment) {
        iAppointmentDAO.insert(appointment);
    }

    @Override
    public void update(Appointment appointment) {
        iAppointmentDAO.update(appointment);
    }

    @Override
    public void delete(Appointment appointment) {
        iAppointmentDAO.delete(appointment);
    }
}

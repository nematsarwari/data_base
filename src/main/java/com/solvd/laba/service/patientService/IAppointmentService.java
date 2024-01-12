package com.solvd.laba.service.patientService;

import com.solvd.laba.domain.patient.Appointment;

import java.util.List;

public interface IAppointmentService {
    Appointment getById(int id);
    List<Appointment> getAllAppointments();
    void insert(Appointment appointment);
    void update(Appointment appointment);
    void delete(Appointment appointment);
}

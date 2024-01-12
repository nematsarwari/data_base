package com.solvd.laba.persistence.patientDAO;

import com.solvd.laba.domain.employee.Salary;
import com.solvd.laba.domain.patient.Appointment;

import java.util.List;

public interface IAppointmentDAO {
    Appointment getById(int id);
    List<Appointment> getAllAppointments();
    void insert(Appointment appointment);
    void update(Appointment appointment);
    void delete(Appointment appointment);
}

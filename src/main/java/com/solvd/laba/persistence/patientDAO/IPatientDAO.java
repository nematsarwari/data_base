package com.solvd.laba.persistence.patientDAO;

import com.solvd.laba.domain.patient.Medication;
import com.solvd.laba.domain.patient.Patient;

import java.util.List;

public interface IPatientDAO {
    Patient getById(int id);
    List<Patient> getAllPatients();
    void insert(Patient patient);
    void update(Patient patient);
    void delete(Patient patient);
}

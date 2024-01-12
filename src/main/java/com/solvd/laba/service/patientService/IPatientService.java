package com.solvd.laba.service.patientService;

import com.solvd.laba.domain.patient.Patient;

import java.util.List;

public interface IPatientService {
    Patient getById(int id);
    List<Patient> getAllPatients();
    void insert(Patient patient);
    void update(Patient patient);
    void delete(Patient patient);
}

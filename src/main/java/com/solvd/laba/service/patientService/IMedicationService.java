package com.solvd.laba.service.patientService;

import com.solvd.laba.domain.patient.Medication;

import java.util.List;

public interface IMedicationService {
    Medication getById(int id);
    List<Medication> getAllMedications();
    void insert(Medication medication);
    void update(Medication medication);
    void delete(Medication medication);
}

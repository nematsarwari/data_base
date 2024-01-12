package com.solvd.laba.persistence.patientDAO;

import com.solvd.laba.domain.patient.LaboratoryTest;
import com.solvd.laba.domain.patient.Medication;

import java.util.List;

public interface IMedicationDAO {
    Medication getById(int id);
    List<Medication> getAllMedications();
    void insert(Medication medication);
    void update(Medication medication);
    void delete(Medication medication);
}

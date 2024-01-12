package com.solvd.laba.persistence.patientDAO;

import com.solvd.laba.domain.patient.Billing;
import com.solvd.laba.domain.patient.LaboratoryTest;

import java.util.List;

public interface ILaboratoryTestDAO {
    LaboratoryTest getById(int id);
    List<LaboratoryTest> getAllLaboratoryTests();
    void insert(LaboratoryTest laboratoryTest);
    void update(LaboratoryTest laboratoryTest);
    void delete(LaboratoryTest laboratoryTest);
}

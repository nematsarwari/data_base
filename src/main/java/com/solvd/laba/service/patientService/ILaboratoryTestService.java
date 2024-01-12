package com.solvd.laba.service.patientService;

import com.solvd.laba.domain.patient.LaboratoryTest;

import java.util.List;

public interface ILaboratoryTestService {
    LaboratoryTest getById(int id);
    List<LaboratoryTest> getAllLaboratoryTests();
    void insert(LaboratoryTest laboratoryTest);
    void update(LaboratoryTest laboratoryTest);
    void delete(LaboratoryTest laboratoryTest);
}

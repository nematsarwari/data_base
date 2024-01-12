package com.solvd.laba.service.patientService.patientServiceImpl;

import com.solvd.laba.domain.patient.LaboratoryTest;
import com.solvd.laba.persistence.patientDAO.ILaboratoryTestDAO;
import com.solvd.laba.persistence.patientDAO.patientDAOImpl.LaboratoryTestDAOImpl;
import com.solvd.laba.service.patientService.ILaboratoryTestService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.invoke.MethodHandles;
import java.util.List;

public class LaboratoryServiceImpl implements ILaboratoryTestService {
    private static final Logger LOGGER = LogManager.getLogger(MethodHandles.lookup().lookupClass());
    private ILaboratoryTestDAO iLaboratoryTestDAO = new LaboratoryTestDAOImpl();
    @Override
    public LaboratoryTest getById(int id) {
        return iLaboratoryTestDAO.getById(id);
    }

    @Override
    public List<LaboratoryTest> getAllLaboratoryTests() {
        return iLaboratoryTestDAO.getAllLaboratoryTests();
    }

    @Override
    public void insert(LaboratoryTest laboratoryTest) {
        iLaboratoryTestDAO.insert(laboratoryTest);
    }

    @Override
    public void update(LaboratoryTest laboratoryTest) {
        iLaboratoryTestDAO.update(laboratoryTest);
    }

    @Override
    public void delete(LaboratoryTest laboratoryTest) {
        iLaboratoryTestDAO.delete(laboratoryTest);
    }
}

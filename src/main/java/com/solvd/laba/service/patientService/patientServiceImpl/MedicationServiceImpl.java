package com.solvd.laba.service.patientService.patientServiceImpl;

import com.solvd.laba.domain.patient.Medication;
import com.solvd.laba.persistence.patientDAO.IMedicationDAO;
import com.solvd.laba.persistence.patientDAO.patientDAOImpl.MedicationDAOImpl;
import com.solvd.laba.service.patientService.IMedicationService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.invoke.MethodHandles;
import java.util.List;

public class MedicationServiceImpl implements IMedicationService {
    private static final Logger LOGGER = LogManager.getLogger(MethodHandles.lookup().lookupClass());
    private IMedicationDAO iMedicationDAO = new MedicationDAOImpl();
    @Override
    public Medication getById(int id) {
        return iMedicationDAO.getById(id);
    }

    @Override
    public List<Medication> getAllMedications() {
        return iMedicationDAO.getAllMedications();
    }

    @Override
    public void insert(Medication medication) {
        iMedicationDAO.insert(medication);
    }

    @Override
    public void update(Medication medication) {
        iMedicationDAO.update(medication);
    }

    @Override
    public void delete(Medication medication) {
        iMedicationDAO.delete(medication);
    }
}

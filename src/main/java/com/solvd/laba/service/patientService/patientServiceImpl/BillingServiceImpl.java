package com.solvd.laba.service.patientService.patientServiceImpl;

import com.solvd.laba.domain.patient.Billing;
import com.solvd.laba.persistence.patientDAO.IBillingDAO;
import com.solvd.laba.persistence.patientDAO.patientDAOImpl.BillingDAOImpl;
import com.solvd.laba.service.patientService.IBillingService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.invoke.MethodHandles;
import java.util.List;

public class BillingServiceImpl implements IBillingService {
    private static final Logger LOGGER = LogManager.getLogger(MethodHandles.lookup().lookupClass());
    private IBillingDAO iBillingDAO = new BillingDAOImpl();
    @Override
    public Billing getById(int id) {
        return iBillingDAO.getById(id);
    }

    @Override
    public List<Billing> getAllBillings() {
        return iBillingDAO.getAllBillings();
    }

    @Override
    public void insert(Billing billing) {
        iBillingDAO.insert(billing);
    }

    @Override
    public void update(Billing billing) {
        iBillingDAO.update(billing);
    }

    @Override
    public void delete(Billing billing) {
        iBillingDAO.delete(billing);
    }
}

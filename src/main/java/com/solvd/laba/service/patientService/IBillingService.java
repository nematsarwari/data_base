package com.solvd.laba.service.patientService;

import com.solvd.laba.domain.patient.Billing;

import java.util.List;

public interface IBillingService {
    Billing getById(int id);
    List<Billing> getAllBillings();
    void insert(Billing billing);
    void update(Billing billing);
    void delete(Billing billing);
}

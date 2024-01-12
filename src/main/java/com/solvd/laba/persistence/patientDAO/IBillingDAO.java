package com.solvd.laba.persistence.patientDAO;

import com.solvd.laba.domain.patient.Appointment;
import com.solvd.laba.domain.patient.Billing;

import java.util.List;

public interface IBillingDAO {
    Billing getById(int id);
    List<Billing> getAllBillings();
    void insert(Billing billing);
    void update(Billing billing);
    void delete(Billing billing);
}

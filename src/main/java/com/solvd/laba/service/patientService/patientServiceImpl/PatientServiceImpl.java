package com.solvd.laba.service.patientService.patientServiceImpl;

import com.solvd.laba.domain.employee.Employee;
import com.solvd.laba.domain.patient.Appointment;
import com.solvd.laba.domain.patient.Billing;
import com.solvd.laba.domain.patient.Medication;
import com.solvd.laba.domain.patient.Patient;
import com.solvd.laba.persistence.patientDAO.IAppointmentDAO;
import com.solvd.laba.persistence.patientDAO.IBillingDAO;
import com.solvd.laba.persistence.patientDAO.IMedicationDAO;
import com.solvd.laba.persistence.patientDAO.IPatientDAO;
import com.solvd.laba.persistence.patientDAO.patientDAOImpl.AppointmentDAOImpl;
import com.solvd.laba.persistence.patientDAO.patientDAOImpl.BillingDAOImpl;
import com.solvd.laba.persistence.patientDAO.patientDAOImpl.MedicationDAOImpl;
import com.solvd.laba.persistence.patientDAO.patientDAOImpl.PatientDAOImpl;
import com.solvd.laba.service.patientService.IPatientService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.List;

public class PatientServiceImpl implements IPatientService {
    private static final Logger LOGGER = LogManager.getLogger(MethodHandles.lookup().lookupClass());
    private IPatientDAO iPatientDAO = new PatientDAOImpl();
    IAppointmentDAO iAppointmentDAO = new AppointmentDAOImpl();
    IMedicationDAO iMedicationDAO = new MedicationDAOImpl();
    IBillingDAO iBillingDAO = new BillingDAOImpl();
    @Override
    public Patient getById(int id) {
        Patient patient = iPatientDAO.getById(id);
        List<Appointment> appointments = iAppointmentDAO.getAllAppointments();
        List<Appointment> a = new ArrayList<>();
        for (Appointment appointment : appointments) {
            if(appointment.getPatientId() == id){
                a.add(appointment);
            }
        }
        List<Medication> medications = iMedicationDAO.getAllMedications();
        List<Medication> m = new ArrayList<>();
        for (Medication medication : medications) {
            if(medication.getPatientId() == id){
                m.add(medication);
            }
        }
        patient.setMedications(m);
        List<Billing> billings = iBillingDAO.getAllBillings();
        List<Billing> b = new ArrayList<>();
        for (Billing billing : billings) {
            if(billing.getPatientId() == id){
                b.add(billing);
            }
        }
        patient.setBillings(b);
        return patient;
    }

    @Override
    public List<Patient> getAllPatients() {
        return iPatientDAO.getAllPatients();
    }

    @Override
    public void insert(Patient patient) {
        iPatientDAO.insert(patient);
    }

    @Override
    public void update(Patient patient) {
        iPatientDAO.update(patient);
    }

    @Override
    public void delete(Patient patient) {
        iPatientDAO.delete(patient);
    }
}

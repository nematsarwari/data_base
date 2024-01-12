package com.solvd.laba.service.hospitalService.hospitalServiceImpl;

import com.solvd.laba.domain.employee.Employee;
import com.solvd.laba.domain.hospital.Hospital;
import com.solvd.laba.domain.patient.Patient;
import com.solvd.laba.persistence.employeeDAO.IEmployeeDAO;
import com.solvd.laba.persistence.employeeDAO.employeeDAOImpl.EmployeeDAOImpl;
import com.solvd.laba.persistence.hospitalDAO.IHospitalDAO;
import com.solvd.laba.persistence.hospitalDAO.hospitalDAOImpl.HospitalDAOImpl;
import com.solvd.laba.persistence.patientDAO.IPatientDAO;
import com.solvd.laba.persistence.patientDAO.patientDAOImpl.PatientDAOImpl;
import com.solvd.laba.service.hospitalService.IHospitalService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.List;

public class HospitalServiceImpl implements IHospitalService {
    private static final Logger LOGGER = LogManager.getLogger(MethodHandles.lookup().lookupClass());
    private IHospitalDAO iHospitalDAO = new HospitalDAOImpl();
    private IEmployeeDAO iEmployeeDAO = new EmployeeDAOImpl();
    private IPatientDAO iPatientDAO = new PatientDAOImpl();

    @Override
    public Hospital getById(int id) {
        Hospital hospital = iHospitalDAO.getById(id);
        List<Employee> employees = iEmployeeDAO.getAllEmployees();
        List<Employee> e = new ArrayList<>();
        for (Employee employee : employees) {
            if(employee.getHospitalId() == id){
                e.add(employee);
            }
        }
        hospital.setEmployees(e);
        List<Patient> patients = iPatientDAO.getAllPatients();
        List<Patient> p = new ArrayList<>();
        for (Patient patient : patients) {
            if(patient.getHospitalId() == id){
                p.add(patient);
            }
        }
        hospital.setPatients(p);

//            hospital.setEmployees(iHospitalDAO.getEmployeesByHospitalId(id));
//            hospital.setPatients(iHospitalDAO.getPatientsByHospitalId(id));
        return hospital;
    }

    @Override
    public List<Hospital> getAllHospitals() {
        return iHospitalDAO.getAllHospitals();
    }

    @Override
    public void insert(Hospital hospital) {
        iHospitalDAO.insert(hospital);
    }

    @Override
    public void update(Hospital hospital) {
        iHospitalDAO.update(hospital);
    }

    @Override
    public void delete(Hospital hospital) {
        iHospitalDAO.delete(hospital);
    }
}

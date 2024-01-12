package com.solvd.laba.domain.hospital;

import com.solvd.laba.domain.employee.Employee;
import com.solvd.laba.domain.patient.Patient;

import java.util.List;

public class Hospital {
    private int hospitalId;
    private String hospitalName;
    private List<Employee> employees;
    private List<Patient> patients;

    public Hospital(int hospitalId, String hospitalName) {
        this.hospitalId = hospitalId;
        this.hospitalName = hospitalName;
    }
    public Hospital() {
    }

    public int getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(int hospitalId) {
        this.hospitalId = hospitalId;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }

    @Override
    public String toString() {
        return "Hospital{" +
                "hospitalId=" + hospitalId +
                ", hospitalName='" + hospitalName + '\'' +
                ",\nemployees=" + employees +
                ",\npatients=" + patients +
                '}';
    }
}

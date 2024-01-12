package com.solvd.laba.persistence.hospitalDAO;

import com.solvd.laba.domain.employee.Employee;
import com.solvd.laba.domain.hospital.Hospital;
import com.solvd.laba.domain.patient.Patient;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IHospitalDAO {
    Hospital getById(int id);
    List<Hospital> getAllHospitals();
    void insert(Hospital hospital);
    void update(Hospital hospital);
    void delete(Hospital hospital);

}

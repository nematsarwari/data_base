package com.solvd.laba.service.hospitalService;

import com.solvd.laba.domain.hospital.Hospital;

import java.util.List;

public interface IHospitalService {
    Hospital getById(int id);
    List<Hospital> getAllHospitals();

    void insert(Hospital hospital);
    void update(Hospital hospital);
    void delete(Hospital hospital);
}

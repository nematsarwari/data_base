package com.solvd.laba.persistence.hospitalDAO.hospitalDAOImpl.myBatis;

import com.solvd.laba.configuration.persistenceConfig;
import com.solvd.laba.domain.hospital.Hospital;
import com.solvd.laba.domain.patient.Billing;
import com.solvd.laba.persistence.hospitalDAO.IHospitalDAO;
import com.solvd.laba.persistence.patientDAO.IBillingDAO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class HospitalBImpl implements IHospitalDAO {

    @Override
    public Hospital getById(int id) {
        try (SqlSession sqlSession = persistenceConfig.getSessionFactory().openSession(true);){
            IHospitalDAO hospitalDAO = sqlSession.getMapper(IHospitalDAO.class);
            Hospital hospital = hospitalDAO.getById(id);
            return hospital;
        }
    }

    @Override
    public List<Hospital> getAllHospitals() {
        return null;
    }

    @Override
    public void insert(Hospital hospital) {

    }

    @Override
    public void update(Hospital hospital) {

    }

    @Override
    public void delete(Hospital hospital) {

    }
}

package com.solvd.laba.domain.patient;

public class LaboratoryTest {
    private int id;
    private String testDetails;
    private int patientId;

    public LaboratoryTest(int id, String testDetails, int patientId) {
        this.id = id;
        this.testDetails = testDetails;
        this.patientId = patientId;
    }

    public LaboratoryTest() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTestDetails() {
        return testDetails;
    }

    public void setTestDetails(String testDetails) {
        this.testDetails = testDetails;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    @Override
    public String toString() {
        return "LaboratoryTest{" +
                "id=" + id +
                ", testDetails='" + testDetails + '\'' +
                ", patientId=" + patientId +
                '}';
    }
}

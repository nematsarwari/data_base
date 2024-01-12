package com.solvd.laba.domain.patient;

public class Medication {
    private int medicationId;
    private String medicationName;
    private String medicationDetail;
    private int patientId;

    public Medication(int medicationId, String medicationName, String medicationDetail, int patientId) {
        this.medicationId = medicationId;
        this.medicationName = medicationName;
        this.medicationDetail = medicationDetail;
        this.patientId = patientId;
    }

    public Medication() {
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public int getMedicationId() {
        return medicationId;
    }

    public void setMedicationId(int medicationId) {
        this.medicationId = medicationId;
    }

    public String getMedicationName() {
        return medicationName;
    }

    public void setMedicationName(String medicationName) {
        this.medicationName = medicationName;
    }

    public String getMedicationDetail() {
        return medicationDetail;
    }

    public void setMedicationDetail(String medicationDetail) {
        this.medicationDetail = medicationDetail;
    }

    @Override
    public String toString() {
        return "Medication{" +
                "medicationId=" + medicationId +
                ", medicationName='" + medicationName + '\'' +
                ", medicationDetail='" + medicationDetail + '\'' +
                ", patientId=" + patientId +
                '}';
    }
}

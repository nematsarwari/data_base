package com.solvd.laba.domain.patient;

public class Appointment {
    private int appointmentId;
    private String appointmentDetails;
    private int patientId;

    public Appointment(int appointmentId, String appointmentDetails, int patientId) {
        this.appointmentId = appointmentId;
        this.appointmentDetails = appointmentDetails;
        this.patientId = patientId;
    }

    public Appointment() {
    }

    public int getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }

    public String getAppointmentDetails() {
        return appointmentDetails;
    }

    public void setAppointmentDetails(String appointmentDetails) {
        this.appointmentDetails = appointmentDetails;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "appointmentId=" + appointmentId +
                ", appointmentDetails='" + appointmentDetails + '\'' +
                ", patientId=" + patientId +
                '}';
    }
}

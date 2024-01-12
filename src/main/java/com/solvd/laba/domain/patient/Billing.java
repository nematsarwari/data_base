package com.solvd.laba.domain.patient;

public class Billing {
    private int billNumber;
    private String billDetails;
    private double amount;
    private int patientId;

    public Billing(int billNumber, String billDetails, double amount, int patientId) {
        this.billNumber = billNumber;
        this.billDetails = billDetails;
        this.amount = amount;
        this.patientId = patientId;
    }

    public Billing() {
    }

    public int getBillNumber() {
        return billNumber;
    }

    public void setBillNumber(int billNumber) {
        this.billNumber = billNumber;
    }

    public String getBillDetails() {
        return billDetails;
    }

    public void setBillDetails(String billDetails) {
        this.billDetails = billDetails;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    @Override
    public String toString() {
        return "Billing{" +
                "billNumber=" + billNumber +
                ", billDetails='" + billDetails + '\'' +
                ", amount=" + amount +
                ", patientId=" + patientId +
                '}';
    }
}

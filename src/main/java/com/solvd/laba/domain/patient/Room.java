package com.solvd.laba.domain.patient;

public class Room {
    private int roomNumber;
    private int patientId;

    public Room(int roomNumber, int patientId) {
        this.roomNumber = roomNumber;
        this.patientId = patientId;
    }

    public Room() {
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomNumber=" + roomNumber +
                ", patientId=" + patientId +
                '}';
    }
}

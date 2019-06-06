package com.alten.status.simulator.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "VEHICLE")
public class Vehicle {
    @Id
    @Column(name = "VEHICLE_ID")
    private String vehicleId;
    @Column(name = "REGISTRATION_NUMBER")
    private String registrationNumber;

    public Vehicle() {
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

}

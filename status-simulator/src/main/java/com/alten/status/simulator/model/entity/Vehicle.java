package com.alten.status.simulator.model.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@IdClass(Vehicle.VehicleId.class)
@Table(name = "VEHICLE")
public class Vehicle implements Serializable {
    @Id
    @Column(name = "VEHICLE_ID")
    private String vehicleId;
    @Id
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

    public static class VehicleId implements Serializable {

        private String vehicleId;
        private String registrationNumber;

        public VehicleId() {
        }

        public VehicleId(String vehicleId, String registrationNumber) {
            this.vehicleId = vehicleId;
            this.registrationNumber = registrationNumber;
        }
    }

}

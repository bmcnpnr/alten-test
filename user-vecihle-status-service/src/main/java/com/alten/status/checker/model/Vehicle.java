package com.alten.status.checker.model;

import javax.persistence.*;

@Entity
@Table(name = "VEHICLE")
public class Vehicle {
    @Id
    @Column(name = "VEHICLE_ID")
    private String vehicleId;
    @Column(name = "REGISTRATION_NUMBER")
    private String registrationNumber;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    private User user;

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

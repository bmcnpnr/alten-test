package com.alten.status.checker.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "VEHICLE")
public class Vehicle {
    @Id
    @Column(name = "REGISTRATION_NUMBER")
    private String registrationNumber;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    private User user;
    @Column(name = "CONNECTED")
    private Boolean connected;

    public Vehicle() {
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

    public Boolean getConnected() {
        return connected;
    }

    public void setConnected(Boolean connected) {
        this.connected = connected;
    }
}

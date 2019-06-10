package com.alten.status.checker.service;

import com.alten.status.checker.model.entity.User;
import com.alten.status.checker.model.entity.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@ConditionalOnProperty(name = "app.db-init", havingValue = "true")
public class DatabaseInitializer implements CommandLineRunner {

    @Autowired
    private UserDAO userDAO;

    @Override
    public void run(String... args) {
        User user1 = new User();
        user1.setName("Kalles Grustransporter AB");
        user1.setAddress("Cementvägen 8, 111 11 Södertälje");
        List<Vehicle> user1vehicles = new ArrayList<>();
        Vehicle user1v1 = new Vehicle();
        user1v1.setUser(user1);
        user1v1.setConnected(false);
        user1v1.setRegistrationNumber("ABC123");
        user1v1.setVehicleId("YS2R4X20005399401");
        user1vehicles.add(user1v1);
        Vehicle user1v2 = new Vehicle();
        user1v2.setUser(user1);
        user1v2.setConnected(false);
        user1v2.setRegistrationNumber("DEF456");
        user1v2.setVehicleId("VLUR4X20009093588");
        user1vehicles.add(user1v2);
        Vehicle user1v3 = new Vehicle();
        user1v3.setUser(user1);
        user1v3.setConnected(false);
        user1v3.setRegistrationNumber("GHI789");
        user1v3.setVehicleId("VLUR4X20009048066");
        user1vehicles.add(user1v3);
        user1.setVehicles(user1vehicles);
        userDAO.save(user1);
        User user2 = new User();
        user2.setName("Johans Bulk AB");
        user2.setAddress("Balkvägen 12, 222 22 Stockholm");
        List<Vehicle> user2vehicles = new ArrayList<>();
        Vehicle user2v1 = new Vehicle();
        user2v1.setUser(user2);
        user2v1.setConnected(false);
        user2v1.setRegistrationNumber("JKL012");
        user2v1.setVehicleId("YS2R4X20005388011");
        user2vehicles.add(user2v1);
        Vehicle user2v2 = new Vehicle();
        user2v2.setUser(user2);
        user2v2.setConnected(false);
        user2v2.setRegistrationNumber("MNO345");
        user2v2.setVehicleId("YS2R4X20005387949");
        user2vehicles.add(user2v2);
        user2.setVehicles(user2vehicles);
        userDAO.save(user2);
        User user3 = new User();
        user3.setName("Haralds Värdetransporter AB");
        user3.setAddress("Budgetvägen 1, 333 33 Uppsala");
        List<Vehicle> user3vehicles = new ArrayList<>();
        Vehicle user3v1 = new Vehicle();
        user3v1.setUser(user3);
        user3v1.setConnected(false);
        user3v1.setRegistrationNumber("PQR678");
        user3v1.setVehicleId("VLUR4X20009048066");
        user3vehicles.add(user3v1);
        Vehicle user3v2 = new Vehicle();
        user3v2.setUser(user3);
        user3v2.setConnected(false);
        user3v2.setRegistrationNumber("STU901");
        user3v2.setVehicleId("YS2R4X20005387055");
        user3vehicles.add(user3v2);
        user3.setVehicles(user3vehicles);
        userDAO.save(user3);
    }

    public UserDAO getUserDAO() {
        return userDAO;
    }
}

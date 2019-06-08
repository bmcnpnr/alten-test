package com.alten.status.simulator.service;

import com.alten.status.simulator.model.entity.Vehicle;
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
    private VehicleDAO vehicleDAO;

    private List<Vehicle> vehicleList = new ArrayList<>();

    @Override
    public void run(String... args) {

        Vehicle vehicle1 = new Vehicle();
        vehicle1.setVehicleId("YS2R4X20005399401");
        vehicle1.setRegistrationNumber("ABC123");
        vehicleList.add(vehicle1);
        Vehicle vehicle2 = new Vehicle();
        vehicle2.setVehicleId("VLUR4X20009093588");
        vehicle2.setRegistrationNumber("DEF456");
        vehicleList.add(vehicle2);
        Vehicle vehicle3 = new Vehicle();
        vehicle3.setVehicleId("VLUR4X20009048066");
        vehicle3.setRegistrationNumber("GHI789");
        vehicleList.add(vehicle3);
        Vehicle vehicle4 = new Vehicle();
        vehicle4.setVehicleId("YS2R4X20005388011");
        vehicle4.setRegistrationNumber("JKL012");
        vehicleList.add(vehicle4);
        Vehicle vehicle5 = new Vehicle();
        vehicle5.setVehicleId("YS2R4X20005387949");
        vehicle5.setRegistrationNumber("MNO345");
        vehicleList.add(vehicle5);
        Vehicle vehicle6 = new Vehicle();
        vehicle6.setVehicleId("VLUR4X20009048066");
        vehicle6.setRegistrationNumber("PQR678");
        vehicleList.add(vehicle6);
        Vehicle vehicle7 = new Vehicle();
        vehicle7.setVehicleId("YS2R4X20005387055");
        vehicle7.setRegistrationNumber("STU901");
        vehicleList.add(vehicle7);
        vehicleDAO.saveAll(vehicleList);
    }

    public VehicleDAO getVehicleDAO() {
        return vehicleDAO;
    }

    public void setVehicleDAO(VehicleDAO vehicleDAO) {
        this.vehicleDAO = vehicleDAO;
    }

    public void setVehicleList(List<Vehicle> vehicleList) {
        this.vehicleList = vehicleList;
    }
}

package com.alten.status.simulator.service;

import com.alten.status.simulator.model.entity.Vehicle;
import com.alten.status.simulator.model.entity.VehicleStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class StatusSimulator {

    @Autowired
    private VehicleDAO vehicleDAO;

    private final Random random = new Random();
    public List<VehicleStatus> getVehicleStatus() {
        List<Vehicle> allVehicles = vehicleDAO.getAllVehicles();
        List<VehicleStatus> vehicleStatuses = new ArrayList<>();
        for (Vehicle vehicle : allVehicles) {
            VehicleStatus vehicleStatus = new VehicleStatus();
            vehicleStatus.setConnected(random.nextBoolean());
            vehicleStatus.setVehicleRegNumber(vehicle.getRegistrationNumber());
            vehicleStatuses.add(vehicleStatus);

        }
        return vehicleStatuses;
    }
}

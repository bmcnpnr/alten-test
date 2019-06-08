package com.alten.status.simulator.service;

import com.alten.status.simulator.model.dto.VehicleStatus;
import com.alten.status.simulator.model.entity.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class StatusSimulator {

    private final Random random = new Random();
    @Autowired
    private VehicleDAO vehicleDAO;

    public List<VehicleStatus> getVehicleStatuses() {
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

    public VehicleDAO getVehicleDAO() {
        return vehicleDAO;
    }

    public void setVehicleDAO(VehicleDAO vehicleDAO) {
        this.vehicleDAO = vehicleDAO;
    }
}

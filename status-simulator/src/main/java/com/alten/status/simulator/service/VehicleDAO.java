package com.alten.status.simulator.service;

import com.alten.status.simulator.dao.repository.VehicleRepository;
import com.alten.status.simulator.model.entity.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleDAO {

    @Autowired
    private VehicleRepository vehicleRepository;

    public void saveAll(Iterable<Vehicle> vehicles) {
        vehicleRepository.saveAll(vehicles);
    }

    public List<Vehicle> getAllVehicles() {
        return (List<Vehicle>) vehicleRepository.findAll();
    }

    public VehicleRepository getVehicleRepository() {
        return vehicleRepository;
    }
}

package com.alten.status.simulator.service;

import com.alten.status.simulator.dao.repository.VehicleRepository;
import com.alten.status.simulator.model.entity.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehicleDAO {

    @Autowired
    private VehicleRepository vehicleRepository;

    public void saveAll(Iterable<Vehicle> vehicles) {
        vehicleRepository.saveAll(vehicles);
    }
}

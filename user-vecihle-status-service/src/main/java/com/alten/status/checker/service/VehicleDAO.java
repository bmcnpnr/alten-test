package com.alten.status.checker.service;

import com.alten.status.checker.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehicleDAO {
    @Autowired
    private VehicleRepository repository;

    public VehicleRepository getRepository() {
        return repository;
    }

    public void setRepository(VehicleRepository repository) {
        this.repository = repository;
    }
}

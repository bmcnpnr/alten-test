package com.alten.status.checker.repository;

import com.alten.status.checker.model.entity.Vehicle;
import org.springframework.data.repository.CrudRepository;

public interface VehicleRepository extends CrudRepository<Vehicle, String> {
    Vehicle findByRegistrationNumber(String registrationNumber);
}

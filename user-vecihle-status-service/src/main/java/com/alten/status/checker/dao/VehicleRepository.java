package com.alten.status.checker.dao;

import com.alten.status.checker.model.entity.Vehicle;
import org.springframework.data.repository.CrudRepository;

public interface VehicleRepository extends CrudRepository<Vehicle, String> {
}

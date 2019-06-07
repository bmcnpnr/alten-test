package com.alten.status.simulator.dao.repository;

import com.alten.status.simulator.model.entity.Vehicle;
import org.springframework.data.repository.CrudRepository;

public interface VehicleRepository extends CrudRepository<Vehicle, String> {
}

package com.alten.status.checker.service;

import com.alten.status.checker.model.dto.UserVehicleStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class StatusChecker {
    @Autowired
    private UserDAO userDAO;

    @Autowired
    private VehicleDAO vehicleDAO;

    public List<UserVehicleStatus> getVehicleStatus() {
        return null;
    }
}

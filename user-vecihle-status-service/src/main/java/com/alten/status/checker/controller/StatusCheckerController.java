package com.alten.status.checker.controller;

import com.alten.status.checker.model.dto.UserVehicleStatus;
import com.alten.status.checker.service.StatusChecker;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/statusChecker")
public class StatusCheckerController {

    @Autowired
    private StatusChecker statusChecker;

    @RequestMapping("/checkStatusOfVehicles")
    public String checkStatusOfVehicles() {
        List<UserVehicleStatus> vehicleStatuses = statusChecker.getVehicleStatuses();
        return new Gson().toJson(vehicleStatuses);
    }
}

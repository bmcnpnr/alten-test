package com.alten.status.simulator.controller;

import com.alten.status.simulator.service.StatusSimulator;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/statusSimulator")
public class StatusSimulationController {

    @Autowired
    private StatusSimulator statusSimulator;

    @RequestMapping("/getVehicleStatus")
    public String getVehicleStatus() {
        return new Gson().toJson(statusSimulator.getVehicleStatus());
    }
}

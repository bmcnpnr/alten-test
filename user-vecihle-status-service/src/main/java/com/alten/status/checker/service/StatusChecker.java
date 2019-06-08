package com.alten.status.checker.service;

import com.alten.status.checker.model.dto.UserVehicleStatus;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class StatusChecker {
    @Autowired
    private UserDAO userDAO;

    @Autowired
    private VehicleDAO vehicleDAO;

    @Autowired
    private RestTemplate restTemplate;

    public List<UserVehicleStatus> getVehicleStatus() {

        String fooResourceUrl = "http://localhost:8762/statusSimulator";
        ResponseEntity<String> response
                = restTemplate.getForEntity(fooResourceUrl + "/getVehicleStatus", String.class);
        JsonElement jsonElement = new Gson().toJsonTree(response.getBody());
        System.out.println(jsonElement.getAsString());

        return null;
    }
}

package com.alten.status.checker.service;

import com.alten.status.checker.model.dto.UserVehicleStatus;
import com.alten.status.checker.model.entity.Vehicle;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class StatusChecker {

    @Autowired
    private VehicleDAO vehicleDAO;

    @Autowired
    private RestTemplate restTemplate;

    public List<UserVehicleStatus> getVehicleStatuses() {
        updateTheVehicleStatusAtDb();
        return generateUserVehicleStatusList();
    }

    private void updateTheVehicleStatusAtDb() {
        String resourceUrl = "http://api-gateway:8762/statusSimulator";
        ResponseEntity<String> response
                = restTemplate.getForEntity(resourceUrl + "/getVehicleStatuses", String.class);
        JsonArray jsonArray = new JsonParser().
                parse(Objects.requireNonNull(response.getBody())).getAsJsonArray();
        jsonArray.forEach(item -> {
            String vehicleRegNumber = item.getAsJsonObject().get("vehicleRegNumber").getAsString();
            Vehicle vehicle = vehicleDAO.findByRegNumber(vehicleRegNumber);
            boolean connected = item.getAsJsonObject().get("connected").getAsBoolean();
            vehicle.setConnected(connected);
            vehicleDAO.update(vehicle);
        });
    }

    private List<UserVehicleStatus> generateUserVehicleStatusList() {
        List<UserVehicleStatus> userVehicleStatuses = new ArrayList<>();
        vehicleDAO.findAllVehicles().forEach(item -> {
            UserVehicleStatus status = new UserVehicleStatus();
            status.setUserName(item.getUser().getName());
            status.setUserAddress(item.getUser().getAddress());
            status.setVehicleId(item.getVehicleId());
            status.setVehicleRegNumber(item.getRegistrationNumber());
            status.setVehicleStatus(item.getConnected());
            userVehicleStatuses.add(status);
        });
        return userVehicleStatuses;
    }

    public VehicleDAO getVehicleDAO() {
        return vehicleDAO;
    }

    public RestTemplate getRestTemplate() {
        return restTemplate;
    }
}

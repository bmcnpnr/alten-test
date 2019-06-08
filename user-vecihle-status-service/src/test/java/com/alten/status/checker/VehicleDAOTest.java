package com.alten.status.checker;

import com.alten.status.checker.model.entity.User;
import com.alten.status.checker.model.entity.Vehicle;
import com.alten.status.checker.repository.VehicleRepository;
import com.alten.status.checker.service.VehicleDAO;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class VehicleDAOTest {

    private VehicleDAO vehicleDAO;

    @Before
    public void initTest() {
        vehicleDAO = new VehicleDAO();
        ReflectionTestUtils.setField(vehicleDAO,
                "repository", mock(VehicleRepository.class));
    }

    @Test
    public void findByRegNumberTest() {
        Vehicle vehicle = new Vehicle();
        vehicle.setConnected(true);
        vehicle.setUser(new User());
        vehicle.setVehicleId("1");
        vehicle.setRegistrationNumber("2");
        when(vehicleDAO.getRepository().findByRegistrationNumber(vehicle.getRegistrationNumber())).thenReturn(vehicle);

        Vehicle result = vehicleDAO.findByRegNumber(vehicle.getRegistrationNumber());
        assertEquals(vehicle, result);
    }

    @Test
    public void findAllVehiclesTest() {
        List<Vehicle> vehicleList = new ArrayList<>();
        vehicleList.add(new Vehicle());
        vehicleList.add(new Vehicle());
        vehicleList.add(new Vehicle());
        vehicleList.add(new Vehicle());
        when(vehicleDAO.getRepository().findAll()).thenReturn(vehicleList);

        List<Vehicle> allVehicles = (List<Vehicle>) vehicleDAO.findAllVehicles();

        assertEquals(vehicleList, allVehicles);

    }

    @Test
    public void updateTest() {
        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleId("1");
        vehicle.setRegistrationNumber("2");
        doAnswer(invocationOnMock -> {
            Vehicle argument = invocationOnMock.getArgument(0);
            assertEquals(argument.getRegistrationNumber(), vehicle.getRegistrationNumber());
            assertEquals(argument.getVehicleId(), vehicle.getVehicleId());
            return null;
        }).when(vehicleDAO.getRepository()).save(vehicle);

        vehicleDAO.update(vehicle);
    }
}

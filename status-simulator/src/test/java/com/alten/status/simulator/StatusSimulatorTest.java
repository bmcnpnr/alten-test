package com.alten.status.simulator;

import com.alten.status.simulator.model.dto.VehicleStatus;
import com.alten.status.simulator.model.entity.Vehicle;
import com.alten.status.simulator.service.StatusSimulator;
import com.alten.status.simulator.service.VehicleDAO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StatusSimulatorTest {
    private StatusSimulator statusSimulator;

    @Before
    public void initTest() {
        statusSimulator = new StatusSimulator();
        ReflectionTestUtils.setField(statusSimulator, "vehicleDAO", mock(VehicleDAO.class));
    }

    @Test
    public void getVehicleStatusesTest() {
        List<Vehicle> vehicleList = new ArrayList<>();
        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleId("1");
        vehicle.setRegistrationNumber("2");
        vehicleList.add(vehicle);
        when(statusSimulator.getVehicleDAO().getAllVehicles()).thenReturn(vehicleList);
        List<VehicleStatus> vehicleStatuses = statusSimulator.getVehicleStatuses();
        assertEquals(vehicleStatuses.size(), vehicleList.size());
        assertEquals(vehicleStatuses.get(0).getVehicleRegNumber(), vehicleList.get(0).getRegistrationNumber());

    }
}

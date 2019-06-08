package com.alten.status.simulator;

import com.alten.status.simulator.dao.repository.VehicleRepository;
import com.alten.status.simulator.model.entity.Vehicle;
import com.alten.status.simulator.service.VehicleDAO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VehicleDAOTest {

    private VehicleDAO vehicleDAO;

    @Before
    public void initTest() {
        vehicleDAO = new VehicleDAO();
        ReflectionTestUtils.setField(vehicleDAO,
                "vehicleRepository", mock(VehicleRepository.class));
    }

    @Test
    public void saveAllTest() {
        doAnswer(invocationOnMock -> {
            List<Vehicle> argument = invocationOnMock.getArgument(0);
            assertEquals(3, argument.size());
            return null;
        }).when(vehicleDAO.getVehicleRepository()).saveAll(Mockito.any());
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Vehicle());
        vehicles.add(new Vehicle());
        vehicles.add(new Vehicle());
        vehicleDAO.saveAll(vehicles);
    }

    @Test
    public void getAllVehiclesTest() {

    }
}

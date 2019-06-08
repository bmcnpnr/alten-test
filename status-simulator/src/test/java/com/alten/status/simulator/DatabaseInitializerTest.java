package com.alten.status.simulator;

import com.alten.status.simulator.model.entity.Vehicle;
import com.alten.status.simulator.service.DatabaseInitializer;
import com.alten.status.simulator.service.VehicleDAO;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;

public class DatabaseInitializerTest {
    private DatabaseInitializer databaseInitializer;

    @Before
    public void initTest() {
        databaseInitializer = new DatabaseInitializer();
        ReflectionTestUtils.setField(databaseInitializer, "vehicleDAO", mock(VehicleDAO.class));
    }

    @Test
    public void testDbInitialization() {
        List<Vehicle> listOfVehicles = new ArrayList<>();
        listOfVehicles.add(new Vehicle());
        listOfVehicles.add(new Vehicle());
        listOfVehicles.add(new Vehicle());
        doAnswer(invocationOnMock -> {
            List<Vehicle> arg = invocationOnMock.getArgument(0);
            assertEquals(arg.size(), 10);
            return null;
        }).when(databaseInitializer.getVehicleDAO()).saveAll(listOfVehicles);
        databaseInitializer.setVehicleList(listOfVehicles);
        databaseInitializer.run();
    }
}

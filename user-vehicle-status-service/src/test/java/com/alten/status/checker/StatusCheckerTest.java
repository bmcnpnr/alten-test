package com.alten.status.checker;

import com.alten.status.checker.model.dto.UserVehicleStatus;
import com.alten.status.checker.model.entity.User;
import com.alten.status.checker.model.entity.Vehicle;
import com.alten.status.checker.service.StatusChecker;
import com.alten.status.checker.service.VehicleDAO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StatusCheckerTest {
    private static final String POSSIBLE_EXPECTATION = "[{\"vehicleRegNumber\":\"ABC123\",\"connected\":false},{\"vehicleRegNumber\":\"DEF456\",\"connected\":false},{\"vehicleRegNumber\":\"GHI789\",\"connected\":false},{\"vehicleRegNumber\":\"JKL012\",\"connected\":true},{\"vehicleRegNumber\":\"MNO345\",\"connected\":false},{\"vehicleRegNumber\":\"PQR678\",\"connected\":false},{\"vehicleRegNumber\":\"STU901\",\"connected\":false}]";

    private StatusChecker statusChecker;

    @Before
    public void initTest() {
        statusChecker = new StatusChecker();
        ReflectionTestUtils.setField(statusChecker, "vehicleDAO", mock(VehicleDAO.class));
        ReflectionTestUtils.setField(statusChecker, "restTemplate", mock(RestTemplate.class));

        String resourceUrl = "http://api-gateway:8762/statusSimulator";
        ResponseEntity<String> response = new ResponseEntity<>(POSSIBLE_EXPECTATION, HttpStatus.OK);
        when(statusChecker.getRestTemplate().getForEntity(resourceUrl + "/getVehicleStatuses", String.class))
                .thenReturn(response);

        when(statusChecker.getVehicleDAO().findByRegNumber(Mockito.anyString())).thenReturn(new Vehicle());
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        Vehicle dummyVehicle = new Vehicle();
        dummyVehicle.setConnected(false);
        dummyVehicle.setUser(new User());
        vehicles.add(dummyVehicle);
        vehicles.add(dummyVehicle);
        vehicles.add(dummyVehicle);
        vehicles.add(dummyVehicle);
        vehicles.add(dummyVehicle);
        vehicles.add(dummyVehicle);
        vehicles.add(dummyVehicle);
        when(statusChecker.getVehicleDAO().findAllVehicles()).thenReturn(vehicles);

        doAnswer(invocationOnMock -> {
            Vehicle vehicle = invocationOnMock.getArgument(0);
            assertNotNull(vehicle);
            return null;
        }).when(statusChecker.getVehicleDAO()).update(any(Vehicle.class));


    }

    @Test
    public void getVehicleStatusesTest() {
        List<UserVehicleStatus> vehicleStatuses = statusChecker.getVehicleStatuses();
        assertEquals(vehicleStatuses.size(), 7);
    }
}

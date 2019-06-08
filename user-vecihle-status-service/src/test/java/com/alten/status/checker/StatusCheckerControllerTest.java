package com.alten.status.checker;

import com.alten.status.checker.controller.StatusCheckerController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StatusCheckerControllerTest {
    private static final String POSSIBLE_EXPECTATION = "[{\"vehicleRegNumber\":\"ABC123\",\"connected\":false},{\"vehicleRegNumber\":\"DEF456\",\"connected\":false},{\"vehicleRegNumber\":\"GHI789\",\"connected\":false},{\"vehicleRegNumber\":\"JKL012\",\"connected\":true},{\"vehicleRegNumber\":\"MNO345\",\"connected\":false},{\"vehicleRegNumber\":\"PQR678\",\"connected\":false},{\"vehicleRegNumber\":\"STU901\",\"connected\":false}]";
    private static final String POSSIBLE_RESULT = "[{\"userName\":\"Kalles Grustransporter AB\",\"userAddress\":\"Cementvägen 8, 111 11 Södertälje\",\"vehicleRegNumber\":\"ABC123\",\"vehicleId\":\"YS2R4X20005399401\",\"vehicleStatus\":false},{\"userName\":\"Kalles Grustransporter AB\",\"userAddress\":\"Cementvägen 8, 111 11 Södertälje\",\"vehicleRegNumber\":\"DEF456\",\"vehicleId\":\"VLUR4X20009093588\",\"vehicleStatus\":false},{\"userName\":\"Kalles Grustransporter AB\",\"userAddress\":\"Cementvägen 8, 111 11 Södertälje\",\"vehicleRegNumber\":\"GHI789\",\"vehicleId\":\"VLUR4X20009048066\",\"vehicleStatus\":false},{\"userName\":\"Johans Bulk AB\",\"userAddress\":\"Balkvägen 12, 222 22 Stockholm\",\"vehicleRegNumber\":\"JKL012\",\"vehicleId\":\"YS2R4X20005388011\",\"vehicleStatus\":true},{\"userName\":\"Johans Bulk AB\",\"userAddress\":\"Balkvägen 12, 222 22 Stockholm\",\"vehicleRegNumber\":\"MNO345\",\"vehicleId\":\"YS2R4X20005387949\",\"vehicleStatus\":false},{\"userName\":\"Haralds Värdetransporter AB\",\"userAddress\":\"Budgetvägen 1, 333 33 Uppsala\",\"vehicleRegNumber\":\"PQR678\",\"vehicleId\":\"VLUR4X20009048066\",\"vehicleStatus\":false},{\"userName\":\"Haralds Värdetransporter AB\",\"userAddress\":\"Budgetvägen 1, 333 33 Uppsala\",\"vehicleRegNumber\":\"STU901\",\"vehicleId\":\"YS2R4X20005387055\",\"vehicleStatus\":false}]";
    @Autowired
    private StatusCheckerController controller;
    @Autowired
    private RestTemplate restTemplate;
    private MockRestServiceServer mockServer;

    @Before
    public void initTest() {
        mockServer = MockRestServiceServer.createServer(restTemplate);
        ReflectionTestUtils.setField(controller.getStatusChecker(), "restTemplate", restTemplate);
    }

    @Test
    @Transactional
    public void checkStatusOfVehiclesTest() throws Exception {

        final MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

        mockServer.expect(requestTo("http://localhost:8762/statusSimulator/getVehicleStatuses"))
                .andExpect(method(HttpMethod.GET)).andRespond(withSuccess(POSSIBLE_EXPECTATION, MediaType.APPLICATION_JSON));

        MvcResult result = mockMvc.perform(get("/statusChecker/checkStatusOfVehicles"))
                .andDo(print()).andExpect(status().isOk()).andReturn();

        assertEquals(result.getResponse().getContentAsString(), POSSIBLE_RESULT);
        mockServer.verify();

    }
}

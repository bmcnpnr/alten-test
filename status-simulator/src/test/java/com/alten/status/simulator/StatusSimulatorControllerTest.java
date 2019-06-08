package com.alten.status.simulator;

import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class StatusSimulatorControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetVehicleStatuses() throws Exception {
        MvcResult result = this.mockMvc.perform(get("/statusSimulator/getVehicleStatuses"))
                .andDo(print()).andExpect(status().isOk()).andReturn();
        assertTrue(isJsonValid(result.getResponse().getContentAsString()));
    }

    private boolean isJsonValid(String json) {
        try {
            new JsonParser().parse(json).getAsJsonArray();
        } catch (JsonSyntaxException ex) {
            return false;
        }
        return true;
    }
}

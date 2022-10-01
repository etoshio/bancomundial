package br.com.bancomundial.controller;

import br.com.bancomundial.service.WorldBankService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class WorldBankControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private WorldBankService service;
    @Autowired
    private ObjectMapper objectMapper;


    @Test
    void testSuccess() throws Exception {
        mockMvc.perform(get("/v1/worldbank/{countryCode}", "BRA"))
                .andExpect(status().isOk()).andReturn();
    }
    @Test
    void testNotFound() throws Exception {
        mockMvc.perform(get("/v1/worldbank/{countryCode}", "XXA"))
                .andExpect(status().isNotFound()).andReturn();
    }
}
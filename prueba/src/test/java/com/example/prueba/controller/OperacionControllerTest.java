package com.example.prueba.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(OperacionController.class)
public class OperacionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testCalcularTasa() throws Exception {
        String requestBody = "{\"marca\":\"VISA\",\"numero\":\"1234\",\"cardholder\": \"Juan Perez\",\"fechaVencimiento\":\"2023-09-01\"}";
        
        mockMvc.perform(post("/procesamiento")
                .contentType("application/json")
                .content(requestBody)
                .param("marca", "VISA")
                .param("importe", "500.0"))
                .andExpect(status().isOk());
    }
}

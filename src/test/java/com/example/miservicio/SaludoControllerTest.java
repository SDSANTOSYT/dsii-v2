package com.example.miservicio;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

// Test unitario (surefire): solo levanta la capa web
@WebMvcTest(SaludoController.class)
class SaludoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void saludaAlMundoPorDefecto() throws Exception {
        mockMvc.perform(get("/api/hola"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.mensaje").value("¡Hola, mundo!"));
    }

    @Test
    void saludaPorNombre() throws Exception {
        mockMvc.perform(get("/api/hola").param("nombre", "bestie"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.mensaje").value("¡Hola, bestie!"));
    }
}

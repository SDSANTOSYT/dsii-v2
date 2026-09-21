package com.example.miservicio;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

// Test de integración (failsafe): levanta la aplicación completa en un puerto aleatorio
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class MiServicioIT {

    @Autowired
    private TestRestTemplate rest;

    @Test
    void healthEstaUp() {
        ResponseEntity<String> resp = rest.getForEntity("/actuator/health", String.class);
        assertThat(resp.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(resp.getBody()).contains("\"status\":\"UP\"");
    }

    @Test
    void endpointHolaResponde() {
        ResponseEntity<String> resp = rest.getForEntity("/api/hola?nombre=CI", String.class);
        assertThat(resp.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(resp.getBody()).contains("¡Hola, CI!");
    }
}

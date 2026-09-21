package com.example.miservicio;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SaludoController {

    @GetMapping("/hola")
    public Map<String, String> hola(@RequestParam(defaultValue = "mundo") String nombre) {
        return Map.of("mensaje", "¡Hola, " + nombre + "!");
    }
}

package io.github.rhacs.contactos.api;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class ContactosRestControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    void buscarTodosShouldReturnAList() throws Exception {
        mvc
            // Simular una petición a la API
            .perform(get("/api/contactos"))
            // Esperar a que el estado de la respuesta sea HttpStatus.OK
            .andExpect(status().isOk())
            // Esperar a que el contenido devuelto sea un Json
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            // Verificar que el primer objeto del arreglo tenga un atributo "nombre" con el valor "Shamus Eilhersen"
            .andExpect(jsonPath("$[0].nombre").value("Shamus Eilhersen"))
            // Imprimir resultados en consola
            .andDo(print());
    }

    @Test
    void buscarPorIdShouldReturnAnObject() throws Exception {
        mvc
            // Simular una petición a la API
            .perform(get("/api/contactos/2"))
            // Esperar a que el estado de la respuesta sea HttpStatus.OK
            .andExpect(status().isOk())
            // Esperar a que el contenido devuelto sea un Json
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            // Verificar que el atributo "telefono" tenga el valor "8393738203"
            .andExpect(jsonPath("$.telefono").value("8393738203"))
            // Imprimir resultados en consola
            .andDo(print());
    }

}

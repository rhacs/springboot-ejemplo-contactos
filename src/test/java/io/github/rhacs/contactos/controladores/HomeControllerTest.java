package io.github.rhacs.contactos.controladores;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class HomeControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    void mostrarListadoShouldReturnCorrectView() throws Exception {
        mvc
            // Simular petición GET al controlador
            .perform(get("/"))
            // Verificar que el estado de la respuesta sea HttpStatus.OK
            .andExpect(status().isOk())
            // Verificar la vista devuelta por el controlador
            .andExpect(view().name("listado"));
    }

}

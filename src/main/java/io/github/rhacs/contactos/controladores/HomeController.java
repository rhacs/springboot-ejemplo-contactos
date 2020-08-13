package io.github.rhacs.contactos.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/")
public class HomeController {

    // Solicitudes GET
    // -----------------------------------------------------------------------------------------

    @GetMapping
    public String mostrarListado() {
        return "listado";
    }

}

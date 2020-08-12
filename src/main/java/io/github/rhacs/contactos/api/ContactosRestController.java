package io.github.rhacs.contactos.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.rhacs.contactos.modelos.Contacto;
import io.github.rhacs.contactos.repositorios.ContactosRepositorio;

@RestController
@RequestMapping(path = "/api/contactos", produces = MediaType.APPLICATION_JSON_VALUE)
public class ContactosRestController {

    // Atributos
    // -----------------------------------------------------------------------------------------

    /**
     * Objeto {@link ContactosRepositorio} con los métodos de manipulación del
     * repositorio de {@link Contacto}s
     */
    @Autowired
    private ContactosRepositorio contactosRepositorio;

    // Solicitudes GET
    // -----------------------------------------------------------------------------------------

    /**
     * Muestra todos los registros almacenados en el repositorio
     * 
     * @return un objeto {@link ResponseEntity} con la respuesta a la solicitud
     */
    @GetMapping
    public ResponseEntity<List<Contacto>> buscarTodos() {
        // Obtener todos los registros del repositorio
        List<Contacto> contactos = contactosRepositorio.findAll();

        // Crear y devolver respuesta
        return ResponseEntity.status(HttpStatus.OK).body(contactos);
    }

    /**
     * Muestra la información del registro solicitado
     * 
     * @param id identificador numérico del {@link Contacto}
     * @return un objeto {@link ResponseEntity} con la respuesta a la solicitud
     */
    @GetMapping(path = "/{id:^[0-9]+$}")
    public ResponseEntity<Contacto> buscarUno(@PathVariable Long id) {
        // Buscar contacto en el repositorio, si no existe, lanzar excepción
        // NoSuchElementException
        Contacto contacto = contactosRepositorio.findById(id).orElseThrow();

        // Crear y devolver respuesta
        return ResponseEntity.status(HttpStatus.OK).body(contacto);
    }

    // Solicitudes POST
    // -----------------------------------------------------------------------------------------

    /**
     * Agrega un nuevo registro al repositorio
     * 
     * @param contacto objeto {@link Contacto} con la información a agregar
     * @return un objeto {@link ResponseEntity} con la respuesta a la solicitud
     */
    @PostMapping
    public ResponseEntity<Contacto> agregarRegistro(@RequestBody Contacto contacto) {
        // Guardar registro en el repositorio
        contacto = contactosRepositorio.save(contacto);

        // Crear y devolver respuesta
        return ResponseEntity.status(HttpStatus.CREATED).body(contacto);
    }

    // Solicitudes PUT
    // -----------------------------------------------------------------------------------------

    /**
     * Edita la información de un registro
     * 
     * @param id       identificador numérico del {@link Contacto}
     * @param contacto objeto {@link Contacto} con la información a editar
     * @return un objeto {@link ResponseEntity} con la respuesta a la solicitud
     */
    @PutMapping(path = "/{id:^[0-9]+$}")
    public ResponseEntity<Contacto> editarRegistro(@PathVariable Long id, @RequestBody Contacto contacto) {
        // Guardar información del registro
        contacto = contactosRepositorio.save(contacto);

        // Crear y devolver respuesta
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(contacto);
    }

}

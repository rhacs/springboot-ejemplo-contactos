package io.github.rhacs.contactos.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.github.rhacs.contactos.modelos.Contacto;

@Repository
public interface ContactosRepositorio extends JpaRepository<Contacto, Long> {

}

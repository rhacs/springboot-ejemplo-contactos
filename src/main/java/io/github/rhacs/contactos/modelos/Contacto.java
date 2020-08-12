package io.github.rhacs.contactos.modelos;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "contactos")
/*
 * @SequenceGenerator define un generador de secuencias
 * - allocationSize = cantidad de números a avanzar cuando se genera un nuevo valor
 * - initialValue = valor inicial
 * - name = nombre del generador, tiene que se único
 */
@SequenceGenerator(allocationSize = 1, initialValue = 1, name = "contactos_seq")
public class Contacto {

    // Atributos
    // -----------------------------------------------------------------------------------------

    /**
     * Identificador numérico del {@link Contacto}
     */
    // @Id marca el atributo de la clase como la llave primaria de la tabla
    @Id
    /*
     * @GeneratedValue indica que es un valor generado por el sistema/base de datos
     * - generator: nombre de la secuencia encargada de generar los valores para el
     * atributo - strategy: estrategia que se utilizará para generar los valores
     */
    @GeneratedValue(generator = "contactos_seq", strategy = GenerationType.SEQUENCE)
    // @Column permite indicar las propiedades de la columna en la base de datos
    @Column(name = "contacto_id", nullable = false, unique = true, updatable = false)
    private Long id;

    /**
     * Nombre del {@link Contacto}
     */
    private String nombre;

    /**
     * Dirección del {@link Contacto}
     */
    private String direccion;

    /**
     * Número de teléfono del {@link Contacto}
     */
    private String telefono;

    /**
     * Dirección de correo electrónico del {@link Contacto}
     */
    @Column(unique = true)
    private String email;

    // Constructores
    // -----------------------------------------------------------------------------------------

    /**
     * Crea una nueva instancia vacía de la clase {@link Contacto}
     */
    public Contacto() {
        // Constructor vacío
    }

    /**
     * Crea una nueva instancia de la clase {@link Contacto}
     * 
     * @param id        identificador numérico
     * @param nombre    nombre completo
     * @param direccion dirección
     * @param telefono  número de teléfono
     * @param email     dirección de correo electrónico
     */
    public Contacto(Long id, String nombre, String direccion, String telefono, String email) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
    }

    // Getters
    // -----------------------------------------------------------------------------------------

    /**
     * @return el identificador numérico
     */
    public Long getId() {
        return id;
    }

    /**
     * @return el nombre completo
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @return la dirección
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @return el número de teléfono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * @return la dirección de correo electrónico
     */
    public String getEmail() {
        return email;
    }

    // Setters
    // -----------------------------------------------------------------------------------------

    /**
     * @param id el identificador numérico a establecer
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @param nombre el nombre completo a establecer
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @param direccion la dirección a establecer
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @param telefono el número de teléfono a establecer
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * @param email la dirección de correo electrónico a establecer
     */
    public void setEmail(String email) {
        this.email = email;
    }

    // Herencias (Object)
    // -----------------------------------------------------------------------------------------

    @Override
    public int hashCode() {
        return Objects.hash(email, id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null)
            return false;

        if (getClass() != obj.getClass())
            return false;

        Contacto other = (Contacto) obj;

        return Objects.equals(email, other.email) && Objects.equals(id, other.id);
    }

    @Override
    public String toString() {
        return String.format("Contacto [id=%s, nombre=%s, direccion=%s, telefono=%s, email=%s]", id, nombre, direccion,
                telefono, email);
    }

}

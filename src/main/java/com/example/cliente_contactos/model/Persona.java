package com.example.cliente_contactos.model;

import lombok.Data;

@Data
public class Persona {

    private int idContacto;
    private String nombre;
    private String email;
    private int edad;

    public Persona(int idContacto, String nombre, String email, int edad) {
        super();
        this.idContacto = idContacto;
        this.nombre = nombre;
        this.email = email;
        this.edad = edad;
    }

    public Persona(){
        super();
    }

}

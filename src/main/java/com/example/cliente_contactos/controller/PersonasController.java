package com.example.cliente_contactos.controller;

import com.example.cliente_contactos.model.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class PersonasController {

    @Autowired
    RestTemplate restTemplate;

    String url = "http://localhost:8080";

    @GetMapping(value = "/personas/{id}/{name}/{email}/{age}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Persona> altaPersona(@PathVariable("id") int idContacto, @PathVariable("name") String nombre,
                                     @PathVariable("email") String email, @PathVariable("age") int edad){

        var persona = new Persona(idContacto,nombre,email,edad);
        restTemplate.postForLocation(url+"/contactos/agregar",persona);
        var personas = restTemplate.getForObject(url+"/contactos", Persona[].class);
        return Arrays.stream(personas).toList();
    }

    @GetMapping(value = "/personas/buscarEdades/{edad1}/{edad2}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Persona> buscarEdades(@PathVariable("edad1") int edad1,@PathVariable("edad2") int edad2 ){
        var personas = restTemplate.getForObject(url+"/contactos", Persona[].class);
        return Arrays.stream(personas).filter(persona -> persona.getEdad()>=edad1&&
                persona.getEdad()<=edad2).collect(Collectors.toList());
    }
}

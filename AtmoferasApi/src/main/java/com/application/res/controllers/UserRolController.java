package com.application.res.controllers;

import com.application.res.entities.User;
import com.application.res.service.IUserRolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/userRol")
public class UserRolController {

    //Inyectamos nuestro service
    @Autowired
    private IUserRolService userRolService;

    /**
     * Voy a agregar el metodo de findById, este, retornará un ResponseEntity de cualquier cosa (<?>)
     * Si se va a utilizar el {id} en el endpoind en mi metodo debo especificar que va a recibir un @PathVariable
     */
    @GetMapping("/find/{id}")
    public ResponseEntity<?> finById(@PathVariable Long id){
        Optional<User> userOptional = userRolService.findAll(id);
    }
}

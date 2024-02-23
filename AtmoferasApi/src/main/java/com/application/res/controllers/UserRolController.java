package com.application.res.controllers;

import com.application.res.controllers.dto.UserRolDTO;
import com.application.res.entities.User;
import com.application.res.entities.UserRol;
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
    public ResponseEntity<?> finById(@PathVariable Long id) {
        Optional<UserRol> userRolOptional = userRolService.findById(id);

        /**
         * Vamos a retornar el usuario encontrado por id pero yo no puedo retornar un userOptional porque esto devuelve una entidad y es una mala practica retornar Entities
         * Lad buenas practicas explican que eso debe hacerse a traves de un DTO (Data Transfer Object)
         */

        if(userRolOptional.isPresent()){
            //Extraemos los atributos del Entity
            UserRol userRol = userRolOptional.get();

            //Seteamos los atributos en el DTO
            UserRolDTO userRolDTO = UserRolDTO.builder()
                    .id(userRol.getId())
                    .type_rol(userRol.getType_rol())
                    .active(userRol.getActive())
                    .userList(userRol.getUserList())
                    .build();

            return ResponseEntity.ok(userRolDTO);
        }

        // Si no encontro el objeto a retornar
        return ResponseEntity.notFound().build();
    }

}

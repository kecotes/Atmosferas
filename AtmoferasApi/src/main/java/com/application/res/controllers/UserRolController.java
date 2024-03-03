package com.application.res.controllers;

import com.application.res.controllers.dto.UserRolDTO;
import com.application.res.entities.User;
import com.application.res.entities.UserRol;
import com.application.res.service.IUserRolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;


@CrossOrigin(origins = "http://localhost:8100")
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
         * Lad buenas prácticas explican que eso debe hacerse a traves de un DTO (Data Transfer Object)
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

        // Si no encontró el objeto a retornar
        return ResponseEntity.notFound().build();
    }


    @GetMapping("/findAll")
    public ResponseEntity<?> findAll(){
        /*
        * userRolService.findAll()
        * Eso me devuelve un listado de UseRol, una entidad, y no se puede hacer eso, se debe convertir esa Entity a DTO
        *
        * List<UserRolDTO> userRolDTOList = userRolService.findAll(); // Error
        *
        * Como no se le puede asignar un userRol al DTO con el operador igual, lo que hacemos es que convertimos el UserRol seguido
        */
        List<UserRolDTO> userRolDTOList = userRolService.findAll()
                .stream()
                .map(userRol -> UserRolDTO.builder()
                        .id(userRol.getId())
                        .type_rol(userRol.getType_rol())
                        .active(userRol.getActive())
                        .userList(userRol.getUserList())
                        .build())
                .toList();

        return ResponseEntity.ok(userRolDTOList);

    }


    // Recuerda: Siempre que retornemos o recibamos un objeto debe ser un DTO
    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody UserRolDTO userRolDTO) throws URISyntaxException {

        if(userRolDTO.getType_rol().isBlank()){
            return ResponseEntity.badRequest().build();
        }

        userRolService.save(UserRol.builder()
                .type_rol(userRolDTO.getType_rol())
                .build());

        return ResponseEntity.created(new URI("/api/userRol/save")).build();
    }


    @PutMapping("update/{id}")
    public ResponseEntity<?> updateUserRol(@PathVariable Long id, @RequestBody UserRolDTO userRolDTO){

        //Validamos si el objeto ya existe
        Optional<UserRol> userRolOptional = userRolService.findById(id);

        if(userRolOptional.isPresent()){ // Si el UserRol existe
            UserRol userRol = userRolOptional.get(); // Recuperamos el entity userRol
            userRol.setType_rol(userRolDTO.getType_rol()); // Setteamos el nombre, se lo cambiamos
            userRol.setActive(userRolDTO.getActive()); // Setteamos active, se lo cambiamos
            userRolService.save(userRol); // Luego lo volvemos a guardar
            return ResponseEntity.ok("Registo actualizado");
        }

        return ResponseEntity.notFound().build();

    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        if(id != null){
            userRolService.deleteById(id);
            return ResponseEntity.ok("Registro Eliminado");
        }

        return ResponseEntity.badRequest().build();
    }

}

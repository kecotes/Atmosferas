package com.application.res.controllers;

import com.application.res.controllers.dto.UserDTO;
import com.application.res.entities.User;
import com.application.res.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private IUserService userService;


    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        Optional<User> userOptional = userService.findById(id);

        if(userOptional.isPresent()){
            User user = userOptional.get();
            UserDTO userDTO = UserDTO.builder()
                    .id(user.getId())
                    .name(user.getName())
                    .lastname(user.getLastname())
                    .email(user.getEmail())
                    .password(user.getPassword())
                    .type_document(user.getType_document())
                    .document(user.getDocument())
                    .date_of_birth(user.getDate_of_birth())
                    .pais(user.getPais())
                    .department(user.getDepartment())
                    .city(user.getCity())
                    .address(user.getAddress())
                    .created_at(user.getCreated_at())
                    .update_at(user.getUpdate_at())
                    .rol(user.getRol())
                    .build();

            return ResponseEntity.ok(userDTO);
        }

        return ResponseEntity.notFound().build();
    }


    @GetMapping("/findAll")
    public ResponseEntity<?> findAll(){
        List<UserDTO> userDTOList = userService.findAll()
                .stream()
                .map(user -> UserDTO.builder()
                        .id(user.getId())
                        .name(user.getName())
                        .lastname(user.getLastname())
                        .email(user.getEmail())
                        .password(user.getPassword())
                        .type_document(user.getType_document())
                        .document(user.getDocument())
                        .date_of_birth(user.getDate_of_birth())
                        .pais(user.getPais())
                        .department(user.getDepartment())
                        .city(user.getCity())
                        .address(user.getAddress())
                        .created_at(user.getCreated_at())
                        .update_at(user.getUpdate_at())
                        .rol(user.getRol())
                        .userHasProductList(user.getUserHasProductList())
                        .build())
                .toList();
        return ResponseEntity.ok(userDTOList);
    }


    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody UserDTO userDTO) throws URISyntaxException {

        if(userDTO.getName().isBlank() || userDTO.getDocument().isBlank() || userDTO.getEmail().isBlank()){
            return ResponseEntity.badRequest().build();
        }

        User user = User.builder()
                .id(userDTO.getId())
                .name(userDTO.getName())
                .lastname(userDTO.getLastname())
                .email(userDTO.getEmail())
                .password(userDTO.getPassword())
                .type_document(userDTO.getType_document())
                .document(userDTO.getDocument())
                .date_of_birth(userDTO.getDate_of_birth())
                .pais(userDTO.getPais())
                .department(userDTO.getDepartment())
                .city(userDTO.getCity())
                .address(userDTO.getAddress())
                .created_at(userDTO.getCreated_at())
                .update_at(userDTO.getUpdate_at())
                .rol(userDTO.getRol())
                .build();

        userService.save(user);

        return ResponseEntity.created(new URI("/api/user/save")).build();
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Long id, @RequestBody UserDTO userDTO){

        Optional<User> userOptional = userService.findById(id);

        if(userOptional.isPresent()){
            User user = userOptional.get();
            user.setName(userDTO.getName());
            user.setLastname(userDTO.getLastname());
            user.setEmail(userDTO.getEmail());
            user.setPassword(userDTO.getPassword());
            user.setType_document(userDTO.getType_document());
            user.setDocument(userDTO.getDocument());
            user.setDate_of_birth(userDTO.getDate_of_birth());
            user.setPais(userDTO.getPais());
            user.setDepartment(userDTO.getDepartment());
            user.setCity(userDTO.getCity());
            user.setAddress(userDTO.getAddress());
            userService.save(user);

            return ResponseEntity.ok("Registro actualizado !");
        }

        return ResponseEntity.notFound().build();
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        if(id != null){
            userService.deleteById(id);
            return ResponseEntity.ok("Registro eliminado");
        }

        return ResponseEntity.badRequest().build();
    }
}

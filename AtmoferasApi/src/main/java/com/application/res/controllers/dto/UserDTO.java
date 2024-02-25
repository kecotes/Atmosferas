package com.application.res.controllers.dto;

import com.application.res.entities.UserHasProduct;
import com.application.res.entities.UserRol;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {

    private Long id;
    private String name;
    private String lastname;
    private String email;
    private String password;
    private String type_document;
    private String document;
    private LocalDateTime date_of_birth;
    private String pais;
    private String department;
    private String city;
    private String address;
    private LocalDateTime created_at;
    private LocalDateTime update_at;

    private UserRol rol;
    private List<UserHasProduct> userHasProductList = new ArrayList<>();
}

package com.application.res.controllers.dto;

import com.application.res.entities.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRolDTO {
    private Long id;
    private String type_rol;
    private Integer active;
    private List<User> userList = new ArrayList<>();
}

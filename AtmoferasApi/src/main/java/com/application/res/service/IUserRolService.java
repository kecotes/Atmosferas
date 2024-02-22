package com.application.res.service;

import com.application.res.entities.UserRol;

import java.util.List;
import java.util.Optional;

public interface IUserRolService {

    List<UserRol> findAll();

    //Este metodo devuelve un optional
    Optional<UserRol> findById(Long id);

    void save(UserRol userRol);

    void deleteById(Long id);

}

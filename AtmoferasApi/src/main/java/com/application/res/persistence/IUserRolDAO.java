package com.application.res.persistence;

import com.application.res.entities.UserRol;

import java.util.List;
import java.util.Optional;

public interface IUserRolDAO {

    List<UserRol> findAll();

    //Este metodo devuelve un optional
    Optional<UserRol> findById(Long id);

    void save(UserRol userRol);

    void deleteById(Long id);
}

package com.application.res.persistence.impl;

import com.application.res.entities.UserRol;
import com.application.res.persistence.IUserRolDAO;
import com.application.res.repository.UserRolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserRolDAOImpl implements IUserRolDAO {

    @Autowired
    private UserRolRepository userRolRepository;

    @Override
    public List<UserRol> findAll() {
        return (List<UserRol>) userRolRepository.findAll();
    }

    @Override
    public Optional<UserRol> findById(Long id) {
        return userRolRepository.findById(id);
    }

    @Override
    public void save(UserRol userRol) {
        userRolRepository.save(userRol);
    }

    @Override
    public void deleteById(Long id) {
        userRolRepository.deleteById(id);
    }
}

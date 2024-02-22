package com.application.res.service.impl;

import com.application.res.entities.UserRol;
import com.application.res.service.IUserRolService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserRolServiceImpl implements IUserRolService {
    @Override
    public List<UserRol> findAll() {
        return null;
    }

    @Override
    public Optional<UserRol> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public void save(UserRol userRol) {

    }

    @Override
    public void deleteById(Long id) {

    }
}

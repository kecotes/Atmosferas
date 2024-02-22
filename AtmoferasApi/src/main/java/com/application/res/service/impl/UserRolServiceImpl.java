package com.application.res.service.impl;

import com.application.res.entities.UserRol;
import com.application.res.persistence.IUserRolDAO;
import com.application.res.service.IUserRolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserRolServiceImpl implements IUserRolService {

    @Autowired
    private IUserRolDAO userRolDAO;

    @Override
    public List<UserRol> findAll() {
        return userRolDAO.findAll();
    }

    @Override
    public Optional<UserRol> findById(Long id) {
        return userRolDAO.findById(id);
    }

    @Override
    public void save(UserRol userRol) {
        userRolDAO.save(userRol);
    }

    @Override
    public void deleteById(Long id) {
        userRolDAO.deleteById(id);
    }
}

package com.application.res.service.impl;

import com.application.res.entities.User;
import com.application.res.persistence.IUserDAO;
import com.application.res.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {

    //Voy a inyectar mi DAO de la capa persistencia
    @Autowired
    private IUserDAO userDAO;

    @Override
    public List<User> findAll() {
        return (List<User>) userDAO.findAll();
    }

    @Override
    public Optional<User> findById(Long id) {
        return userDAO.findById(id);
    }

    @Override
    public List<User> findByBirthdayInRange(LocalDateTime firstDate, LocalDateTime secondDate) {
        return userDAO.findByBirthdayInRange(firstDate, secondDate);
    }

    @Override
    public void save(User user) {
        userDAO.save(user);
    }

    @Override
    public void deleteById(Long id) {
        userDAO.deleteById(id);
    }
}

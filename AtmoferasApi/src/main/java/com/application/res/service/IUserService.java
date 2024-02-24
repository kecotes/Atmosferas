package com.application.res.service;

import com.application.res.entities.User;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface IUserService {
    List<User> findAll();

    Optional<User> findById(Long id);

    //List<User> findByBirthdayInRange(LocalDateTime firstDate, LocalDateTime secondDate);

    void save(User user);

    void deleteById(Long id);
}

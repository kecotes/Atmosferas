package com.application.res.persistence.impl;

import com.application.res.entities.UserHasProduct;
import com.application.res.persistence.IUserHasProductDAO;
import com.application.res.repository.UserHasProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserHasProductDAOImpl implements IUserHasProductDAO {

    @Autowired
    private UserHasProductRepository userHasProductRepository;


    @Override
    public List<UserHasProduct> findAll() {
        return (List<UserHasProduct>) userHasProductRepository.findAll();
    }

    @Override
    public Optional<UserHasProduct> findById(Long id) {
        return userHasProductRepository.findById(id);
    }

    @Override
    public void save(UserHasProduct userHasProduct) {
        userHasProductRepository.save(userHasProduct);
    }

    @Override
    public void deleteById(Long id) {
        userHasProductRepository.deleteById(id);
    }
}

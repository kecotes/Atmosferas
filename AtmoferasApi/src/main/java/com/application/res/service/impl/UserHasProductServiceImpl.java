package com.application.res.service.impl;

import com.application.res.entities.UserHasProduct;
import com.application.res.persistence.IUserHasProductDAO;
import com.application.res.service.IUserHasProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserHasProductServiceImpl implements IUserHasProductService {

    @Autowired
    private IUserHasProductDAO userHasProductDAO;

    @Override
    public List<UserHasProduct> findAll() {
        return userHasProductDAO.findAll();
    }

    @Override
    public Optional<UserHasProduct> findById(Long id) {
        return userHasProductDAO.findById(id);
    }

    @Override
    public void save(UserHasProduct userHasProduct) {
        userHasProductDAO.save(userHasProduct);
    }

    @Override
    public void deleteById(Long id) {
        userHasProductDAO.deleteById(id);
    }
}

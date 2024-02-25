package com.application.res.service;

import com.application.res.entities.UserHasProduct;

import java.util.List;
import java.util.Optional;

public interface IUserHasProductService {

    List<UserHasProduct> findAll();

    Optional<UserHasProduct> findById(Long id);

    void save(UserHasProduct userHasProduct);

    void deleteById(Long id);

}

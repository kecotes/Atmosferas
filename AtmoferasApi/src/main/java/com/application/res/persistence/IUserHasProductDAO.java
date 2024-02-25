package com.application.res.persistence;

import com.application.res.entities.UserHasProduct;

import java.util.List;
import java.util.Optional;

public interface IUserHasProductDAO {

    List<UserHasProduct> findAll();

    Optional<UserHasProduct> findById(Long id);

    void save(UserHasProduct userHasProduct);

    void deleteById(Long id);
}

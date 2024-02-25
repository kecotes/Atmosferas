package com.application.res.repository;

import com.application.res.entities.UserHasProduct;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserHasProductRepository extends CrudRepository<UserHasProduct, Long> {
}

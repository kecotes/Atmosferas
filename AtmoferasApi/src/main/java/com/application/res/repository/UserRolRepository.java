package com.application.res.repository;

import com.application.res.entities.UserRol;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRolRepository extends CrudRepository<UserRol, Long> {
}

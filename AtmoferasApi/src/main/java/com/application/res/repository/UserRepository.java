package com.application.res.repository;

import com.application.res.entities.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    /*
     * Todo esto es gracias a JPA
     * Query Methods
     * Buscar en User por date_of_birth entre las fechas
     */
    List<User> findUserByDate_of_birthBetween(LocalDateTime dateFirst, LocalDateTime dateLast);


    /**
     * Notación Query
     * La notación query utiliza un lenguaje muy parecido a SQL pero no es SQL
     * De hecho se llama jpqe un lenguaje propio de JPA
     * ?1 hace referencia al primer parametro y ?2 al segundo
     * Utilizando el operador >= y <= decimos que está entre estos dos parametros tambien sirve
     * Para valores numericos y tambien se puede hacer con between
     *
     *  @Query("SELECT u FROM User u WHERE u.date_of_birth >= ?1 AND u.date_of_birth <= ?2")
     */
    @Query("SELECT u FROM User u WHERE u.date_of_birth BETWEEN ?1 AND ?2 ")
    List<User> findUserDateInRange(LocalDateTime dateFirst, LocalDateTime dateLast);
}

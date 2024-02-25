package com.application.res.controllers.dto;

import com.application.res.entities.Product;
import com.application.res.entities.User;

import java.time.LocalDateTime;

public class UserHasProductDTO {

    private Long id;
    private LocalDateTime created_at;
    private User id_user;
    private Product id_product;
}

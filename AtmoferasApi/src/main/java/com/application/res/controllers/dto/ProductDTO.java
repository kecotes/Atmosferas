package com.application.res.controllers.dto;

import com.application.res.entities.UserHasProduct;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ProductDTO {
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private String image;
    private LocalDateTime created_at;
    private List<UserHasProduct> productHasUsertList = new ArrayList<>();
}

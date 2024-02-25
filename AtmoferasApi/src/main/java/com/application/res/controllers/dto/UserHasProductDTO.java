package com.application.res.controllers.dto;

import com.application.res.entities.Product;
import com.application.res.entities.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserHasProductDTO {

    private Long id;
    private LocalDateTime created_at;
    private User user;
    private Product product;
}

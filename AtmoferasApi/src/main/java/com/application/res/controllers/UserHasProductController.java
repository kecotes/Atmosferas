package com.application.res.controllers;

import com.application.res.controllers.dto.UserHasProductDTO;
import com.application.res.entities.UserHasProduct;
import com.application.res.service.IUserHasProductService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/userHasProduct")
public class UserHasProductController {

    @Autowired
    private IUserHasProductService userHasProductService;


    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        Optional<UserHasProduct> userHasProductOptional = userHasProductService.findById(id);

        if(userHasProductOptional.isPresent()){
            UserHasProduct userHasProduct = userHasProductOptional.get();

            UserHasProductDTO userHasProductDTO = UserHasProductDTO.builder()
                    .id(userHasProduct.getId())
                    .created_at(userHasProduct.getCreated_at())
                    .user(userHasProduct.getUser())
                    .product(userHasProduct.getProduct())
                    .build();

            return ResponseEntity.ok(userHasProductDTO);
        }

        return ResponseEntity.notFound().build();
    }


    @GetMapping("/findAll")
    public ResponseEntity<?> findAll(){
        List<UserHasProductDTO> userHasProductDTOList = userHasProductService.findAll()
                .stream()
                .map(userHasProduct -> UserHasProductDTO.builder()
                        .id(userHasProduct.getId())
                        .created_at(userHasProduct.getCreated_at())
                        .user(userHasProduct.getUser())
                        .product(userHasProduct.getProduct())
                        .build())
                .toList();

        return ResponseEntity.ok(userHasProductDTOList);
    }


    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody UserHasProductDTO userHasProductDTO) throws URISyntaxException {

        if(userHasProductDTO.getCreated_at() == null){
            return ResponseEntity.badRequest().build();
        }

        UserHasProduct userHasProduct = UserHasProduct.builder()
                .id(userHasProductDTO.getId())
                .created_at(userHasProductDTO.getCreated_at())
                .user(userHasProductDTO.getUser())
                .product(userHasProductDTO.getProduct())
                .build();

        userHasProductService.save(userHasProduct);

        return ResponseEntity.created(new URI("/api/userHasProduct/save")).build();
    }
}

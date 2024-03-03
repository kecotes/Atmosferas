package com.application.res.controllers;

import com.application.res.controllers.dto.CompareDTO;
import com.application.res.controllers.dto.ProductDTO;
import com.application.res.controllers.dto.UserDTO;
import com.application.res.entities.Product;
import com.application.res.entities.User;
import com.application.res.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8100")
@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private IProductService productService;

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        Optional<Product> productOptional = productService.findById(id);

        if(productOptional.isPresent()){
            Product product = productOptional.get();

            ProductDTO productDTO = ProductDTO.builder()
                    .id(product.getId())
                    .name(product.getName())
                    .description(product.getDescription())
                    .price(product.getPrice())
                    .image(product.getImage())
                    .created_at(product.getCreated_at())
                    .updated_at(product.getUpdated_at())
                    .build();
            return ResponseEntity.ok(productDTO);
        }

        return ResponseEntity.notFound().build();
    }


    @GetMapping("/findAll")
    public ResponseEntity<?> findAll(){
        List<ProductDTO> productDTOList = productService.findAll()
                .stream()
                .map(product -> ProductDTO.builder()
                        .id(product.getId())
                        .name(product.getName())
                        .description(product.getDescription())
                        .price(product.getPrice())
                        .image(product.getImage())
                        .created_at(product.getCreated_at())
                        .updated_at(product.getUpdated_at())
                        .productHasUsertList(product.getProductHasUsertList())
                        .build())
                .toList();

        return ResponseEntity.ok(productDTOList);
    }


    @PostMapping("/compare")
    public ResponseEntity<?> findProductByPriceBetween(@RequestBody CompareDTO compareDTO){
        List<ProductDTO> productDTOList = productService.findProductByPriceBetween(compareDTO.getMinPrice(), compareDTO.getMaxPrice())
                .stream()
                .map(product -> ProductDTO.builder()
                        .id(product.getId())
                        .name(product.getName())
                        .description(product.getDescription())
                        .price(product.getPrice())
                        .image(product.getImage())
                        .created_at(product.getCreated_at())
                        .updated_at(product.getUpdated_at())
                        .productHasUsertList(product.getProductHasUsertList())
                        .build())
                .toList();

        return ResponseEntity.ok(productDTOList);
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody ProductDTO productDTO) throws URISyntaxException {

        if(productDTO.getName() == "" || productDTO.getDescription() == "" ){
            System.out.println("Esta entrando aqui");
            return ResponseEntity.badRequest().build();
        }

        Product product = Product.builder()
                .id(productDTO.getId())
                .name(productDTO.getName())
                .description(productDTO.getDescription())
                .price(productDTO.getPrice())
                .image(productDTO.getImage())
                .created_at(productDTO.getCreated_at())
                .updated_at(productDTO.getUpdated_at())
                .productHasUsertList(productDTO.getProductHasUsertList())
                .build();

        productService.save(product);

        return ResponseEntity.created(new URI("/api/product/save")).build();
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable Long id, @RequestBody ProductDTO productDTO){

        Optional<Product> productOptional = productService.findById(id);

        if(productOptional.isPresent()){
            Product product = productOptional.get();
            product.setName(productDTO.getName());
            product.setDescription(productDTO.getDescription());
            product.setPrice(productDTO.getPrice());
            product.setImage(productDTO.getImage());
            product.setCreated_at(productDTO.getCreated_at());

            productService.save(product);

            return ResponseEntity.ok("Registro actualizado");
        }

        return ResponseEntity.notFound().build();
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id){
        if( id != null){
            productService.deleteById(id);

            return ResponseEntity.ok("Registro eliminado");
        }

        return ResponseEntity.badRequest().build();
    }

}

package org.sid.inventoryservice.web;

import lombok.AllArgsConstructor;
import org.sid.inventoryservice.entities.Product;
import org.sid.inventoryservice.repositories.ProductRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
//@RequestMapping("/api")
public class ProductRestController {
    private ProductRepository productRepository;


    @GetMapping("/products")
    //@PreAuthorize("hasAuthority('ADMIN')")
    public List<Product> products(){
        return productRepository.findAll();
    }


}

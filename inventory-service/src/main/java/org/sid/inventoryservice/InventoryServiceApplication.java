package org.sid.inventoryservice;

import org.sid.inventoryservice.entities.Product;
import org.sid.inventoryservice.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.UUID;

@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(ProductRepository productRepository){
        return args -> {
            productRepository.save(Product.builder()
                    .id(UUID.randomUUID().toString())
                    .name("Compter")
                    .quantity(12)
                    .price(1500)
                    .build());
            productRepository.save(Product.builder()
                    .id(UUID.randomUUID().toString())
                    .name("Print")
                    .quantity(20)
                    .price(920)
                    .build());
            productRepository.save(Product.builder()
                    .id(UUID.randomUUID().toString())
                    .name("Phone")
                    .quantity(12)
                    .price(1300)
                    .build());
        };
    }
}

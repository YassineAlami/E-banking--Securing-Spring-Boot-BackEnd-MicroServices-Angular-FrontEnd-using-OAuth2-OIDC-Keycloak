package org.sid.customerservice;

import org.sid.customerservice.entities.Customer;
import org.sid.customerservice.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }


    @Bean
    CommandLineRunner commandLineRunner (CustomerRepository customerRepository){
        return args -> {
            customerRepository.save(Customer.builder()
                    .name("Mohammad")
                    .email("mohammad@gmail.com")
                    .build());
            customerRepository.save(Customer.builder()
                    .name("Yassine")
                    .email("yassine@gmail.com")
                    .build());
            customerRepository.save(Customer.builder()
                    .name("Nora")
                    .email("nora@gmail.com")
                    .build());
        };
    }

}

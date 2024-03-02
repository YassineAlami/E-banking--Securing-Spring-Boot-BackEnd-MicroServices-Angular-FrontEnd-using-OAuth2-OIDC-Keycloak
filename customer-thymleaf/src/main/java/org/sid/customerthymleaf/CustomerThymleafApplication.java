package org.sid.customerthymleaf;

import org.sid.customerthymleaf.entities.Customer;
import org.sid.customerthymleaf.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.ui.Model;

@SpringBootApplication
public class CustomerThymleafApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerThymleafApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(CustomerRepository customerRepository){
        return args -> {
            customerRepository.save(Customer.builder().name("Mohammad").email("med@gmail.com").build());
            customerRepository.save(Customer.builder().name("Yassine").email("yassine@gmail.com").build());
            customerRepository.save(Customer.builder().name("Nora").email("nora@gmail.com").build());
        };
    }



}

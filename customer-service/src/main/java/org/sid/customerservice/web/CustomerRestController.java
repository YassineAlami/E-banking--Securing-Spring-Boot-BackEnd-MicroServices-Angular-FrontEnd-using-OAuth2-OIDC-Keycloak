package org.sid.customerservice.web;

import lombok.AllArgsConstructor;
import org.sid.customerservice.entities.Customer;
import org.sid.customerservice.repositories.CustomerRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class CustomerRestController {
    private CustomerRepository customerRepository;

    @GetMapping("/customers")
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }

    @GetMapping("/customers/{id}")
    public Customer getCustomer(@PathVariable Long id){
        return customerRepository.findById(id).orElseThrow();
    }

    @GetMapping("/mySession")
    public Authentication authentication(Authentication authentication){
        return authentication;
    }

}

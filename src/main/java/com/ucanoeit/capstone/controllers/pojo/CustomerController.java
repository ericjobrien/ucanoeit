package com.ucanoeit.capstone.controllers.pojo;

import com.ucanoeit.capstone.model.Customer;
import com.ucanoeit.capstone.repositories.CustomerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.rmi.ServerException;

@Controller
public class CustomerController {

    private final CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @RequestMapping("/admin")
    public String getCustomers(Model model) {
        model.addAttribute("customers", customerRepository.findAll());
        return "/admin";
    }


    @PostMapping("/createCustomer")
    public String createCustomer(@RequestBody Customer customer, Model model) {
        model.addAttribute("customer", customerRepository.save(customer));
        return "index";
    }
}

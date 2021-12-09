package com.ucanoeit.capstone.controllers;

import com.ucanoeit.capstone.model.Customer;
import com.ucanoeit.capstone.repositories.CustomerRepository;
import com.ucanoeit.capstone.repositories.ProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RegistrationController {

    private final ProductRepository productRepository;
    private final CustomerRepository customerRepository;

    public RegistrationController(ProductRepository productRepository, CustomerRepository customerRepository) {
        this.productRepository = productRepository;
        this.customerRepository = customerRepository;
    }

    @RequestMapping("/registration")
    public String getRegistration(Model model) {

        model.addAttribute("customer", new Customer());
        return "registration";
    }

    @PostMapping("/registerCustomer")
    public String registerCustomer(@ModelAttribute Customer customer, Model model) {
        if (customerRepository.existsById(customer.getEmail())) {
            model.addAttribute("trueOrFalse", "false");
            return "registration";
        } else {
//            customer.setPassword(bcrypt(customer.getPassword()));

            model.addAttribute("goToHomepage", "Go to Homepage");
            model.addAttribute("customer", customerRepository.save(customer));
            model.addAttribute("trueOrFalse", "true");
        }

        return "registration";
    }

}

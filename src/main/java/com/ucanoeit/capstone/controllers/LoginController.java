package com.ucanoeit.capstone.controllers;

import com.ucanoeit.capstone.formmodel.CustomerSubmission;
import com.ucanoeit.capstone.model.CartItem;
import com.ucanoeit.capstone.model.Customer;
import com.ucanoeit.capstone.model.Product;
import com.ucanoeit.capstone.repositories.CustomerRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class LoginController {

    private final CustomerRepository customerRepository;

    public LoginController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @RequestMapping("/login")
    public String loginCustomer(Model model) {

        model.addAttribute("customers", customerRepository.findAll());

        return "login";
    }

    @GetMapping("/login/customer")
    public String getLogin(@ModelAttribute Customer customer, Model model) {

        Optional<Customer> holdingCustomer;
        holdingCustomer = customerRepository.findById(customer.getEmail());
        model.addAttribute("customers", customerRepository.findAll());

        System.out.println(customerRepository.findAll());
        System.out.println(customer.getEmail());
        System.out.println(customer.getPassword());
        System.out.println(customerRepository.findById(customer.getEmail()));
        System.out.println(holdingCustomer);
        if(holdingCustomer.get().getPassword() == customer.getPassword()) {
            return "login";
        } else {
            model.addAttribute("loginError", "Error with password.");
            return "login";
        }
//        if (customerRepository.existsById(customer.getEmail())) {
//            return "index";
//        } else {
//            model.addAttribute("loginError", "Customer not registered with email");
//        }
//        return "login";
    }
}

package com.ucanoeit.capstone.controllers;

import com.ucanoeit.capstone.model.Product;
import com.ucanoeit.capstone.repositories.CustomerRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ManageCustomersController {

    private final CustomerRepository customerRepository;

    public ManageCustomersController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @RequestMapping("/admin/customer")
    public String getCustomers(Model model) {

        model.addAttribute("customers", customerRepository.findAll());
        return "admin/customer";
    }

    @PostMapping("/admin/customer/delete")
    public String deleteCustomer(@RequestParam String email, Model model) {

        customerRepository.deleteById(email);
        model.addAttribute("customers", customerRepository.findAll());
        return "admin/customer";
    }

}

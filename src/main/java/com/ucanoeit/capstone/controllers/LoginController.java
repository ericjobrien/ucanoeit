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

    @PostMapping("/login/customer")
    public String getLogin(@ModelAttribute Customer customer, Model model) {

        Optional<Customer> holdingCustomer;
        holdingCustomer = customerRepository.findById(customer.getEmail());
        model.addAttribute("customers", customerRepository.findAll());
        int isPasswordCorrect;

        if (customerRepository.existsById(customer.getEmail())) {
            holdingCustomer = customerRepository.findById(customer.getEmail());
            isPasswordCorrect = holdingCustomer.get().getPassword().compareTo(customer.getPassword());
            if (isPasswordCorrect == 0 && holdingCustomer.get().getAdmin() == true) {

                model.addAttribute("loginSuccessful", "true");
                return "admin";
            } else if (isPasswordCorrect == 0 && holdingCustomer.get().getAdmin() == false){
                model.addAttribute("loginSuccessful", "true");
                return "index";
            } else {
                model.addAttribute("loginSuccessful", "false");
                model.addAttribute("loginError", "Password incorrect!");
                return "login";
            }
        } else {
            model.addAttribute("loginSuccessful", "false");
            model.addAttribute("loginError", "Customer with provided email address not registered");
                return "login";
        }
    }

}

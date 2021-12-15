package com.ucanoeit.capstone.controllers;

import com.ucanoeit.capstone.formmodel.CustomerSubmission;
import com.ucanoeit.capstone.model.Customer;
import com.ucanoeit.capstone.model.Product;
import com.ucanoeit.capstone.repositories.CustomerRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.Optional;

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
    public String deleteCustomer(@RequestParam String email, @ModelAttribute Customer customer, Model model) {


        customerRepository.deleteById(email);
        model.addAttribute("customers", customerRepository.findAll());
        return "admin/customer";
    }

    @PostMapping("/admin/customer/update")
    public String updateCustomer(@RequestParam String email, @ModelAttribute Customer customer, Model model) {



        customerRepository.save(customer);
        model.addAttribute("customers", customerRepository.findAll());



        return "admin/customer";
    }

}

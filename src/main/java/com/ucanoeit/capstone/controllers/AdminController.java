package com.ucanoeit.capstone.controllers;

import com.ucanoeit.capstone.model.Customer;
import com.ucanoeit.capstone.model.Product;
import com.ucanoeit.capstone.repositories.CustomerRepository;
import com.ucanoeit.capstone.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.Optional;

@Controller
public class AdminController {


    @RequestMapping("/admin")
    public String getAdmin() {
        return "admin";
    }




}

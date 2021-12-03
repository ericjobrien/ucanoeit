package com.ucanoeit.capstone.controllers;

import com.ucanoeit.capstone.repositories.ProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CanoesController {

    private final ProductRepository productRepository;

    public CanoesController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @RequestMapping("/product-list/canoes")
    public String getCanoes(Model model){

        model.addAttribute("products", productRepository.findAll());

        return "canoes";
    }
}

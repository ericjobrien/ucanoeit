package com.ucanoeit.capstone.controllers;

import com.ucanoeit.capstone.repositories.ProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class KayaksController {

    public final ProductRepository productRepository;

    public KayaksController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @RequestMapping("/product-list/kayaks")
    public String getKayaks(Model model){

        model.addAttribute("products", productRepository.findAll());
        return "kayaks";
    }
}

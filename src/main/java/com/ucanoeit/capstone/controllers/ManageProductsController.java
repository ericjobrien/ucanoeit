package com.ucanoeit.capstone.controllers;

import com.ucanoeit.capstone.model.Product;
import com.ucanoeit.capstone.repositories.ProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ManageProductsController {

    private final ProductRepository productRepository;

    public ManageProductsController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @RequestMapping("/admin/product")
    public String getProduct(Model model){

        model.addAttribute("product", new Product());
        model.addAttribute("products", productRepository.findAll());
        return "admin/product";

    }

    @PostMapping("/admin/product/create")
    public String createProduct(@ModelAttribute Product product, Model model) {
        model.addAttribute("product", productRepository.save(product));

        model.addAttribute("products", productRepository.findAll());
        return "admin/product";
    }
}

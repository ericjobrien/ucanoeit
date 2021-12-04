package com.ucanoeit.capstone.controllers;

import com.ucanoeit.capstone.repositories.ProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductPageController {

    private final ProductRepository productRepository;

    public ProductPageController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @RequestMapping("/products")
    public String getProducts(Model model) {
        model.addAttribute("products", productRepository.findAll());

        return "product-page";
    }

    @RequestMapping("/product-page/{id}")
    public String getProductPage(@PathVariable Long id, Model model) {


        productRepository.findById(id).ifPresent(o -> model.addAttribute("product", o));
        return "product-page";
    }
}

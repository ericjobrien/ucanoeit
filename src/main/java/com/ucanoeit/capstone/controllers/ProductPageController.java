package com.ucanoeit.capstone.controllers;

import com.ucanoeit.capstone.formmodel.CartItemSubmission;
import com.ucanoeit.capstone.model.CartItem;
import com.ucanoeit.capstone.repositories.CartItemRepository;
import com.ucanoeit.capstone.repositories.ProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProductPageController {

    private final CartItemRepository cartItemRepository;
    private final ProductRepository productRepository;

    public ProductPageController(CartItemRepository cartItemRepository, ProductRepository productRepository) {
        this.cartItemRepository = cartItemRepository;
        this.productRepository = productRepository;
    }

    @RequestMapping("/products")
    public String getProducts(Model model) {

        model.addAttribute("cartItem", new CartItem());
        model.addAttribute("products", productRepository.findAll());

        return "product-page";
    }

    @RequestMapping("/product-page/{id}")
    public String getProductPage(@PathVariable Long id, Model model) {

        model.addAttribute("cartItemSubmission", new CartItemSubmission(cartItemRepository));
        productRepository.findById(id).ifPresent(o -> model.addAttribute("product", o));
        return "product-page";
    }

    @RequestMapping("/product-page/cart")
    public String createCart(Model model) {
        model.addAttribute("cartItems", cartItemRepository.findAll());
        return "cart";
    }

}

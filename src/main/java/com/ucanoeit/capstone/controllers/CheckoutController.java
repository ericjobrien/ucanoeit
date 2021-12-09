package com.ucanoeit.capstone.controllers;

import com.ucanoeit.capstone.repositories.CartItemRepository;
import com.ucanoeit.capstone.repositories.CartRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CheckoutController {

    private final CartItemRepository cartItemRepository;

    public CheckoutController(CartRepository cartRepository, CartItemRepository cartItemRepository) {

        this.cartItemRepository = cartItemRepository;
    }

    @RequestMapping("/checkout")
    public String getCheckout(Model model) {

        model.addAttribute("cartItems" ,cartItemRepository.findAll());
        return "checkout";
    }

}

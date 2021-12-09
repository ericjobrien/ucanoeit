package com.ucanoeit.capstone.controllers;

import com.ucanoeit.capstone.formmodel.CartItemSubmission;
import com.ucanoeit.capstone.model.CartItem;
import com.ucanoeit.capstone.model.Product;
import com.ucanoeit.capstone.repositories.CartItemRepository;
import com.ucanoeit.capstone.repositories.ProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class CanoesController {

    private final ProductRepository productRepository;
    private final CartItemRepository cartItemRepository;

    public CanoesController(ProductRepository productRepository, CartItemRepository cartItemRepository) {
        this.productRepository = productRepository;
        this.cartItemRepository = cartItemRepository;
    }

    @RequestMapping("/product-list/canoes")
    public String getCanoes(Model model){

        model.addAttribute("cartItems", cartItemRepository.findAll());
        model.addAttribute("products", productRepository.findAll());
        return "canoes";
    }

    @PostMapping("/product-list/canoes")
    public String createCartItemFromCanoes(@ModelAttribute CartItemSubmission cartItemSubmission, Model model) {

        Optional<Product> productOptional = productRepository.findById(cartItemSubmission.getProductId());
        CartItem cartItem = new CartItem();
        cartItem.setProduct(productOptional.get());
        cartItem.setQuantity(cartItemSubmission.getQuantity());
        model.addAttribute("cartItem", cartItemRepository.save(cartItem));
        model.addAttribute("product", productOptional.get());
        model.addAttribute("products", productRepository.findAll());
        return "canoes";
    }

    @RequestMapping("/product-list/cart")
    public String createCart(Model model) {
        model.addAttribute("cartItems", cartItemRepository.findAll());
        return "cart";
    }

}

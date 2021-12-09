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
public class KayaksController {

    public final ProductRepository productRepository;
    public final CartItemRepository cartItemRepository;

    public KayaksController(ProductRepository productRepository, CartItemRepository cartItemRepository) {
        this.productRepository = productRepository;
        this.cartItemRepository = cartItemRepository;
    }

    @RequestMapping("/product-list/kayaks")
    public String getKayaks(Model model){

        model.addAttribute("products", productRepository.findAll());
        return "kayaks";
    }

    @PostMapping("/product-list/kayaks")
    public String createCartItemFromKayaks(@ModelAttribute CartItemSubmission cartItemSubmission, Model model) {

        Optional<Product> productOptional = productRepository.findById(cartItemSubmission.getProductId());
        CartItem cartItem = new CartItem();
        cartItem.setProduct(productOptional.get());
        cartItem.setQuantity(cartItemSubmission.getQuantity());
        model.addAttribute("cartItem", cartItemRepository.save(cartItem));
        model.addAttribute("product", productOptional.get());
        model.addAttribute("products", productRepository.findAll());
        return "kayaks";
    }

}

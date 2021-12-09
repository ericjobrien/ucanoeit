package com.ucanoeit.capstone.controllers;

import com.ucanoeit.capstone.formmodel.CartItemSubmission;
import com.ucanoeit.capstone.model.Cart;
import com.ucanoeit.capstone.model.CartItem;
import com.ucanoeit.capstone.model.Product;
import com.ucanoeit.capstone.repositories.CartItemRepository;
import com.ucanoeit.capstone.repositories.CartRepository;
import com.ucanoeit.capstone.repositories.ProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class CartController {

    private final CartItemRepository cartItemRepository;
    private final ProductRepository productRepository;
    private final CartRepository cartRepository;

    public CartController(CartItemRepository cartItemRepository, ProductRepository productRepository, CartRepository cartRepository) {
        this.cartItemRepository = cartItemRepository;
        this.productRepository = productRepository;
        this.cartRepository = cartRepository;
    }

    @RequestMapping("/cart")
    public String getAllCartItems(Model model) {


        model.addAttribute("cartItems", cartItemRepository.findAll());
        return "cart";
    }


    @PostMapping("/addItemToCart")
    public String createCartItem(@ModelAttribute CartItemSubmission cartItemSubmission, Model model) {

        Optional<Product> productOptional = productRepository.findById(cartItemSubmission.getProductId());
        CartItem cartItem = new CartItem();
        cartItem.setProduct(productOptional.get());
        cartItem.setQuantity(cartItemSubmission.getQuantity());
        model.addAttribute("cartItem", cartItemRepository.save(cartItem));
        model.addAttribute("product", productOptional.get());
        return "product-page";
    }

    @GetMapping("/cart/cartItem/delete")
    public String deleteCartItem(@RequestParam Long id, Model model) {

        cartItemRepository.deleteById(id);
        model.addAttribute("cartItems", cartItemRepository.findAll());
        return "cart";
    }

    @RequestMapping("/cart/cartItem/cart")
    public String getCart(Model model) {
        model.addAttribute("cartItems", cartItemRepository.findAll());
        return "cart";
    }

}

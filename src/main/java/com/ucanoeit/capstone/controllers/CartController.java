package com.ucanoeit.capstone.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CartController {

    @RequestMapping("/cart")
    public String getCart(Model model) {
        return "cart";
    }
}

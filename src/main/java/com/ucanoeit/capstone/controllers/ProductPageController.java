package com.ucanoeit.capstone.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductPageController {

    @RequestMapping("/product-page")
    public String getProductPage(Model model) {
        return "product-page";
    }
}

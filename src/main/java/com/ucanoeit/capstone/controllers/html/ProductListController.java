package com.ucanoeit.capstone.controllers.html;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductListController {

    @RequestMapping("/product-list")
    public String getProductList(Model model) {
        return "product-list";
    }
}

package com.ucanoeit.capstone.controllers.html;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CheckoutController {

    @RequestMapping("/checkout")
    public String getCheckout(Model model) {
        return "checkout";
    }
}

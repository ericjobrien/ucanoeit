package com.ucanoeit.capstone.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LogoutController {


    @RequestMapping("/logout")
    public String getLogout() {
        return "logout";
    }
}

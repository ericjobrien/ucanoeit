package com.ucanoeit.capstone.controllers.html;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RegistrationController {


    @RequestMapping("/registration")
    public String getRegistration() {
        return "registration";
    }
}

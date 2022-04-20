package com.tp1.projet1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class homeController {
    @GetMapping("/login")
    public String loginPage(){
        return "login";
    }
    @GetMapping("/home")
    public String afficherHome(){
        return "example";
    }
}

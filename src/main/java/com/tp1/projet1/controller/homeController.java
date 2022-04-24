package com.tp1.projet1.controller;

import com.tp1.projet1.service.produitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class homeController {
    @Autowired
    private com.tp1.projet1.service.produitService produitService;

    @GetMapping("/login")
    public String loginPage(){
        return "login";
    }

    @GetMapping("/logout")
    public  String logoutPage(){
        return "logout";
    }

    @GetMapping("/table")
    public String table(){
        return "Table";
    }

    @GetMapping("/admin")
    public String Admin(Model model){
        model.addAttribute("Total" ,produitService.countQte());
        return "admin";
    }

    @GetMapping("/home")
    public String afficherHome(Model model){
        return "example";
    }
}

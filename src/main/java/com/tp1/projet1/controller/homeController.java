package com.tp1.projet1.controller;

import com.tp1.projet1.service.produitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.WebAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.security.sasl.AuthenticationException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class homeController {
    @Autowired
    private com.tp1.projet1.service.produitService produitService;

    @GetMapping("/login")
    public String loginPage(){
        return "login";
    }

    /*@GetMapping("/login-error")
    public String login(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession(false);
        String errorMessage = null;
        if (session != null) {
            AuthenticationException ex = (AuthenticationException) session
                    .getAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
            if (ex != null) {
                errorMessage = ex.getMessage();
            }
        }
        model.addAttribute("errorMessage", errorMessage);
        return "login";
    }*/

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
        List<String> nameList= produitService.showProduit().stream().map(x->x.getLibelle()).collect(Collectors.toList());
        List<Integer> qteList = produitService.showProduit().stream().map(x-> x.getQteStock()).collect(Collectors.toList());
        model.addAttribute("name", nameList);
        model.addAttribute("qte", qteList);
        return "admin";
    }

    @GetMapping("/home")
    public String afficherHome(Model model){
        return "example";
    }


}

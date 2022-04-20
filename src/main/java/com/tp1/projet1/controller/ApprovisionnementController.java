package com.tp1.projet1.controller;

import com.tp1.projet1.modele.Approvisionnement;
import com.tp1.projet1.service.approvisionnementService;
import com.tp1.projet1.service.categorieService;
import com.tp1.projet1.service.produitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;

@Controller
@RequestMapping("/approvisionnement")
public class ApprovisionnementController {
    @Autowired
    private produitService produitService;
    @Autowired
    private approvisionnementService approvisionnementService;
    @Autowired
    private categorieService categorieService;

    @GetMapping("afficher")
    public String showListApprovisionnement(Model model){
        model.addAttribute("listApprovisionnement",approvisionnementService.showApprovisionnement());
        return "approvisionnement/showApprovisionnement";
    }

    @PostMapping("/save")
    public String saveApprovisionnement(Approvisionnement approvisionnement){
        approvisionnement.setDateAppro(LocalDate.now());
        approvisionnementService.saveApprovisionnement(approvisionnement);
        produitService.updateProduit(approvisionnement.getProduit_id(),approvisionnement.getQte());
        return "redirect:/produits/afficher";
    }

    @GetMapping("/approvisionner/{id}")
        public String FormEdit(@PathVariable("id") int id , Model model){
            model.addAttribute("UnProduit",produitService.showOneProduit(id));
            return "approvisionnement/formApprovisionnement";
        }

}

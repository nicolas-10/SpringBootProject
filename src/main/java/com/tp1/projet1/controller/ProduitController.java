package com.tp1.projet1.controller;

import com.tp1.projet1.modele.Produit;
import com.tp1.projet1.service.categorieService;
import com.tp1.projet1.service.produitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/produits")
public class ProduitController {

    @Autowired
    private produitService produitService;
    @Autowired
    private categorieService categorieService;

    @GetMapping("/afficher")
    public String displayProduct(Model model ,@Param("keyword") String keyword){
        List<Produit> produits = produitService.findAllProducts(keyword);
        model.addAttribute("Produits",produits);
        model.addAttribute("keyword",keyword);
        return "produit/AfficheProduit";
    }

    //Enregistrement
    @GetMapping("/form")
    public String renseigner(Model model){
        model.addAttribute("listCategories",categorieService.showCategories());
        return "produit/Enregistrer";
    }

    @PostMapping("/save")
    public String save(Produit produit){
        produit.setDateCreation(LocalDate.now());
        produit.setQteStock(0);
        produitService.saveProduit(produit);
        return "redirect:/produits/afficher";
    }

    //Mis a jour

    @GetMapping("edit/{id}")
    public String FormEdit(@PathVariable("id") int id, Model model){
        model.addAttribute("unProduit",produitService.showOneProduit(id));
        model.addAttribute("UneCategorie", categorieService.showCategories());
        return "produit/Update";
    }
    @PostMapping("/edit")
    public String editProduit(@ModelAttribute("produit") Produit produit){
        produitService.saveProduit(produit);
        return "redirect:/produits/afficher";
    }

    //Suppression

    @GetMapping("delete/{id}")
    public String deleteProduit(@PathVariable("id") int id){
        produitService.deleteProduit(id);
        return "redirect:/produit/afficher";
    }

    //Search


}

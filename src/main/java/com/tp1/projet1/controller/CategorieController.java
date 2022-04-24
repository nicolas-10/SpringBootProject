package com.tp1.projet1.controller;

import com.tp1.projet1.modele.Categorie;
import com.tp1.projet1.service.categorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/Categorie")
public class CategorieController {
    @Autowired
    private categorieService categorieService;

    @GetMapping("/afficher")
    public String ShowListCategorie(Model model){
        model.addAttribute("ListCategories", categorieService.showCategories());
        return "categorie/showCategorie";
    }

    @GetMapping("/formCategorie")
    public String formCategorie() {
        return "Categorie/formCategorie";
    }

    @PostMapping("/save")
    public String save(Categorie categorie) {
        categorieService.saveCategorie(categorie);
        return "redirect:/Categorie/afficher";
    }

    @GetMapping("/edit/{id}")
    public String editFormCategorie(@PathVariable("id") int id, Model model) {
        model.addAttribute("uneCategorie", categorieService.showOneCategorie(id));
        return "Categorie/formEditCategorie";
    }

    @PostMapping("/edit")
    public String editCategorie(@ModelAttribute("Categorie") Categorie categorie) {
        categorieService.saveCategorie(categorie);
        return "redirect:/Categorie/afficher";
    }

    @GetMapping("delete/{id}")
    public String deleteCategorie(@PathVariable("id") int id){
        categorieService.deleteCategorie(id);
        return "redirect:/Categorie/afficher";
    }
}



package com.tp1.projet1.service;

import com.tp1.projet1.modele.Categorie;
import com.tp1.projet1.repository.categorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class categorieService {
    @Autowired
    private categorieRepository categorieRepository;

    public void saveCategorie(Categorie categorie){
        categorieRepository.save(categorie);
    }

    public List<Categorie> showCategories(){
        return categorieRepository.findAll();
    }

    public Categorie showOneCategorie(int id){
        Optional<Categorie> optional = categorieRepository.findById(id);
        Categorie categorie = null;
        if(optional.isPresent()){
            categorie =optional.get();
        }
        else {
            throw new RuntimeException("Id introuvable");
        }
        return categorie;
    }
    /*public  Categorie ShowOneCategorie(int id){
        return categorieRepository.findById(id).get();
    }*/

    public void deleteCategorie(int id){
        categorieRepository.deleteById(id);
    }
}

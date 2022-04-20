package com.tp1.projet1.service;

import com.tp1.projet1.modele.Produit;
import com.tp1.projet1.repository.produitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class produitService {
    @Autowired
    private produitRepository produitRepository;


    //Enregistrement

    public void saveProduit(Produit produit){
        produitRepository.save(produit);
    }

    //Affichage
    public List<Produit> showProduit(){
        return produitRepository.findAll();
    }

    //Mis à jour
    public Produit showOneProduit(int id){
        Optional<Produit> optional = produitRepository.findById(id);
        Produit produit = null;

        if(optional.isPresent()){
            produit = optional.get();
        }
        else{
            throw new RuntimeException("Id introuvable");
        }
        return produit;
    }
    // Suppression
    public void deleteProduit(int id){
        produitRepository.deleteById(id);
    }
    public void updateProduit(int id, int qte){
        produitRepository.updateQteProduit(id ,qte);
    }

    public List<Produit> findAllProducts(String keyword){
        if(keyword!=null){
            return  produitRepository.search(keyword);
        }
        return produitRepository.findAll();
    }
}

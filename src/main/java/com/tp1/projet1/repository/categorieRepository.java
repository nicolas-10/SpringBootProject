package com.tp1.projet1.repository;

import com.tp1.projet1.modele.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface categorieRepository extends JpaRepository<Categorie,Integer> {

}

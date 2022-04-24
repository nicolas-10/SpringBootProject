package com.tp1.projet1.repository;

import com.tp1.projet1.modele.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;


@Repository
public interface produitRepository extends JpaRepository<Produit,Integer> {
    @Modifying
    @Transactional
    @Query("update Produit p set p.qteStock =p.qteStock+:qte where p.id=:id")
    void updateQteProduit(@Param("id") int id, @Param("qte") int qte);


  @Transactional
  @Query("select produit FROM Produit produit where produit.libelle LIKE %?1%")
  public List<Produit> search(String keyword);

  @Transactional
  @Query("SELECT SUM(p.qteStock) as TotalQte from Produit p")
  String CountQte();

    @Transactional
    @Query("SELECT produit from Produit produit where produit.qteStock<produit.qteSeuil")
    List<Produit> produitEnDessousSeuil();



}

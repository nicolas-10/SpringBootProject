package com.tp1.projet1.modele;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "produit")
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String libelle;
    @Column(nullable = false)
    private int qteStock;
    private int qteSeuil;
    private float prix;
    private LocalDate dateCreation;
    @ManyToOne()
    @JoinColumn(name = "categorieId",insertable = false,updatable = false)
    public Categorie categorie;
    private int categorieId;
}

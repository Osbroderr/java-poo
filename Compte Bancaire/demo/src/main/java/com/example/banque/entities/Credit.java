package com.example.banque.entities;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Credit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double montant;
    private Integer duree;
    private Double taux;
    private Date dateDebut;
    private Date dateFin;
    @ManyToOne
    private CompteBancaire compteBancaire;

    public Credit() {
    }

    public Credit(Double montant, Integer duree, Double taux, CompteBancaire compteBancaire) {
        this.montant = montant;
        this.duree = duree;
        this.taux = taux;
        this.dateDebut = new Date();
        this.dateFin = new Date(dateDebut.getTime() + duree * 30L * 24L * 60L * 60L * 1000L);
        this.compteBancaire = compteBancaire;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getMontant() {
        return montant;
    }

    public void setMontant(Double montant) {
        this.montant = montant;
    }

    public void setCompteBancaire(CompteBancaire compte) {
        this.compteBancaire = compte;
    }
}
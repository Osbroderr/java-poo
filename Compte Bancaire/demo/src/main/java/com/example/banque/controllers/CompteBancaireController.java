package com.example.banque.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.banque.entities.CompteBancaire;
import com.example.banque.services.CompteBancaireService;

@RestController
@RequestMapping("/comptes")
public class CompteBancaireController {

    @Autowired
    private CompteBancaireService compteService;

    @GetMapping("/{id}")
    public ResponseEntity<CompteBancaire> getCompteById(@PathVariable(value = "id") Long id) {
        CompteBancaire compte = compteService.findById(id);
        if (compte == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(compte);
    }

    @GetMapping("")
    public List<CompteBancaire> getAllComptes() {
        return compteService.findAll();
    }

    @PostMapping("")
    public CompteBancaire createCompte(@RequestBody CompteBancaire compte) {
        return compteService.save(compte);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CompteBancaire> updateCompte(@PathVariable(value = "id") Long id,
            @RequestBody CompteBancaire compteDetails) {
        CompteBancaire updatedCompte = compteService.save(compteDetails);
        if (updatedCompte == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedCompte);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CompteBancaire> deleteCompte(@PathVariable(value = "id") Long id) {
        CompteBancaire compte = compteService.findById(id);
        if (compte == null) {
            return ResponseEntity.notFound().build();
        }
        compteService.delete(compte);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}/crediter")
    public ResponseEntity<CompteBancaire> crediterCompte(@PathVariable(value = "id") Long id,
            @RequestParam(value = "montant") double montant) {
        CompteBancaire compte = compteService.findById(id);
        if (compte == null) {
            return ResponseEntity.notFound().build();
        }
        compte = compteService.crediterCompte(compte, montant);
        return ResponseEntity.ok(compte);
    }

    @PutMapping("/{id}/debiter")
    public ResponseEntity<CompteBancaire> debiterCompte(@PathVariable(value = "id") Long id,
            @RequestParam(value = "montant") double montant) {
        CompteBancaire compte = compteService.findById(id);
        if (compte == null) {
            return ResponseEntity.notFound().build();
        }
        compte = compteService.debiterCompte(compte, montant);
        return ResponseEntity.ok(compte);
    }

}

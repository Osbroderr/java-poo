package com.example.banque.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.banque.entities.CompteBancaire;
import com.example.banque.repositories.CompteBancaireRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CompteBancaireServiceImpl implements CompteBancaireService {

    @Autowired
    private CompteBancaireRepository compteBancaireRepository;

    @Override
    public CompteBancaire findById(Long id) {
        return compteBancaireRepository.findById(id).orElse(null);
    }

    @Override
    public List<CompteBancaire> findAll() {
        return compteBancaireRepository.findAll();
    }

    @Override
    public Optional<CompteBancaire> findByClientId(Long id) {
        return compteBancaireRepository.findById(id);
    }

    @Override
    public CompteBancaire debiterCompte(CompteBancaire compte, double montant) {
        Optional<CompteBancaire> optionalCompte = compteBancaireRepository.findById(compte.getId());
        if (optionalCompte.isPresent()) {
            Double ancienSolde = optionalCompte.get().getSolde();
            double newSolde = ancienSolde - montant;
            optionalCompte.get().setSolde(newSolde);
            CompteBancaire compteDebit = optionalCompte.get();
            return compteBancaireRepository.save(compteDebit);
        }

        else {
            throw new EntityNotFoundException("Compte bancaire introuvable avec l'ID " + compte.getId());
        }
    }

    @Override
    public CompteBancaire crediterCompte(CompteBancaire compte, double montant) {
        Optional<CompteBancaire> optionalCompte = compteBancaireRepository.findById(compte.getId());
        if (optionalCompte.isPresent()) {
            Double ancienSolde = optionalCompte.get().getSolde();
            double newSolde = ancienSolde + montant;
            optionalCompte.get().setSolde(newSolde);
            CompteBancaire compteDebit = optionalCompte.get();
            return compteBancaireRepository.save(compteDebit);
        }

        else {
            throw new EntityNotFoundException("Compte bancaire introuvable avec l'ID " + compte.getId());
        }
    }

    @Override
    public CompteBancaire save(CompteBancaire compteBancaire) {
        compteBancaireRepository.save(compteBancaire);
        return compteBancaire;
    }

    @Override
    public void delete(CompteBancaire compteBancaire) {
        compteBancaireRepository.delete(compteBancaire);
    }
}

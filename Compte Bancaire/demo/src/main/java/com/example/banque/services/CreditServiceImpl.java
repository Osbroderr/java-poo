package com.example.banque.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.banque.entities.CompteBancaire;
import com.example.banque.entities.Credit;
import com.example.banque.repositories.CompteBancaireRepository;
import com.example.banque.repositories.CreditRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CreditServiceImpl implements CreditService {

    @Autowired
    private CompteBancaireRepository compteBancaireRepository;

    @Autowired
    private CreditRepository creditRepository;

    @Override
    public Credit findById(Long id) {
        return creditRepository.findById(id).orElse(null);
    }

    @Override
    public List<Credit> findAll() {
        return creditRepository.findAll();
    }

    @Override
    public Optional<Credit> findByCompteId(Long id) {
        return creditRepository.findById(id);
    }

    @Override
    public Credit save(Credit credit) {
        creditRepository.save(credit);
        return credit;
    }

    @Override
    public void accorderCredit(CompteBancaire compteBancaire, double montant) {
        Optional<CompteBancaire> optionalCompte = compteBancaireRepository.findById(compteBancaire.getId());
        if (optionalCompte.isPresent()) {
            CompteBancaire compte = optionalCompte.get();
            Double nouveauSolde = compte.getSolde() + montant;
            compte.setSolde(nouveauSolde);
            compteBancaireRepository.save(compte);

            Credit credit = new Credit();
            credit.setCompteBancaire(compte);
            creditRepository.save(credit);
        } else {
            throw new EntityNotFoundException("Compte bancaire introuvable avec l'ID " + compteBancaire.getId());
        }
    }

    @Override
    public void delete(Credit credit) {
        creditRepository.delete(credit);
    }
}

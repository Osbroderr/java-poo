package com.example.banque.services;

import java.util.List;
import java.util.Optional;

import com.example.banque.entities.CompteBancaire;
import com.example.banque.entities.Credit;

public interface CreditService {
    Optional<Credit> findById(Long id);

    List<Credit> findAll();

    Optional<Credit> findByCompteId(Long id);

    void accorderCredit(CompteBancaire compteBancaire, double montant);

    Credit save(Credit credit);

    void delete(Long id);
}

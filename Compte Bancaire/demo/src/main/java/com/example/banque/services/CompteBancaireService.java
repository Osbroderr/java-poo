package com.example.banque.services;

import java.util.List;
import java.util.Optional;

import com.example.banque.entities.CompteBancaire;

public interface CompteBancaireService {
    CompteBancaire findById(Long id);

    List<CompteBancaire> findAll();

    Optional<CompteBancaire> findByClientId(Long id);

    CompteBancaire save(CompteBancaire compteBancaire);

    void delete(CompteBancaire compteBancaire);
}

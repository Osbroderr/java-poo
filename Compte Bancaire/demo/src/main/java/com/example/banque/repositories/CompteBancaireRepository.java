package com.example.banque.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.banque.entities.CompteBancaire;

public interface CompteBancaireRepository extends JpaRepository<CompteBancaire, Long> {

}

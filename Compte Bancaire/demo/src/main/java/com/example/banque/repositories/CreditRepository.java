package com.example.banque.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.banque.entities.Credit;

public interface CreditRepository extends JpaRepository<Credit, Long> {

}

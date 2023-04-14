package com.example.banque.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.banque.entities.Client;
import com.example.banque.entities.CompteBancaire;
import com.example.banque.entities.Credit;

import jakarta.annotation.PostConstruct;

@Service
public class InitData {

    @Autowired
    private ClientService clientService;

    @Autowired
    private CompteBancaireService compteBancaireService;

    @Autowired
    private CreditService creditService;

    @PostConstruct
    public void init() {
        // Création de clients
        Client client1 = new Client("Jean", "Dupont", "0123456789");
        clientService.save(client1);

        Client client2 = new Client("Marie", "Martin", "0987654321");
        clientService.save(client2);

        // Création de comptes bancaires
        CompteBancaire compte1 = new CompteBancaire("FR1234567890", client1);
        compteBancaireService.save(compte1);

        CompteBancaire compte2 = new CompteBancaire("FR0987654321", client2);
        compteBancaireService.save(compte2);

        // Création de crédits
        Credit credit1 = new Credit((double) 1000, 5, 0.20, compte1);
        creditService.save(credit1);

        Credit credit2 = new Credit((double) 500000, 15, 0.10, compte2);
        creditService.save(credit2);
    }
}

package com.example.banque.services;

import java.util.List;

import com.example.banque.entities.Client;

public interface ClientService {
    Client findById(Long id);

    List<Client> findAll();

    Client save(Client client);

    void delete(Client client);
}

package com.bootcamp.dio.projectpatterns.service;

import com.bootcamp.dio.projectpatterns.entities.Client;

public interface ClientService {

    Iterable<Client> findAll();

    Client findById(Long id);

    void saveClient(Client client);

    void updateClient(Long id, Client client);

    void deleteById(Long id);

}

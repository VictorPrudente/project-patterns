package com.bootcamp.dio.projectpatterns.service.impl;


import com.bootcamp.dio.projectpatterns.entities.Address;
import com.bootcamp.dio.projectpatterns.entities.Client;
import com.bootcamp.dio.projectpatterns.repository.AddressRepository;
import com.bootcamp.dio.projectpatterns.repository.ClientRepository;
import com.bootcamp.dio.projectpatterns.service.ClientService;
import com.bootcamp.dio.projectpatterns.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private ViaCepService viaCepService;


    private void saveClientWithCep(Client client) {
        String cep = client.getAddress().getCep();
        Address address = addressRepository.findById(cep).orElseGet(() -> {
            Address newAddress = viaCepService.findCep(cep);
            addressRepository.save(newAddress);
            return newAddress;
        });
        client.setAddress(address);
        clientRepository.save(client);
    }

    @Override
    public Iterable<Client> findAll() {
        return clientRepository.findAll();
    }

    @Override
    public Client findById(Long id) {
        Optional<Client> client = clientRepository.findById(id);
        return client.get();
    }

    @Override
    public void saveClient(Client client) {
        saveClientWithCep(client);
    }

    @Override
    public void updateClient(Long id, Client client) {
        Optional<Client> clientToUpdate = clientRepository.findById(id);
        if (clientToUpdate.isPresent()) {
            saveClientWithCep(client);
        }
    }

    @Override
    public void deleteById(Long id) {
        clientRepository.deleteById(id);
    }
}

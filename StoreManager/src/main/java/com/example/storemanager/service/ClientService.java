package com.example.storemanager.service;

import com.example.storemanager.entities.Client;
import com.example.storemanager.entities.Product;
import com.example.storemanager.repository.ClientRepository;
import com.example.storemanager.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;

    public void addClient(Client client){
        clientRepository.save(client);
    }

    public List<Client> findClients(){
        return clientRepository.findAll();
    }

    public Optional<Client> findClientByName(String name){
        return clientRepository.findClientByName(name);
    }

    public Optional<Client> findClientById(int id){
        return clientRepository.findClientById(id);
    }

    public void updateUsernameById(String username, int id) throws NoSuchElementException {
        var client = findClientById(id);

        if (client.isPresent()) {
            clientRepository.updateUsernameById(username, id);
        } else {
            throw new NoSuchElementException();
        }
    }

    public void deleteClientById(int id) throws NoSuchElementException {
        var client = findClientById(id);

        if (client.isPresent()) {
            clientRepository.deleteClientById(id);
        } else {
            throw new NoSuchElementException();
        }
    }
}

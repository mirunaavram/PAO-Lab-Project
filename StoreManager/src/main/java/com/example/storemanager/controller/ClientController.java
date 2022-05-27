package com.example.storemanager.controller;

import com.example.storemanager.entities.Client;
import com.example.storemanager.entities.Product;
import com.example.storemanager.service.ClientService;
import com.example.storemanager.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class ClientController {


    private final ClientService clientService;

    @PostMapping("/client")
    public void addClient(@RequestBody Client client){
        clientService.addClient(client);
    }

    @GetMapping("/clients")
    public List<Client> findClients(){

        return clientService.findClients();
    }

    @GetMapping("/client/{name}")
    public ResponseEntity<Client> findClientByName(@PathVariable String name){

        var p = clientService.findClientByName(name);

        if(p.isPresent()){
            return ResponseEntity.of(p);
        }
        else{
            return ResponseEntity.noContent().build();
        }
    }

    @PutMapping("/client/{id}")
    public ResponseEntity<Void> updateClientById(@RequestParam String username, @PathVariable("id") int id) {
        try {
            clientService.updateUsernameById(username, id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/client/{id}")
    public ResponseEntity<Void> deleteClientById(@PathVariable("id") int id) {
        try {
            clientService.deleteClientById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}

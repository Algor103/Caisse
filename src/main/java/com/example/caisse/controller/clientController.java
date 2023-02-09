package com.example.caisse.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.caisse.exception.ResourceNotFoundException;
import com.example.caisse.model.Client;
import com.example.caisse.repository.ClientRepository;
@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class clientController {
    

    @Autowired
    ClientRepository clientRepository;

    @GetMapping("/clients")
    public List<com.example.caisse.model.Client> getAllClients() {
        System.out.println("Get all clients...");

        List<com.example.caisse.model.Client> clients = new ArrayList<>();
        clientRepository.findAll().forEach(clients::add);
        return clients;
    }

    @GetMapping("/clients/{id}")
    public ResponseEntity<com.example.caisse.model.Client> getClientById(@PathVariable(value = "id") Long ClientId) throws ResourceNotFoundException{
        com.example.caisse.model.Client client = clientRepository.findById(ClientId)
           .orElseThrow(() -> new ResourceNotFoundException("Client introuvable pour cette id :: " + ClientId));
        return ResponseEntity.ok().body(client);
    }

    @PostMapping("/clients")
    public com.example.caisse.model.Client createClient(@Valid @RequestBody com.example.caisse.model.Client client) {
        return clientRepository.save(client);
    }

    @PutMapping("/clients/{id}")
    public ResponseEntity<Client> updateClient(@PathVariable("id") long id, @RequestBody Client client) {
        System.out.println("Update Client with ID = " + id + "...");
        Optional<Client> clientInfo = clientRepository.findById(id);

        if (clientInfo.isPresent()) {
            Client client1 = clientInfo.get();
            client1.setCode(client.getCode());
            client1.setLibelle(client.getLibelle());
            client1.setAdresse(client.getAdresse());
            client1.setContact(client.getContact());
            client1.setEmail(client.getEmail());
            client1.setLogin(client.getLogin());
            client1.setPwd(client.getPwd());
            client1.setMatfisc(client.getMatfisc());
            client1.setTimbre(client.getTimbre());

            return new ResponseEntity<>(clientRepository.save(client1), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}

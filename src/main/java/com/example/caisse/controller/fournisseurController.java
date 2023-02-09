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
import com.example.caisse.model.Fournisseur;
import com.example.caisse.repository.FournisseurRepository;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class fournisseurController {
    

    @Autowired
    FournisseurRepository fournisseurRepository;

    @GetMapping("/fournisseurs")
    public List<Fournisseur> getAllFournisseurs() {
        System.out.println("Get all fournisseurs...");

        List<Fournisseur> fournisseurs = new ArrayList<>();
        fournisseurRepository.findAll().forEach(fournisseurs::add);
        return fournisseurs;
    }

    @GetMapping("/fournisseurs/{id}")
    public ResponseEntity<Fournisseur> getFournisseurById(@PathVariable(value = "id") Long Fournisseur) throws ResourceNotFoundException{
        Fournisseur fournisseur = fournisseurRepository.findById(Fournisseur)
           .orElseThrow(() -> new ResourceNotFoundException("Fournisseur introuvable pour cette id :: " + Fournisseur));
        return ResponseEntity.ok().body(fournisseur);
    }

    @PostMapping("/fournisseurs")
    public Fournisseur createFournisseur(@Valid @RequestBody Fournisseur fournisseur) {
        return fournisseurRepository.save(fournisseur);
    }

    @DeleteMapping("/fournisseurs/{id}")
    public Map<String, Boolean> deleteFournisseur(@PathVariable(value = "id") Long Fournisseur) throws ResourceNotFoundException {
        Fournisseur fournisseur = fournisseurRepository.findById(Fournisseur)
           .orElseThrow(() -> new ResourceNotFoundException("Fournisseur introuvable pour cette id :: " + Fournisseur));

        fournisseurRepository.delete(fournisseur);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    @DeleteMapping("/fournisseurs/delete")
    public ResponseEntity<String> deleteAllFournisseurs() {
        System.out.println("Delete All fournisseurs...");
        fournisseurRepository.deleteAll();
        return new ResponseEntity<>("Tous les fournisseurs ont été supprimés!", HttpStatus.OK);
    }

    @PutMapping("/fournisseurs/{id}")
    public ResponseEntity<Fournisseur> updateFournisseur(@PathVariable("id") long id, @RequestBody Fournisseur fournisseur) {
        System.out.println("Update fournisseur with ID = " + id + "...");
        Optional<Fournisseur> fournisseurInfo = fournisseurRepository.findById(id);

        if (fournisseurInfo.isPresent()) {
            Fournisseur fournisseur1 = fournisseurInfo.get();
            fournisseur1.setCode(fournisseur.getCode());
            fournisseur1.setLibelle(fournisseur.getLibelle());
            fournisseur1.setAdresse(fournisseur.getAdresse());
            fournisseur1.setContact(fournisseur.getContact());
            fournisseur1.setEmail(fournisseur.getEmail());
            fournisseur1.setLogin(fournisseur.getLogin());
            fournisseur1.setMatfisc(fournisseur.getMatfisc());
            fournisseur1.setPwd(fournisseur.getPwd());

            return new ResponseEntity<>(fournisseurRepository.save(fournisseur1), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}

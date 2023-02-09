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
import com.example.caisse.model.Soucategorie;
import com.example.caisse.repository.SouCategorieRepository;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class souCategorieController {
    

    @Autowired
    SouCategorieRepository souCategorieRepository;

    @GetMapping("/soucategories")
    public List<com.example.caisse.model.Soucategorie> getAllSouCategories() {
        System.out.println("Get all soucategories...");

        List<com.example.caisse.model.Soucategorie> soucategories = new ArrayList<>();
        souCategorieRepository.findAll().forEach(soucategories::add);
        return soucategories;
    }

    @GetMapping("/soucategories/{id}")
    public ResponseEntity<com.example.caisse.model.Soucategorie> getSouCategorieById(@PathVariable(value = "id") Long souCategorieId) throws ResourceNotFoundException{
        com.example.caisse.model.Soucategorie soucategorie = souCategorieRepository.findById(souCategorieId)
           .orElseThrow(() -> new ResourceNotFoundException("Soucategorie introuvable pour cette id :: " + souCategorieId));
        return ResponseEntity.ok().body(soucategorie);
    }

    @PostMapping("/soucategories")
    public com.example.caisse.model.Soucategorie createSouCategorie(@Valid @RequestBody com.example.caisse.model.Soucategorie soucategorie) {
        return souCategorieRepository.save(soucategorie);
    }

    @DeleteMapping("/soucategories/{id}")
    public Map<String, Boolean> deleteSouCategorie(@PathVariable(value = "id") Long souCategorieId) throws ResourceNotFoundException {
        com.example.caisse.model.Soucategorie soucategorie = souCategorieRepository.findById(souCategorieId)
           .orElseThrow(() -> new ResourceNotFoundException("Soucategorie introuvable pour cette id :: " + souCategorieId));

        souCategorieRepository.delete(soucategorie);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    @DeleteMapping("/soucategories/delete")
    public ResponseEntity<String> deleteAllSouCategories() {
        System.out.println("Delete All soucategories...");
        souCategorieRepository.deleteAll();
        return new ResponseEntity<>("Toutes les soucategories ont été supprimées!", HttpStatus.OK);
    }

    @PutMapping("/soucategories/{id}")
    public ResponseEntity<Soucategorie> updateSouscategorie(@PathVariable(value = "id") Long id, @RequestBody Soucategorie soucategorie) {
        System.out.println("Update soucategorie with ID = " + id + "...");
        Optional<Soucategorie> soucategorieInfo = souCategorieRepository.findById(id);

        if (soucategorieInfo.isPresent()) {
            Soucategorie soucategorie1 = soucategorieInfo.get();
            soucategorie1.setCode(soucategorie.getCode());
            soucategorie1.setLibelle(soucategorie.getLibelle());
            soucategorie1.setId_categorie(soucategorie.getId_categorie());

            return new ResponseEntity<>(souCategorieRepository.save(soucategorie1), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    } 


}

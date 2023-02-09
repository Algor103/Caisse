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
import com.example.caisse.model.Categorie;
import com.example.caisse.repository.CategorieRepository;
@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class categorieController {
    
    @Autowired
    CategorieRepository categorieRepository;

    @GetMapping("/categories")
    public List<Categorie> getAllCategories() {
        System.out.println("Get all categories...");

        List<Categorie> categories = new ArrayList<>();
        categorieRepository.findAll().forEach(categories::add);
        return categories;
    }

    @GetMapping("/categories/{id}")
    public ResponseEntity<Categorie> getCategorieById(@PathVariable(value = "id") Long CategorieId) throws ResourceNotFoundException{
        Categorie categorie = categorieRepository.findById(CategorieId)
           .orElseThrow(() -> new ResourceNotFoundException("Categorie introuvable pour cette id :: " + CategorieId));
        return ResponseEntity.ok().body(categorie);
    }

    @PostMapping("/categories")
    public Categorie createCategorie(@Valid @RequestBody Categorie categorie) {
        return categorieRepository.save(categorie);
    }

    @DeleteMapping("/categories/{id}")
    public Map<String, Boolean> deleteCategorie(@PathVariable(value = "id")Long categorieId) throws ResourceNotFoundException{
        Categorie categorie = categorieRepository.findById(categorieId)
           .orElseThrow(() -> new ResourceNotFoundException("Categorie introuvable pour cette id :: " + categorieId));

        categorieRepository.delete(categorie);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    @DeleteMapping("/categories/delete")
    public ResponseEntity<String> deleteAllCategories() {
        System.out.println("Delete All Categories...");
        categorieRepository.deleteAll();
        return new ResponseEntity<>("Toutes les categories ont été supprimées!", HttpStatus.OK);
    }

    @PutMapping("/categories/{id}")
    public ResponseEntity<Categorie> updateCategorie(@PathVariable("id") long id, @RequestBody Categorie categorie) {
        System.out.println("Update Categorie with ID = " + id + "...");
        Optional<Categorie> categorieInfo = categorieRepository.findById(id);

        if (categorieInfo.isPresent()) {
            Categorie categorie1 = categorieInfo.get();
            categorie1.setCode(categorie.getCode());
            categorie1.setLibelle(categorie.getLibelle());

            return new ResponseEntity<>(categorieRepository.save(categorie1), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}

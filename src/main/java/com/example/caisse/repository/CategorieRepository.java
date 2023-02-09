package com.example.caisse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.caisse.model.Categorie;

@Repository
public interface CategorieRepository extends JpaRepository<Categorie, Long> {
    
        
    }


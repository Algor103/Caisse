package com.example.caisse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.caisse.model.Fournisseur;
import org.springframework.stereotype.Repository;

@Repository
public interface FournisseurRepository extends JpaRepository<Fournisseur, Long> {
    
        
    }
    

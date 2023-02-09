package com.example.caisse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.caisse.model.Soucategorie;
import org.springframework.stereotype.Repository;

@Repository
public interface SouCategorieRepository extends JpaRepository<Soucategorie, Long> {
    
        
}


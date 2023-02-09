package com.example.caisse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.caisse.model.Client;


@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    
        
    }


package com.example.caisse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.caisse.model.Article;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
    
}

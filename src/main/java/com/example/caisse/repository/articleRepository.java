package com.example.caisse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import com.example.caisse.model.Article;

public class articleRepository {
    public interface ArticleRepository extends JpaRepository<Article, Long> {
    
        
    }
    
}

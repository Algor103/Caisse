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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.caisse.exception.ResourceNotFoundException;
import com.example.caisse.model.Article;
import com.example.caisse.repository.ArticleRepository;



@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class articleController {
    
    @Autowired
    ArticleRepository articleRepository;

    // on recupere les articles
    @GetMapping("/articles")
    public List<Article> getAllArticles() {
        System.out.println("Get all Articles...");
        // et on les range dans une liste
        List<Article> articles = new ArrayList<>();
        articleRepository.findAll().forEach(articles::add);
        return articles;
    }

    // on recherche son article par son "id"
    @GetMapping("/articles/{id}")
    public ResponseEntity<Article> getArticleById(@PathVariable(value = "id") Long ArticleId) throws ResourceNotFoundException{
         Article article = articleRepository.findById(ArticleId)
                .orElseThrow(() -> new ResourceNotFoundException("Article not found for this id :: " + ArticleId));
        return ResponseEntity.ok().body(article);
    }

    @PostMapping("/articles")
    public Article createArticle(@Valid @RequestBody Article article) {
        return articleRepository.save(article);
    }

    @DeleteMapping("/articles/{id}")
    public Map<String, Boolean> deleteArticle(@PathVariable(value = "id") Long articleId) throws ResourceNotFoundException {
        Article article = articleRepository.findById(articleId)
                .orElseThrow(() -> new ResourceNotFoundException("Article not found for this id :: " + articleId));

        articleRepository.delete(article);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
           
    } 

    @DeleteMapping("/articles/delete")
    public ResponseEntity<String> deleteAllArticles() {
        System.out.println("Delete All Articles...");
        articleRepository.deleteAll();
        return new ResponseEntity<>("All Articles have been deleted!", HttpStatus.OK);
    }

    @PutMapping("/articles/{id}")
    public ResponseEntity<Article> updateArticle(@PathVariable("id") long id, @RequestBody Article article) {
        System.out.println("Update Article with ID = " + id + "...");
        Optional<Article> articleInfo = articleRepository.findById(id);

        if (articleInfo.isPresent()) {
            Article Article = articleInfo.get();
            Article.setCode(Article.getCode());
            Article.setDc(Article.getDc());
            Article.setfodec(Article.getFodec());
            Article.setLibelle(Article.getLibelle());
            Article.setId_categorie(Article.getId_categorie());
            Article.setId_scategorie(Article.getId_scategorie());
            Article.setPv(Article.getPv());
            Article.setPa(Article.getPa());
            Article.setTva(Article.getTva());

            return new ResponseEntity<>(articleRepository.save(Article), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

    
    

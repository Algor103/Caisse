package com.example.caisse.model;

import jakarta.persistence.Table;

@jakarta.persistence.Entity
@Table(name="categorie")
public class Categorie {
    @jakarta.persistence.Id
      @jakarta.persistence.GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)

    private long id;
    private String code;
    private String libelle;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    } 
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getLibelle() {
        return libelle;
    }
    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Categorie(long id, String code, String libelle) {
        super();
        this.id = id;
        this.code = code;
        this.libelle = libelle;
    }
    public Categorie() {
        super();
    }

    @Override
    public String toString() {
        return "Categorie [id = "+ id + ", code = " + code + ", libelle = " + libelle +"]";
    }
}

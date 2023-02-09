package com.example.caisse.model;

import jakarta.persistence.Table;

@jakarta.persistence.Entity
@Table(name="soucategorie")
public class Soucategorie {
    @jakarta.persistence.Id
      @jakarta.persistence.GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)

    private long id;
    private String code;
    private String code_categ;
    private String libelle;
    private long id_categorie;

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
    public String getCode_categ() {
        return code_categ;
    }
    public void setCode_categ(String code_categ) {
        this.code_categ = code_categ;
    }
    public String getLibelle() {
        return libelle;
    }
    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
    public long getId_categorie() {
        return id_categorie;
    }
    public void setId_categorie(long id_categorie) {
        this.id_categorie = id_categorie;
    }

    public Soucategorie(long id, String code, String code_categ, String libelle, long id_categorie) {
        super();
        this.id = id;
        this.code = code;
        this.code_categ = code_categ;
        this.libelle = libelle;
        this.id_categorie = id_categorie;
    }
    public Soucategorie() {
        super();
    }

    @Override
    public String toString() {
        return "Soucategorie [id = "+ id + ", code = " + code + ", code_categ = " + code_categ + ", libelle = " + libelle + ", id_categorie = " + id_categorie +"]";
    }
    
}

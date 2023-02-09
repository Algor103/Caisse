package com.example.caisse.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="article")
public class Article {
    @jakarta.persistence.Id
      @jakarta.persistence.GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)

    private long id;
    private String code;
    private String libelle;
    private int pa;
    private int tva;
    private int fodec;
    private int pv;
    private int stockinit;
    private int stock;
    private String image;
    private long id_scategorie;
    private long id_categorie;
    private int dc;

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
    public int getPa() {
        return pa;
    }
    public void setPa(int pa) {
        this.pa = pa;
    }
    public int getTva() {
        return tva;
    }
    public void setTva(int tva) {
        this.tva = tva;
    }
    public int getFodec() {
        return fodec;
    }
    public void setfodec(int fodec) {
        this.fodec = fodec;
    }
    public int getPv() {
        return pv;
    }
    public void setPv(int pv) {
        this.pv = pv;
    }
    public int getStockinit() {
        return stockinit;
    }
    public void setStockinit(int stockinit) {
        this.stockinit = stockinit;
    }
    public int getStock() {
        return stock;
    }
    public void setStock(int stock) {
        this.stock = stock;
    }
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
    public long getId_scategorie() {
        return id_scategorie;
    }
    public void setId_scategorie(long id_scategorie) {
        this.id_scategorie = id_scategorie;
    }
    public long getId_categorie() {
        return id_categorie;
    }
    public void setId_categorie(long id_categorie) {
        this.id_categorie = id_categorie;
    }
    public int getDc() {
        return dc;
    }
    public void setDc(int dc) {
        this.dc = dc;
    }

    public Article(long id, String code, String libelle, int pa, int tva, int fodec, int pv, int stockinit, int stock, String image, long id_scategorie, long id_categorie, int dc) {
        super();
        this.id = id;
        this.code = code;
        this.libelle = libelle;
        this.pa = pa;
        this.tva = tva;
        this.fodec = fodec;
        this.pv = pv;
        this.stockinit = stockinit;
        this.stock = stock;
        this.image = image;
        this.id_scategorie = id_scategorie;
        this.id_categorie = id_categorie;
        this.dc = dc;
    }
    public Article() {
        super();
    }
    @Override
    public String toString(){
        return "Article [id = "+ id + ", code = " + code + ", libelle = " + libelle + ", pa = " + pa + ", tva = " + tva + ", fodec = " + fodec + ", pv = " + pv + ", stockinit = " + stockinit + ", stock = " + stock + ", image = " + image + ", id_scategorie = " + id_scategorie + ", id_categorie = " + id_categorie +", dc = " + dc + "]";
    }
}

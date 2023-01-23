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

    public Article(long id, String code, String libelle, int pa, int tva, int fodec, int pv, int stockinit, int stock) {
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
    }
    public Article() {
        super();
    }
    @Override
    public String toString(){
        return "Article [id = "+ id + ", code = " + code + ", libelle = " + libelle + ", pa = " + pa + ", tva = " + tva + ", fodec = " + fodec + ", pv = " + pv + ", stockinit = " + stockinit + ", stock = " + stock +"]";
    }
}

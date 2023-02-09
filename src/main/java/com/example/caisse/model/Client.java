package com.example.caisse.model;

import jakarta.persistence.Table;

@jakarta.persistence.Entity
@Table(name="client")
public class Client {
    @jakarta.persistence.Id
      @jakarta.persistence.GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)

    private long id;
    private String code;
    private String adresse;
    private String libelle;
    private String tel;
    private String email;
    private String contact;
    private String timbre;
    private String asuj;
    private String matfisc;
    private String login;
    private String pwd;
    private int solde_init;
    private int solde;

    // mutateurs et accesseurs
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
    public String getAdresse() {
        return adresse;
    }
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
    public String getLibelle() {
        return libelle;
    }
    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
    public String getTel() {
        return tel;
    }
    public void setTel(String tel) {
        this.tel = tel;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getContact() {
        return contact;
    }
    public void setContact(String contact) {
        this.contact = contact;
    }
    public String getTimbre() {
        return timbre;
    }
    public void setTimbre(String timbre) {
        this.timbre = timbre;
    }
    public String getAsuj() {
        return asuj;
    }
    public void setAsuj(String asuj) {
        this.asuj = asuj;
    }
    public String getMatfisc() {
        return matfisc;
    }
    public void setMatfisc(String matfisc) {
        this.matfisc = matfisc;
    }
    public String getLogin() {
      return login;
    }
    public void setLogin(String login) {
      this.login = login;
    }
    public String getPwd() {
      return pwd;
    }
    public void setPwd(String pwd) {
      this.pwd = pwd;
    }
    public int getSolde_init() {
      return solde_init;
    }
    public void setSolde_init(int solde_init) {
      this.solde_init = solde_init;
    }
    public int getSolde() {
      return solde;
    }
    public void setSolde(int solde) {
      this.solde = solde;
    }

    // constructeur
    public Client(long id, String code, String adresse, String libelle, String tel, String email, String contact, String timbre, String asuj, String matfisc, String login, String pwd, int solde_init, int solde ) {

      super();
      this.id = id;
      this.code = code;
      this.adresse = adresse;
      this.libelle = libelle;
      this.tel = tel;
      this.email = email;
      this.contact = contact;
      this.timbre = timbre;
      this.asuj = asuj;
      this.matfisc = matfisc;
      this.login = login;
      this.pwd = pwd;
      this.solde = solde;
      this.solde_init = solde;
    }

    public Client() {
      super();
    }

    @Override
    public String toString() {
       return "Client [id=" + id + ", code=" + code + ", libelle=" + libelle + ", adresse=" 
               + adresse + ", tel=" + tel + ", email=" + email + ", matfisc=" + matfisc 
               + ", timbre=" + timbre + ", solde_init=" + solde_init + ", solde=" + solde +"]";
    }

}

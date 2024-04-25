package com.example.test;

public class Billett {
    private String antall;
    private String film;
    private String fornavn;
    private String etternavn;
    private String telefon;
    private String epost;

    public Billett(String antall, String film, String fornavn, String etternavn, String telefon, String epost){
        this.antall = antall;
        this.film = film;
        this.fornavn = fornavn;
        this.etternavn = etternavn;
        this.telefon = telefon;
        this.epost = epost;
    }

    public String getAntall(){
        return antall;
    }
    public void setAntall(String antall){
        this.antall = antall;
    }

    public String getFilm(){
        return film;
    }
    public void setFilm(String film){
        this.film = film;
    }

    public String getFornavn(){
        return fornavn;
    }
    public void setFornavn(String fornavn){
        this.fornavn = fornavn;
    }

    public String getEtternavn(){
        return etternavn;
    }
    public void setEtternavn(String etternavn){
        this.etternavn = etternavn;
    }

    public String getTelefon(){
        return telefon;
    }
    public void setTelefon(String telefon){
        this.telefon = telefon;
    }

    public String getEpost(){
        return epost;
    }
    public void setEpost(String epost){
        this.epost = epost;
    }




}

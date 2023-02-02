package com.example.listaprzepisow3pgr1;

public class Przepis {
    private String nazwa;
    private int kategoria;
    private String tresc;
    private int idObrazka;

    public Przepis(String nazwa, int kategoria, String tresc, int idObrazka) {
        this.nazwa = nazwa;
        this.kategoria = kategoria;
        this.tresc = tresc;
        this.idObrazka = idObrazka;
    }

    public Przepis(String nazwa, int kategoria, String tresc) {
        this.nazwa = nazwa;
        this.kategoria = kategoria;
        this.tresc = tresc;
    }

    @Override
    public String toString() {
        return nazwa;
    }

    public String getNazwa() {
        return nazwa;
    }

    public int getKategoria() {
        return kategoria;
    }

    public String getTresc() {
        return tresc;
    }

    public int getIdObrazka() {
        return idObrazka;
    }
}

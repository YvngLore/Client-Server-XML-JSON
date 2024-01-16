package com.server;

public class Classe {
    private int anno;
    private String sezione;
    private String specializzazione;
    private String zona;

    public Classe(int a, String sez, String spec, String z){
        anno = a;
        sezione = sez;
        specializzazione = spec;
        zona = z;
    }

    public String toString(){
        return "Anno: " + anno + "\nSezione: " + sezione + "\nSpecializzazione: " + specializzazione + "\nZona: " + zona;
    }
}

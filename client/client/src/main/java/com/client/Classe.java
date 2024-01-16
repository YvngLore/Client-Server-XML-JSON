package com.client;

public class Classe {
    private int anno;
    private String sezione;
    private String specializzazione;
    private String zona;

    public Classe(){}

    public Classe(int a, String sez, String spec, String z){
        anno = a;
        sezione = sez;
        specializzazione = spec;
        zona = z;
    }

    public void setAnno(int a){
        anno = a;
    }

    public void setSezione(String sez){
        sezione = sez;
    }

    public void setSpecializzazione(String spec){
        specializzazione = spec;
    }

    public void setZona(String z){
        zona = z;
    }

    public int getAnno(){
        return anno;
    }

    public String getSezione(){
        return sezione;
    }

    public String getSpecializzazione(){
        return specializzazione;
    }

    public String getZona(){
        return zona;
    }
    
    public String toString(){
        return "Anno: " + anno + "\nSezione: " + sezione + "\nSpecializzazione: " + specializzazione + "\nZona: " + zona;
    }
}


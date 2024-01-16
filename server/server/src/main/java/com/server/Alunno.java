package com.server;

import java.util.ArrayList;


public class Alunno {
    private String nome;
    private String cognome;
    private String codiceFiscale;
    private int eta; 
    private ArrayList <Double> voti;

    public Alunno(){}

    public Alunno(String n, String c, String cf, int e){
        nome = n;
        cognome = c;
        codiceFiscale = cf;
        eta = e;
        voti = new ArrayList();
    }
    
    public void aggiungiVoto(double voto){
        voti.add(voto);
    }

    public double getMediaVoti(){
        double media = 0;
        
        for(int i = 0; i < voti.size(); i++)
            media += voti.get(i);

        if(media == 0)
            return 0;

        media = media / voti.size();
        return media;
    }
    public String toString(){
        String s = "Nome alunno: " + nome + "\nCognome alunno: " + cognome + "\nCodice Fiscale: " + codiceFiscale + "\nEta' alunno: " + eta + "\nVoti: \n\t";
        for(int i = 0; i < voti.size(); i++){
            s += "Voto " + (i+1) + ": " + voti.get(i).toString() + "\n\t";
        }
        s += "----> MEDIA VOTI: " + getMediaVoti();
        return s;
    }
}

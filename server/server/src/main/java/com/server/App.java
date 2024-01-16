package com.server;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        try {
            ServerSocket server = new ServerSocket(3000);
            System.out.println("Server inizializzato");

            Alunno a1 = new Alunno("Rayan", "Moh'd", "ccff1", 3);
            Alunno a2 = new Alunno("Lorenzo", "Socci", "ccff2", 18);
            Alunno a3 = new Alunno("Niccolo'", "Masi", "ccff3", 19);
            Alunno a4 = new Alunno("Samuele", "Taiti", "ccff4", 18);
            Alunno a5 = new Alunno("Swaran", "Singh", "ccff5", 37483);

            Classe c1 = new Classe(5, "D","Informatica", "Secondo Piano Zona Ovest");
            Classe c2 = new Classe(4, "B","Meccanica", "Primo Piano Zona Est");
            Classe c3 = new Classe(2, "C","Automazione", "Piano Terra Zona Centrale");
            Classe c4 = new Classe(5, "A","Informatica", "Secondo Piano Zona Est");

            a1.aggiungiVoto(3);
            a2.aggiungiVoto(5);
            a1.aggiungiVoto(7);
            a2.aggiungiVoto(10);
            a3.aggiungiVoto(7);
            a3.aggiungiVoto(8);
            a4.aggiungiVoto(4.5);
            a4.aggiungiVoto(6.5);

            Socket socket = server.accept();
            System.out.println("Un client si è connesso!");

            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            XmlMapper xmlMapper = new XmlMapper();

            //Conversioni nelle Stringhe XML
            String alunno1 = xmlMapper.writeValueAsString(a1);
            String alunno2 = xmlMapper.writeValueAsString(a2);
            String alunno3 = xmlMapper.writeValueAsString(a3);
            String alunno4 = xmlMapper.writeValueAsString(a4);
            String alunno5 = xmlMapper.writeValueAsString(a5);
            String classe1 = xmlMapper.writeValueAsString(c1);
            String classe2 = xmlMapper.writeValueAsString(c1);
            String classe3 = xmlMapper.writeValueAsString(c1);
            String classe4 = xmlMapper.writeValueAsString(c1);

            System.out.println("ESEMPIO --- \n");
            System.out.println(alunno1);

            output.writeBytes("A" + alunno1 + "\n");
            output.writeBytes("A" + alunno2 + "\n");
            output.writeBytes("A" + alunno3 + "\n");
            output.writeBytes("A" + alunno4 + "\n");
            output.writeBytes("A" + alunno5 + "\n");
            output.writeBytes("C" + classe1 + "\n");
            output.writeBytes("C" + classe2 + "\n");
            output.writeBytes("C" + classe3 + "\n");
            output.writeBytes("C" + classe4 + "\n");
            output.writeBytes("E");

            System.out.println("Informazioni inviate con SUCCESSO!");
            
            server.close();
            socket.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Errore durante l'istanzia del server!");
        }
    }
}

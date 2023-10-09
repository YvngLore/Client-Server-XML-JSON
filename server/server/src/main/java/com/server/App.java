package com.server;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
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

            Socket socket = server.accept();
            System.out.println("Un client si è connesso!");

            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            String ricevuta = input.readLine();
            System.out.println("Stringa ricevuta dal client: " + ricevuta);
            output.writeBytes(ricevuta.toUpperCase() + "\n");

            server.close();
            socket.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Errore durante l'istanzia del server!");
        }
    }
}

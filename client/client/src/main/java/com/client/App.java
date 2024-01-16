package com.client;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
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
            Socket socket = new Socket("localhost", 3000);
            System.out.println("Socket inizializzato");

            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            String ricevuta;

            while(!(ricevuta = input.readLine()).equals("E")){
                System.out.println(ricevuta);
            }
            
            socket.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("ERRORE GENERICO");
        }
    }
}

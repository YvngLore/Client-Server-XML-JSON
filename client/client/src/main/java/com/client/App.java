package com.client;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
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
            Socket socket = new Socket("localhost", 3000);
            System.out.println("Socket inizializzato");

            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            XmlMapper xmlMapper = new XmlMapper();
            String ricevuta;

            while(!(ricevuta = input.readLine()).equals("E")){
                boolean inizio = ricevuta.startsWith("A");
                ricevuta = ricevuta.substring(1);
                if(inizio){
                    Alunno a = xmlMapper.readValue(ricevuta, Alunno.class);
                }else{
                    Classe c = xmlMapper.readValue(ricevuta, Classe.class);
                }
                System.out.println(ricevuta);
            }

            //NEL CASO SI VOLESSE USARE IL JSON BASTA SOSTITUIRE L'XMLMAPPER CON OBJECTMAPPER
            //Per salvare la configurazione in un file XML o JSON: xmlMapper/objectMapper.writeValue(new File("test.xml"), oggettoDaSalvare);
            socket.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("ERRORE GENERICO");
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alumne
 */
public class Socket20 {

    

    /**
     * @param args the command line arguments
     */
    public static synchronized void main(String[] args) throws IOException {
        int i = 0;
       

            Scanner s = new Scanner(System.in);
            String hostname = "localhost";
            int portDst = 6000;

            System.out.println("Inici del programa client...");

            Socket cl = new Socket(hostname, portDst);
            hilo h=new hilo(cl);
            h.start();
          while (true) {
            ObjectOutputStream fluxSortida = new ObjectOutputStream(cl.getOutputStream());
            String a=s.nextLine();
            Chats javi = new Chats(a);

            fluxSortida.writeObject(javi);
          }

            /*Alumno a ;
		//Creacio del flux d'entrada del client
		InputStream entrada = null;
		try {
			entrada = cl.getInputStream();
			ObjectInputStream fluxEntrada = new ObjectInputStream(entrada);
                  
			a= (Alumno) fluxEntrada.readObject();
			System.out.println("Llegint dades del servidor: \n" +a.getNombre()+"\n"+a.getMedia());
			entrada.close();	//Tancament dels fluxos d'entrada
			fluxEntrada.close();
		}
		catch (IOException e) {
			System.out.println("ERROR: No es pot llegir el flux de dades del servidor\n");
		} catch (ClassNotFoundException ex) {
            Logger.getLogger(Socket20.class.getName()).log(Level.SEVERE, null, ex);
        }*/
            //Tancament de fluxos i dels sockets
            //fluxSortida.close();
            //cl.close();
            //cl.close();
            
        

    }

   

}

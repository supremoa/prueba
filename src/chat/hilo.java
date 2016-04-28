/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alumne
 */
 class hilo extends Thread {

        Chats a;
      Socket cl;
        public hilo(Socket cl){
            this.cl=cl;
        }
        
        public void run() {
            while (true) {
                InputStream entrada = null;
                try {
                    entrada = cl.getInputStream();
                    ObjectInputStream fluxEntrada = new ObjectInputStream(entrada);

                    a = (Chats) fluxEntrada.readObject();
                    System.out.println(Calendar.getInstance().getTime()+" " + a.getTexto());

                } catch (IOException e) {
                    System.out.println("ERROR: No es pot llegir el flux de dades del servidor\n");
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Socket20.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

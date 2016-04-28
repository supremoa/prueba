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
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alumne
 */
public class Hilo extends Thread {

    Socket clCon;
    InputStream conect;
    Hilo h;

    public Hilo(Socket clCon) {
        this.clCon = clCon;
    }

    public void setH(Hilo h) {
        this.h = h;
    }

    @Override
    public void run() {
        while (true) {
            try {
                conect = clCon.getInputStream();
                ObjectInputStream fluxEntrada = new ObjectInputStream(conect);
                Chats a = (Chats) fluxEntrada.readObject();
                for (Hilo k : Chat.hilo) {
                    if (k != h) {
                        k.enviar(a);
                    }
                }
            } catch (IOException ex) {
                Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    public void enviar(Chats a) {
        try {
            OutputStream sortida = null;
            sortida = clCon.getOutputStream();
            ObjectOutputStream fluxSortida = new ObjectOutputStream(sortida);
            fluxSortida.writeObject(a);
        } catch (IOException ex) {
            Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}

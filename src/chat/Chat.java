/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alumne
 */
public class Chat {

    static List<Hilo> hilo = new ArrayList<>();

    public static void main(String[] arg) throws IOException {

        int numPort = 6000;
        ServerSocket srv = new ServerSocket(numPort);
        while (true) {
            Socket clCon = null;
            System.out.println("Esperant clients...");

            clCon = srv.accept();

            Hilo hilo1 = new Hilo(clCon);
            hilo1.setH(hilo1);
            hilo1.start();
            hilo.add(hilo1);
        }
    }
}

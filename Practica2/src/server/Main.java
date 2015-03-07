/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.net.MalformedURLException;
import java.rmi.RemoteException;

/**
 *
 * @author pol
 */
public class Main {

    private static Peer peer;

    public static void main(String[] args) throws MalformedURLException, RemoteException {
        peer = new Peer();
        generarAleatorios(); // empiezo a generar aleatorios
    }

    public static void generarAleatorios() {
        try {
            while (true) {
                Thread.sleep(500); // 0,5seg -> 2Hz
                Thread enviarThread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        peer.enviarNumeros((float) Math.random());
                    }
                });

                enviarThread.start();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

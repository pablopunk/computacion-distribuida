/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

/**
 *
 * @author pol
 */
public class Main {

    private static Peer peer;

    public static void main(String[] args) {
        peer = new Peer();
        peer.escuchar(); // empiezo a escuchar a los clientes
        peer.suscribirse("localhost", 10);
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

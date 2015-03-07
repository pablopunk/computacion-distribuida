/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.rmi.*;
import javax.swing.JTextArea;
import server.ServerInterface;

/**
 *
 * @author pol
 */
public final class Peer {

    private final static int RMIPort = 1821;
    public final static int dataPort = 1822;
    private final static String hostname = "127.0.0.1";
    private static ServerInterface serverInterface;

    Peer() {
        conectarServer();
    }
   

    public void pedirSuscripcion(int segundos) throws RemoteException {
        serverInterface.suscribirse(segundos);
    }

    public void cancelarSuscripcion() throws RemoteException {
        serverInterface.cancelarSuscripcion();
    }

    public void conectarServer() {
        try {
            String registryURL = "rmi://" + hostname + ":" + RMIPort + "/server";
            // find the remote object and cast it to an interface object
            serverInterface = (ServerInterface) Naming.lookup(registryURL);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.rmi.*;
import server.ServerInterface;

/**
 *
 * @author pol
 */
public class Peer {
    
    private final static int RMIPort = 1821;
    private final static String hostname = "127.0.0.1";
    private static ServerInterface serverInterface;

    Peer() {
        conectarServer();
    }

    public void pedirSuscripcion(String host, int segundos) throws RemoteException {
        serverInterface.suscribirse(host, segundos);
    }

    public void cancelarSuscripcion(String host) throws RemoteException {
        serverInterface.cancelarSuscripcion(host);
    }
    
    public static void conectarServer() {
        try {
            String registryURL = "rmi://" + hostname + ":" + RMIPort + "/server";
            // find the remote object and cast it to an interface object
            serverInterface = (ServerInterface) Naming.lookup(registryURL);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}

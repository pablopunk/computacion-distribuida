/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.time.*;

/**
 *
 * @author pol
 */
public class Peer {

    private final static int RMIPort = 1821;
    private final static String hostname = "127.0.0.1";

    private HashMap<String, Suscriptor> suscriptores;

    Peer() throws MalformedURLException, RemoteException {
        this.suscriptores = new HashMap<>();
        iniciarServer();
    }

    void suscribirse(String host, int segundos) {
        Suscriptor sub = new Suscriptor(segundos);
        suscriptores.put(host, sub); // si ya existe se remplaza por el nuevo valor
    }

    void cancelarSuscripcion(String host) {
        if (suscriptores.containsKey(host)) {
            suscriptores.remove(host); // lo borro de la lista
        }
    }

    public void enviarNumeros(float aleatorio) {
        Iterator it = suscriptores.entrySet().iterator();
        while (it.hasNext()) {
            Instant ahora = Instant.now(); // Ahora

            Map.Entry actual = (Map.Entry) it.next(); // suscriptor
            String host = (String) actual.getKey();
            Suscriptor sub = (Suscriptor) actual.getValue();

            if (ahora.isBefore(sub.getFechaFin())) { // Si todavia esta suscrito
                System.out.println("Enviar " + aleatorio + " a " + host);
            } else { // si se ha agotado el tiempo de suscripcion
                System.out.println("Agotado el tiempo para " + host);
                suscriptores.remove(host); // lo elimino si caducó la suscripcion
            }
        }
    }

    public void iniciarServer() throws MalformedURLException, RemoteException {
        String registryURL = "rmi://localhost:" + RMIPort + "/server";

        try {
            startRegistry(RMIPort);
            ServerImplementation exportedObj = new ServerImplementation(this);
            Naming.rebind(registryURL, exportedObj);
            /**/ System.out.println /**/("Server registered.  Registry currently contains:");
            /**/     // list names currently in the registry
/**/ listRegistry(registryURL);
            System.out.println("Hello Server ready.");
        }// end try
        catch (Exception re) {
            System.out.println("Exception in HelloServer.main: " + re);
        } // end catch

    }

    private void startRegistry(int RMIPortNum)
            throws RemoteException {
        try {
            Registry registry = LocateRegistry.getRegistry(RMIPortNum);
            registry.list();  // This call will throw an exception
            // if the registry does not already exist
        } catch (RemoteException e) {

            // No valid registry at that port.
/**/ System.out.println /**/("RMI registry cannot be located at port "
                            /**/ + RMIPortNum);
            Registry registry
                    = LocateRegistry.createRegistry(RMIPortNum);
            /**/ System.out.println(
                    /**/"RMI registry created at port " + RMIPortNum);
        }
    } // end startRegistry

    // This method lists the names registered with a Registry object
    private void listRegistry(String registryURL)
            throws RemoteException, MalformedURLException {
        System.out.println("Registry " + registryURL + " contains: ");
        String[] names = Naming.list(registryURL);
        for (int i = 0; i < names.length; i++) {
            System.out.println(names[i]);
        }
    } //end listRegistry
}

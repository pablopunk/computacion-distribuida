package server;

import java.rmi.*;
import java.rmi.server.*;
import static java.rmi.server.RemoteServer.getClientHost;

public class ServerImplementation extends UnicastRemoteObject
        implements ServerInterface {

    Peer peer;

    public ServerImplementation(Peer peer) throws RemoteException {
        super();
        this.peer = peer;
    }

    @Override
    public void suscribirse(int segundos, int puerto) throws RemoteException {
        try {
            peer.suscribirse(getClientHost()+":"+puerto, segundos, puerto);
        } catch (ServerNotActiveException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void cancelarSuscripcion(int puerto) throws RemoteException {
        try {
            peer.cancelarSuscripcion(getClientHost()+":"+puerto);
        } catch (ServerNotActiveException ex) {
            System.out.println(ex);
        }
    }
} // end class

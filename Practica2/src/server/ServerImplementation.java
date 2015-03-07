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
    public void suscribirse(int segundos) throws RemoteException {
        try {
            peer.suscribirse(getClientHost(), segundos);
        } catch (ServerNotActiveException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void cancelarSuscripcion() throws RemoteException {
        try {
            peer.cancelarSuscripcion(getClientHost());
        } catch (ServerNotActiveException ex) {
            System.out.println(ex);
        }
    }
} // end class

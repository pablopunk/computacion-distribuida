
package server;

import java.rmi.*;
import java.rmi.server.*;

public class ServerImplementation extends UnicastRemoteObject
     implements ServerInterface {
    
    Peer peer;
  
   public ServerImplementation(Peer peer) throws RemoteException {
      super( );
      this.peer = peer;
   }
 
    @Override
    public void suscribirse(String host, int segundos) throws RemoteException {
        peer.suscribirse(host, segundos);
    }

    @Override
    public void cancelarSuscripcion(String host) throws RemoteException {
        peer.cancelarSuscripcion(host);
    }
} // end class

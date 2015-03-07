
package server;

import java.rmi.*;

public interface ServerInterface extends Remote {
    
   public void suscribirse(String host, int segundos) 
      throws java.rmi.RemoteException;
   
   public void cancelarSuscripcion(String host) 
      throws java.rmi.RemoteException;

} //end interface

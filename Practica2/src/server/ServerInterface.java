
package server;

import java.rmi.*;

public interface ServerInterface extends Remote {
    
   public void suscribirse(int segundos, int puerto) 
      throws java.rmi.RemoteException;
   
   public void cancelarSuscripcion(int puerto) 
      throws java.rmi.RemoteException;

} //end interface

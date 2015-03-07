
package server;

import java.rmi.*;

public interface ServerInterface extends Remote {
    
   public void suscribirse(int segundos) 
      throws java.rmi.RemoteException;
   
   public void cancelarSuscripcion() 
      throws java.rmi.RemoteException;

} //end interface

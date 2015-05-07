import jade.core.*;
import java.util.HashMap;
import jade.domain.*;
import jade.domain.FIPAAgentManagement.*;
import jade.lang.acl.*;
import jade.core.behaviours.*;

public class SellerAgent extends Agent {
    private String book;		// libro que vende
  	private int startPrice;		// precio de salida
  	private int currentPrice;	// precio actual de la subasta

  	protected void setup() {

      // Argumentos
      Object[] args = getArguments();
      if (args != null && args.length > 0) {
        book = (String) args[0];    // libro que vende
        startPrice = (int) args[1]; // precio de salida

        // Descripcion del vendedor
        DFAgentDescription dfd = new DFAgentDescription();
        dfd.setName(getAID());
        ServiceDescription sd = new ServiceDescription();
        sd.setType("book-selling");
        sd.setName("JADE-book-trading");
        dfd.addServices(sd);
        try {
          DFService.register(this, dfd);
        }
        catch (FIPAException fe) {
          fe.printStackTrace();
        }
        // Atender peticiones de los agentes compradores
        addBehaviour(new OfferRequestsServer());
        // Atender peticiones de compra de los agentes compradores
        addBehaviour(new PurchaseOrdersServer());
      }

      else {
        // Terminar
        System.out.println("Sin argumentos");
      }
    }

    protected void takeDown() {
      try {
  	 		DFService.deregister(this); // dar de baja
  	 	} catch (FIPAException e) {
  	 		e.printStackTrace();
  	 	}
    }

    private class OfferRequestsServer extends CyclicBehaviour {
      public void action() {

      }
    }  

    private class PurchaseOrdersServer extends CyclicBehaviour {
      public void action() {

      }
    }
  }

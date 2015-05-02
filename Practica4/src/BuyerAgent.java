import jade.core.*;
import java.util.HashMap;
import jade.domain.*;
import jade.domain.FIPAAgentManagement.*;

public class BuyerAgent extends Agent {
    private HashMap<String,Integer> books; 	// libros que quiere comprar y lo maximo que pagará
    private int maxPrice;		// precio maximo a pagar
    private AID sellerAID;	// vendedor

    protected void setup() {

    	System.out.println("Hi! Buyer-agent "+getAID().getName()+" is ready.");

        // Argumentos
    	Object[] args = getArguments();
    	if (args != null && args.length > 0) {
    		this.books = new HashMap<>();

    		for (int i = 0; i < args.length; i+=2) {
    			String title = (String) args[i];
    			int maxPrice = (int) args[i+1];

    			this.books.put(title, new Integer(maxPrice));
    			System.out.println("Quiero el libro "+title);
    		}

    		
			// Update the list of seller agents
    		DFAgentDescription template = new DFAgentDescription();
    		ServiceDescription sd = new ServiceDescription();
    		sd.setType("book-selling");
    		template.addServices(sd);

    		try {
    			DFAgentDescription[] result = DFService.search(this, template); 
    			System.out.println("Found the following seller agents:");
    			sellerAID = new AID();
    			sellerAID = result[0].getName();

    		} catch (FIPAException fe) {
    			fe.printStackTrace();
    		}

    	}
    	else {
			// Terminar
    		System.out.println("Sin argumentos");
    		doDelete();
    	}
    }
}

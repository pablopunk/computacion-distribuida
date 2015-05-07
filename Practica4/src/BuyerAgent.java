import jade.core.*;
import java.util.HashMap;
import jade.domain.*;
import jade.domain.FIPAAgentManagement.*;
import jade.lang.acl.*;
import jade.core.behaviours.*;

public class BuyerAgent extends Agent {
    private String book;    // libro que quiere
    private int maxPrice;	// precio maximo a pagar
    private AID sellerAID;	// vendedor

    protected void setup() {

    	System.out.println("Hola! El comprador "+getAID().getName()+" esta listo.");

        // Argumentos
    	Object[] args = getArguments();
    	if (args != null && args.length > 0) {
    		book = (String) args[0];
    		maxPrice = (int) args[1];

			addBehaviour(new TickerBehaviour(this, 60000) {
                protected void onTick() {
                    // Update the list of seller agents
                    DFAgentDescription template = new DFAgentDescription();
                    ServiceDescription sd = new ServiceDescription();
                    sd.setType("book-selling");
                    template.addServices(sd);
                    try {
                        DFAgentDescription[] result = DFService.search(myAgent, template); 
                        sellerAID = result[0].getName();
                    }
                    catch (FIPAException fe) {
                        fe.printStackTrace();
                    }

                    // Perform the request
                    myAgent.addBehaviour(new RequestPerformer());
                }
            } );

    	}
    	else {
			// Terminar
    		System.out.println("Sin argumentos");
    		doDelete();
    	}
    }

    protected void takeDown() { // operaciones de limpieza
        System.out.println("Agente comprador "+getAID().getName()+" terminando.");
    }

    // Clase con los metodos de la comunicación con el vendedor
    private class RequestPerformer extends Behaviour {
        private MessageTemplate mt;
        private int step = 0;
        private int price = 0;

        public void action() {
            switch (step) {
                case 0: // Contactar con el vendedor

                ACLMessage cfp = new ACLMessage(ACLMessage.CFP);
                cfp.addReceiver(sellerAID);
                cfp.setContent(book);
                cfp.setConversationId("book-trade");
                cfp.setReplyWith("cfp"+System.currentTimeMillis()); // Unique value
                myAgent.send(cfp);
                mt = MessageTemplate.and(MessageTemplate.MatchConversationId("book-trade"), MessageTemplate.MatchInReplyTo(cfp.getReplyWith()));
                step = 1;

                break;

                case 1: // Recibir la respuesta del vendedor

                ACLMessage resp = myAgent.receive(mt);
                if (resp != null) {
                    if (resp.getPerformative() == ACLMessage.PROPOSE) {
                        // Sube el precio
                        int nextPrice = Integer.parseInt(resp.getContent());
                        price = nextPrice;
                    } else if (resp.getPerformative() == ACLMessage.INFORM) {
                        step = 3; // comprado!
                        break;
                    }

                    if (price <= maxPrice) {
                        step = 2; // acepto la subasta
                    } else {
                        step = 4; // rechazo la subasta
                    }
                } else {
                    block(); // resp null
                }

                break;

                case 2: // Aceptar la subasta

                ACLMessage msg = new ACLMessage(ACLMessage.ACCEPT_PROPOSAL);
                msg.addReceiver(sellerAID);
                msg.setContent(book);
                msg.setConversationId("book-trade");
                msg.setReplyWith("accept"+System.currentTimeMillis()); // unico
                myAgent.send(msg);

                mt = MessageTemplate.and(MessageTemplate.MatchConversationId("book-trade"), MessageTemplate.MatchInReplyTo(msg.getReplyWith()));
                step = 1; // volver a recibir la respuesta

                break;

                case 3: // libro comprado

                System.out.println(getAID().getName()+ " ha comprado '"+book+"' por "+ price + "€");
                myAgent.doDelete();

                break;

                case 4: // libro no comprado

                System.out.println(getAID().getName()+ " se va de la subasta" );
                myAgent.doDelete();

                break;

            }        
        }

        public boolean done() {
            return (step == 3 || step == 4); // salir si acabo
        }

    }
}

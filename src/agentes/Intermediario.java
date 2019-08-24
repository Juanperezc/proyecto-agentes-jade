package agentes;

import controladores.ControladorInicio;
import java.util.ArrayList;
import java.util.Date;

import jade.core.*;
import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.lang.acl.ACLMessage;
import jade.proto.AchieveREInitiator;
import jade.domain.FIPANames;

@SuppressWarnings("serial")
public class Intermediario extends Agent {

    @Override
    protected void setup() {
    System.out.println(this.getLocalName() + " Iniciado");
        ControladorInicio controladorInicio = new ControladorInicio(this);
        //this.guardarComportamiento("Asistente_Eleazar", "Marico");
    }

    @Override
    protected void takeDown() {
        System.out.println(this.getLocalName() + " finalizado");
    }

    public ArrayList<String> buscarPersonas() {
        ArrayList<String> personas = new ArrayList<String>();

        DFAgentDescription dfd = new DFAgentDescription();
        ServiceDescription sd = new ServiceDescription();
        sd.setType("persona");
        dfd.addServices(sd);
        try {
            DFAgentDescription[] result = DFService.search(this, dfd);
            for(int i = 0; i < result.length; i++) {
                personas.add(result[i].getName().getLocalName());
            }
        } catch(FIPAException fe) {
            fe.printStackTrace();
        }

        return personas;
    }

     public void guardarComportamiento(String papel){
           // this.getLocalName();
            String usuario = "Asistente_"  + this.getLocalName();
            System.out.println("Usuario: "  + usuario);
            System.out.println("new AID: " + new AID(usuario, false).toString());
            ACLMessage msg = new ACLMessage(ACLMessage.REQUEST);
            msg.addReceiver(new AID(usuario, AID.ISLOCALNAME));
            msg.setProtocol(FIPANames.InteractionProtocol.FIPA_REQUEST);
            msg.setReplyByDate(new Date(System.currentTimeMillis() + 10000));
            msg.setContent("maricoelquelolea");
            System.out.println("Intermediario: "  + this.toString());
            System.out.println("msg: "  + msg.toString());
            //!esto es cuando se comunica un agente con otro
            // Agregar comportamiento AchieveREInitiator (Asignar papel a persona)
            addBehaviour(new AchieveREInitiator(this, msg) {
                @Override
                protected void handleInform(ACLMessage inform) {
                    System.out.println(inform.getSender().getLocalName() + "guardo el comportamiento correctamente");
                }

                @Override
                protected void handleRefuse(ACLMessage refuse) {
                    System.out.println(refuse.getSender().getLocalName() + ": " + refuse.getContent());
                }

                @Override
                protected void handleFailure(ACLMessage failure) {
                    if (failure.getSender().equals(myAgent.getAMS())) {
                        // Mensaje de la plataforma JADE: El destinatario no existe
                        System.out.println("La persona no existe");
                    } else {
                        System.out.println(failure.getSender().getLocalName() + ": " + failure.getContent());
                    }
                }
            });
        
        
        }
}

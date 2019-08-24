/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agentes;
import jade.core.*;
import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.domain.FIPANames;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.FailureException;
import jade.domain.FIPAAgentManagement.NotUnderstoodException;
import jade.domain.FIPAAgentManagement.RefuseException;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import jade.proto.AchieveREInitiator;
import jade.proto.AchieveREResponder;
import jade.proto.ContractNetInitiator;
import jade.proto.ContractNetResponder;
import java.util.ArrayList;
import java.util.Date;
import modelos.Libro;
import modelos.Preferencia;

/**
 *
 * @author juan
 */
public class Asistente extends Agent {
    
        private ArrayList<Preferencia> preferencias_usuario;
        protected void setup() {
            
        this.preferencias_usuario = new ArrayList<Preferencia>();
        // Registrar agente como "persona"
        DFAgentDescription dfd = new DFAgentDescription();
        dfd.setName(this.getAID());
         System.out.println("Aid! Agente " + this.getAID().toString());
        ServiceDescription sd = new ServiceDescription();
        //asignar tipo
        sd.setType("asistente");
        //asignar nombre
        sd.setName(this.getLocalName());
        dfd.addServices(sd);
        try {
            DFService.register(this, dfd);
        } catch (FIPAException e) {
            e.printStackTrace();
        }
         System.out.println("Hola! Agente "+getAID().getName()+" esta listo.");
        
       //! Template comportamiento setear en protocolo FIPA_CONTRACT_NET  
       MessageTemplate template = MessageTemplate.and(
                MessageTemplate.MatchProtocol(FIPANames.InteractionProtocol.FIPA_CONTRACT_NET),
                MessageTemplate.MatchPerformative(ACLMessage.CFP)
       );
         //agregar comportamiento guardar preferencia!!
       addBehaviour(new ContractNetResponder(this, template) {
            @Override
            protected ACLMessage handleCfp(ACLMessage cfp) throws NotUnderstoodException, RefuseException {
               /* if(papel.equals("Comprador")) {
                    throw new RefuseException("No soy vendedor");
                }*/
               /* ArrayList<Libro> libros = gui.getLibros();
                libro = new Libro(cfp.getContent());
                if (libros.contains(libro)) {
                    ACLMessage propose = cfp.createReply();
                    propose.setPerformative(ACLMessage.PROPOSE);
                    propose.setContent(String.valueOf(libros.get(libros.indexOf(libro)).getPrecio()));
                    return propose;
                } else {
                    System.out.println("Agent " + getLocalName() + ": Refuse");
                    throw new RefuseException("No tengo el libro");
                }*/
                 System.out.println("Comunicacion");
                 System.out.println(cfp.getContent());
                 ACLMessage propose = cfp.createReply();
                 propose.setPerformative(ACLMessage.PROPOSE);
                 propose.setContent("Ya la guarde");
                 return propose;
            }

            @Override
            protected ACLMessage handleAcceptProposal(ACLMessage cfp, ACLMessage propose, ACLMessage accept) throws FailureException {
                ACLMessage inform = accept.createReply();
                inform.setPerformative(ACLMessage.INFORM);
                return inform;
            }
        });
                
       
         // Agregar comportamiento AchieveREResponder (Para definir un papel asignado por el planificador)
        template = MessageTemplate.and(
                MessageTemplate.MatchProtocol(FIPANames.InteractionProtocol.FIPA_REQUEST),
                MessageTemplate.MatchPerformative(ACLMessage.REQUEST)
        );
        addBehaviour(new AchieveREResponder(this, template) {
            @Override
            protected ACLMessage prepareResponse(ACLMessage request) throws NotUnderstoodException, RefuseException {
              System.out.println("Comunicacion");
                ACLMessage agree = request.createReply();
                agree.setPerformative(ACLMessage.AGREE);
                return agree;
            }

            @Override
            protected ACLMessage prepareResultNotification(ACLMessage request, ACLMessage response) throws FailureException {
                     System.out.println("Comunicacion");
                    ACLMessage inform = request.createReply();
                    inform.setPerformative(ACLMessage.INFORM);
                    return inform;
              
            }
        });
        }
        
        // Put agent clean-up operations here
        @Override
        protected void takeDown() {
        // Printout a dismissal message
        System.out.println("Agente "+getAID().getName()+" termino.");
        }
        
        
        
        
}

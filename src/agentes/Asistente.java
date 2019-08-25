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
import jade.lang.acl.UnreadableException;
import jade.proto.AchieveREResponder;
import jade.proto.ContractNetResponder;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelos.Preferencia;

/**
 *
 * @author juan
 */
public class Asistente extends Agent {
    
        public ArrayList<Preferencia> preferencias_usuario;
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
     
        
                ACLMessage propose = cfp.createReply();
                try {
                    System.out.println("Devolviendo preferencias");
                    System.out.println(cfp.getContent());
                  
                    propose.setPerformative(ACLMessage.PROPOSE);
                    propose.setContentObject(preferencias_usuario);
                    return propose;
                } catch (IOException ex) {
                    System.out.println("Error preferencias");
                    Logger.getLogger(Asistente.class.getName()).log(Level.SEVERE, null, ex);
                     return propose;
                }
               
               
            }

            @Override
            protected ACLMessage handleAcceptProposal(ACLMessage cfp, ACLMessage propose, ACLMessage accept) throws FailureException {
                    System.out.println("Devolviendo preferencias");
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
             
                try {
                   //   System.out.println("Preferencia array" + preferencias_usuario.size());
                      Preferencia pref = (Preferencia) request.getContentObject();
                    //  System.out.println(pref);
                      System.out.println(pref.getTipo());
                      System.out.println(pref.getProducto());
                      System.out.println(pref.getCategoria());
                   
          
                      if (pref.getTipo() != 0){
                      preferencias_usuario.add(pref);
                      System.out.println("Preferencia size: " + preferencias_usuario.size());
                      //System.out.println(pref.getCategoria());
                      //System.out.println(request.getContentObject().toString());
                      }
                 
                      ACLMessage inform = request.createReply();
                      inform.setContentObject(preferencias_usuario);
                      inform.setPerformative(ACLMessage.INFORM);
                      //inform.setContent("Test");
                      return inform;
                } catch (UnreadableException | IOException ex) {
                    System.out.println("Fallo array");
                    Logger.getLogger(Asistente.class.getName()).log(Level.SEVERE, null, ex);
                    return null;
                }
           
             
            }

            @Override
            protected ACLMessage prepareResultNotification(ACLMessage request, ACLMessage response) throws FailureException {
                
                    /* System.out.println("Comunicacion");
                       try {
                           Preferencia pref = (Preferencia) request.getContentObject();
                           System.out.println(pref.getCategoria());
                    System.out.println(request.getContentObject().toString());
                } catch (UnreadableException ex) {
                    Logger.getLogger(Asistente.class.getName()).log(Level.SEVERE, null, ex);
                }*/
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

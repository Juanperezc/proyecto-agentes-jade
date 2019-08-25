package agentes;

import controladores.ControladorInicio;
import controladores.ControladorPrincipal;
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
import jade.lang.acl.UnreadableException;
import jade.proto.ContractNetInitiator;
import java.io.IOException;
import java.util.Iterator;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelos.Categoria;
import modelos.Preferencia;
import modelos.Producto;
import utilidades.CargarDatos;

@SuppressWarnings("serial")
public class Intermediario extends Agent {
 ControladorInicio controladorInicio;
 public ArrayList<Preferencia> preferencias_usuario_intermediario;
 public Intermediario that;
 
    @Override
    protected void setup() {
        that = this;
    System.out.println(this.getLocalName() + " Iniciado");
     
         try {
         this.requestPreferencias();
         
           } catch (IOException ex) {
         Logger.getLogger(Intermediario.class.getName()).log(Level.SEVERE, null, ex);
     }
         
        
    }
    @Override
    protected void takeDown() {
        this.controladorInicio.Salir();
    //    ControladorPrincipal controladorPrincipal = new ControladorPrincipal(false);
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

     public void guardarComportamiento(Preferencia pref) throws IOException{
           // this.getLocalName();
            String usuario = "Asistente_"  + this.getLocalName();
         //   System.out.println("Usuario: "  + usuario);
         //   System.out.println("new AID: " + new AID(usuario, false).toString());
            ACLMessage msg = new ACLMessage(ACLMessage.REQUEST);
            msg.addReceiver(new AID(usuario, AID.ISLOCALNAME));
            msg.setProtocol(FIPANames.InteractionProtocol.FIPA_REQUEST);
            msg.setReplyByDate(new Date(System.currentTimeMillis() + 10000));
            msg.setContentObject(pref);
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
     
     public void requestPreferencias() throws IOException{
           // this.getLocalName();
            String usuario = "Asistente_"  + this.getLocalName();
         //   System.out.println("Usuario: "  + usuario);
         //   System.out.println("new AID: " + new AID(usuario, false).toString());
            ACLMessage msg = new ACLMessage(ACLMessage.REQUEST);
            msg.addReceiver(new AID(usuario, AID.ISLOCALNAME));
            msg.setProtocol(FIPANames.InteractionProtocol.FIPA_REQUEST);
            msg.setReplyByDate(new Date(System.currentTimeMillis() + 10000));
            msg.setContentObject(new Preferencia(0,0,0));
         //   System.out.println("Intermediario: "  + this.toString());
         //   System.out.println("msg: "  + msg.toString());
            //!esto es cuando se comunica un agente con otro
            // Agregar comportamiento AchieveREInitiator (Asignar papel a persona)
            addBehaviour(new AchieveREInitiator(this, msg) {
                
                
                 protected void handlePropose(ACLMessage propose) {
                    try {
              
                    System.out.println("preferencias " + propose.getContentObject().toString());
                    } catch (UnreadableException ex) {
                    System.out.println("Test ");
                    Logger.getLogger(Intermediario.class.getName()).log(Level.SEVERE, null, ex);
                    }
                 }
                 
                @Override
                protected void handleInform(ACLMessage inform) {
                    System.out.println(inform.getSender().getLocalName() + " Recibiendo datos");
                    try {
                       
                       controladorInicio = new ControladorInicio(that,   produtosRecomendados( (ArrayList<Preferencia>) inform.getContentObject()));
                       System.out.println(((ArrayList<Preferencia>) inform.getContentObject()).toString());
                      
                       //preferencias_usuario_intermediario = (ArrayList<Preferencia>) inform.getContentObject();
                    } catch (UnreadableException | IOException ex) {
                        Logger.getLogger(Intermediario.class.getName()).log(Level.SEVERE, null, ex);
                    }
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
     public ArrayList<Producto> produtosRecomendados(ArrayList<Preferencia> pref){
          
        //tipo 1 busqueda de producto
        //tipo 2 click de producto
        //tipo 3 filtro categoria
         
          
          ArrayList<Producto> productos = new ArrayList<Producto>();
          if (pref.size() > 0){
          //mejor oferta
              System.err.println("productos x busqueda" +  this.productosxBusqueda(pref));
          if(this.menorDeProductos(this.productosxClick(pref)) != null){
                 productos.add(this.menorDeProductos(this.productosxClick(pref)));
                 System.err.println("menorClick");
          }
          if(this.menorDeProductos(this.productosxBusqueda(pref)) != null){
                 productos.add(this.menorDeProductos(this.productosxBusqueda(pref)));
                 System.err.println("menorBusqueda");

           }
          if(this.menorDeProductos(this.productosxCategoria(pref)) != null){
             productos.add(this.menorDeProductos(this.productosxCategoria(pref)));
                      System.err.println("menorxFiltroxCateogira");
              
          }
 
              System.err.println("productos: " + productos.toString());
          }
       

         
         return productos;
     }
     public Producto menorDeProductos(ArrayList<Producto> productos){
        Producto pro = null;
        double min = 999999999;
        for (int i = 0; i < productos.size(); i++) {
            if (productos.get(i).getPrecio() < min) {
                min = productos.get(i).getPrecio();
                pro = productos.get(i);
            }
        }
        return pro;
     }
     
     public ArrayList<Producto> productosxClick(ArrayList<Preferencia> pref){
          ArrayList<Producto> productos_todos = CargarDatos.CargarProductos();
          ArrayList<Producto> productos = new ArrayList<Producto>();
           for (Preferencia preferencia : pref) {
             if (preferencia.getTipo() == 1){
                 productos.add(CargarDatos.buscarProdxId(preferencia.getProducto(), productos_todos));
             }
         }
          
          return productos;
          
     }
      public ArrayList<Producto> productosxBusqueda(ArrayList<Preferencia> pref){
          ArrayList<Producto> productos_todos = CargarDatos.CargarProductos();
          ArrayList<Producto> productos = new ArrayList<Producto>();
           for (Preferencia preferencia : pref) {
             if (preferencia.getTipo() == 2){
                 productos.add(CargarDatos.buscarProdxId(preferencia.getProducto(), productos_todos));
             }
         }
          
          return productos;
          
     }
      
     public ArrayList<Producto> productosxCategoria(ArrayList<Preferencia> pref){
          ArrayList<Producto> productos_todos = CargarDatos.CargarProductos();
          ArrayList<Producto> productos = new ArrayList<Producto>();
           for (Preferencia preferencia : pref) {
             if (preferencia.getTipo() == 3){
                  for (Producto prod : CargarDatos.buscarProdxCat(productos_todos,preferencia.getCategoria())) {
                      productos.add(prod);
                  }
             }
         }
          
          return productos;
          
     } 
     public double porcentajeClickProductos(ArrayList<Preferencia> pref){
         double porc = 0;
         ArrayList<Producto> productos_todos = CargarDatos.CargarProductos();
         ArrayList<Integer> clicks  = new ArrayList<Integer>();
         for (Preferencia preferencia : pref) {
             if (preferencia.getTipo() == 1){
                 clicks.add(1);
             }
         }
         return clicks.size() * 100/pref.size();
        
     }
     
     public double porcentajeBusquedaProductos(ArrayList<Preferencia> pref){
     double porc = 0;
         ArrayList<Integer> busqueda  = new ArrayList<Integer>();
         for (Preferencia preferencia : pref) {
             if (preferencia.getTipo() == 2){
                 busqueda.add(1);
             }
         }
         return busqueda.size() * 100/pref.size();
     }
      
     public double filtroCategorias(ArrayList<Preferencia> pref){
         double porc = 0;
         ArrayList<Integer> filtro  = new ArrayList<Integer>();
         for (Preferencia preferencia : pref) {
             if (preferencia.getTipo() == 3){
                 filtro.add(1);
             }
         }
         return filtro.size() * 100/pref.size();
     }
}

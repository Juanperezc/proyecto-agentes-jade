/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;
import jade.core.Profile; 
import jade.core.ProfileImpl; 
import jade.wrapper.*;
import jade.core.Runtime; 
import javax.swing.UIManager;
import vistas.VPrincipal;

/**
 *
 * @author juan
 */
public class ControladorPrincipal {
    
    private VPrincipal formPrincipal;
     
     public ControladorPrincipal(){
         
           try {
            // Usar look & feel nativo en las vistas
            UIManager.setLookAndFeel(
            UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {}

        // Plataforma JADE
        Runtime runtime = Runtime.instance();

        // Perfil predetermiando (localhost:1099)
        Profile profile = new ProfileImpl();

        // Contenedor principal
        AgentContainer mainContainer = runtime.createMainContainer(profile);

        // Crear agentes
        try {
            // RMA (Jade Boot GUI)
            AgentController ac = mainContainer.createNewAgent("rma",
                    "jade.tools.rma.rma", null);
            ac.start();

            // Planificador
           /*  ac = mainContainer.createNewAgent("Asistente",
                    "agentes.Asistente", null);
            ac.start();*/

            // 4 Asistentes
         
            String[] personas = {"Eleazar", "Stefan", "German", "Bachaquero"};
            for(int i = 0; i < personas.length; i++) {
               ac = mainContainer.createNewAgent("Asistente_" + personas[i],
                        "agentes.Asistente", null);
                ac.start();
            }
             formPrincipal=new VPrincipal();
             formPrincipal.setVisible(true);
        } catch (StaleProxyException e) {
            e.printStackTrace();
        }
        
  
       
     /*  formPrincipal.getjMenuMovimientos().setEnabled(false);
       formPrincipal.getjMenuArchivos().setEnabled(false);
       
       formPrincipal.getjTextFieldUsuario().addKeyListener(this);*/
     }

}

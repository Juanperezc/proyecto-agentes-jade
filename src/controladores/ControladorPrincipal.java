/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;
import agentes.Intermediario;
import jade.core.Profile; 
import jade.core.ProfileImpl; 
import jade.wrapper.*;
import jade.core.Runtime; 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import vistas.VPrincipal;

/**
 *
 * @author juan
 */
public class ControladorPrincipal implements ActionListener,KeyListener {
    
    private VPrincipal formPrincipal;
      AgentContainer mainContainer;
       AgentController ac;
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
        this.mainContainer = runtime.createMainContainer(profile);

        // Crear agentes
        try {
            // RMA (Jade Boot GUI)
            this.ac = this.mainContainer.createNewAgent("rma",
                    "jade.tools.rma.rma", null);
            ac.start();

         
            // 4 Asistentes
         
            String[] personas = {"Eleazar", "Stefan", "German", "Bachaquero"};
            for(int i = 0; i < personas.length; i++) {
               ac = this.mainContainer.createNewAgent("Asistente_" + personas[i],
                        "agentes.Asistente", null);
                ac.start();
            }
             formPrincipal=new VPrincipal();
             formPrincipal.setVisible(true);
             formPrincipal.agregarListener(this);
           //  ControladorInicio controladorInicio = new ControladorInicio();
        } catch (StaleProxyException e) {
            e.printStackTrace();
        }
        
  
       
     /*  formPrincipal.getjMenuMovimientos().setEnabled(false);
       formPrincipal.getjMenuArchivos().setEnabled(false);
       
       formPrincipal.getjTextFieldUsuario().addKeyListener(this);*/
     }

 
    @Override
  public void actionPerformed(ActionEvent e) 
    {
       if (e.getSource().equals(formPrincipal.getjButtonIngresar())){
          // ControladorInicio controladorInicio = new ControladorInicio();
            try {
                
            formPrincipal.setVisible(false);
            this.ac = mainContainer.createNewAgent("Bachaquero",
                    "agentes.Intermediario", null);
            this.ac.start();

            }
            catch (StaleProxyException er) {
            er.printStackTrace();
            }
           
       }
            
       }
           

    

    @Override
    public void keyTyped(KeyEvent ke) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import vistas.VPrincipal;

/**
 *
 * @author juan
 */
public class ControladorPrincipal implements ActionListener,KeyListener {
    private String[] personas;
    private VPrincipal formPrincipal;
      AgentContainer mainContainer;
       AgentController ac;

    /**
     *
     * @param firstTime
     */
    public ControladorPrincipal(Boolean firstTime){
         
    /*       try {
            // Usar look & feel nativo en las vistas
            UIManager.setLookAndFeel(
            UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {}*/

           // Plataforma JADE
        Runtime runtime = Runtime.instance();

        // Perfil predetermiando (localhost:1099)
        Profile profile = new ProfileImpl();
  

        

        // Contenedor principal
        this.mainContainer = runtime.createMainContainer(profile);

        // Crear agentes
        try {
                    if (firstTime){
                     // RMA (Jade Boot GUI)
                     this.ac = this.mainContainer.createNewAgent("rma",
                             "jade.tools.rma.rma", null);
                     ac.start();


                     // 5 Asistentes 

                     String[] personas = {"Shely", "Moises", "Frank", "Reyes", "Hector"};
                     for(int i = 0; i < personas.length; i++) {
                        ac = this.mainContainer.createNewAgent("Asistente_" + personas[i],
                                 "agentes.Asistente", null);
                         ac.start();
                     }  
                        
                    }
   
          
           //  ControladorInicio controladorInicio = new ControladorInicio();
        } catch (StaleProxyException e) {
            e.printStackTrace();
        }
        
       
        
             formPrincipal=new VPrincipal();
             formPrincipal.setVisible(true);
             formPrincipal.agregarListener(this);
       
     /*  formPrincipal.getjMenuMovimientos().setEnabled(false);
       formPrincipal.getjMenuArchivos().setEnabled(false);
       
       formPrincipal.getjTextFieldUsuario().addKeyListener(this);*/
     }

 
    @Override
  public void actionPerformed(ActionEvent e) 
    {
      String[] personas = {"Shely", "Moises", "Frank", "Reyes","Hector"}; 
       if (e.getSource().equals(formPrincipal.getjButtonIngresar())){
          // ControladorInicio controladorInicio = new ControladorInicio();
            try {
           
            boolean logueado = false;
                
            for (int i = 0; i < 5; i++) {

            if (formPrincipal.getjTextFieldUsuario().getText().equals(personas[i]) && formPrincipal.getjPasswordField().getText().equals("test"))     
                logueado = true;
            }   
             
            if (logueado == true){
               //  formPrincipal.setVisible(false);
            //  this.formPrincipal.dispose();
            this.ac = mainContainer.createNewAgent(formPrincipal.getjTextFieldUsuario().getText(),
                    "agentes.Intermediario", null);
            this.ac.start(); 
            } else {
                JOptionPane.showMessageDialog(formPrincipal, "Error de datos", "ERROR", JOptionPane.ERROR_MESSAGE );
            }           
          
            
            
            
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import vistas.VPrincipal;
import modelos.Producto;
import vistas.VInicio;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Boolean.TRUE;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import jade.core.Profile; 
import jade.core.ProfileImpl; 
import jade.wrapper.*;
import jade.core.Runtime; 
import javax.swing.UIManager;

/**
 *
 * @author juan
 */
public class ControladorInicio {
    
    private VPrincipal formPrincipal;
    private VInicio vi;
     
     public ControladorInicio(){
         
       formPrincipal=new VPrincipal();
       formPrincipal.setVisible(true);
       
       
     }
     public void VInicio(){
    
    vi = new VInicio();
    vi.agregar_listeners(this);
    lm.setVisible(true);
    lm.setLocationRelativeTo(null);
    Especialidades();
    }
     public void actionPerformed(ActionEvent e) {

        if(((JButton)e.getSource()).getText().equals("Buscar")){
            
        }
     }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controladores;
import java.awt.event.ActionEvent;
import vistas.ModoPago;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JTextField;
/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class ControladorFormaPago implements ActionListener,KeyListener{
    private ModoPago mp;
  
    
     public ControladorFormaPago(){
          mp = new ModoPago();
          mp.setVisible(true);
          mp.agregar_listeners(this);
     
   }
    @Override
    public void actionPerformed(ActionEvent e) {
                             if (((JButton)e.getSource()).getText().equals("Salir")){
                                int opc = JOptionPane.showConfirmDialog(mp, "¿Seguro que desea Salir?", "Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (opc == 0)
                    mp.dispose();
    }
                             
                    if (e.getSource().equals(this.mp.brealizar)){
                    if(mp.txtnombre.getText().equals("") ||mp.txttarjeta.getText().equals("") || mp.txtcodigo.getText().equals("") ){
                            JOptionPane.showMessageDialog(mp, "Complete todos los campos para continuar.", "ERROR", JOptionPane.ERROR_MESSAGE );
                       }
                    else{
                    JOptionPane.showMessageDialog(mp, "¡Transacción Exitosa!.", "Finalizado", JOptionPane.INFORMATION_MESSAGE);
                     mp.dispose();
                    }
                              }
    }

    @Override
    public void keyTyped(KeyEvent e) {
                  if(((JTextField)e.getSource()).equals(mp.txtnombre)){
           char c = e.getKeyChar();
        if (Character.isDigit(c) == false) {
            
        }else{
            e.consume();
        }
    }
                  
          if(((JTextField)e.getSource()).equals(mp.txttarjeta)){
           char c = e.getKeyChar();
        if (Character.isLetter(c) == false) {
            
        }else{
            e.consume();
        }
    }
          
                    if(((JTextField)e.getSource()).equals(mp.txtcodigo)){
           char c = e.getKeyChar();
        if (Character.isLetter(c) == false) {
            
        }else{
            e.consume();
        }
    }
                    
               if(mp.txtnombre.getText().length()==40){
     e.consume();
     }            
                    
             if(mp.txttarjeta.getText().length()==25){
     e.consume();
     }  
            if(mp.txtcodigo.getText().length()==4){
     e.consume();
     }
          
    }

    @Override
    public void keyPressed(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}


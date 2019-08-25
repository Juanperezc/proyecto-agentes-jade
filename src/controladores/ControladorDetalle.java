/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import vistas.VDetalle;
import modelos.Producto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import vistas.VInicio;


/**
 *
 * @author Moises
 */
public class ControladorDetalle implements ActionListener,KeyListener {
  private VDetalle formDetalle;
  
  private VInicio vinicio;
  private Producto producto;
   public ControladorDetalle(Producto producto, VInicio vinicio){
       this.vinicio = vinicio;
       this.producto = producto;
       formDetalle=new VDetalle();
       formDetalle.setVisible(true);
       
       formDetalle.agregarListener(this);
       this.CargarDetalle();
       //formDetalle.lblUsuario.setText("Usuario: " + agente.getLocalName());
   }
   
   public void CargarDetalle(){
       this.formDetalle.lbltitulo.setText(producto.getTitulo());
       this.formDetalle.lbltitulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imágenes/" + producto.getImagen()))); // NOI18N
       this.formDetalle.lblPrecio.setText((String.valueOf(producto.getPrecio())));
       this.formDetalle.lblTotal.setText((String.valueOf(producto.getPrecio())));
       this.formDetalle.textAreaDetalle.setText(producto.getDescripcion());
       
    
               
   }
    @Override
    public void actionPerformed(ActionEvent ae) {
        
       if (ae.getSource().equals(this.formDetalle.comboCantidad)){
           double suma = 
                   Double.valueOf(this.formDetalle.comboCantidad.getSelectedItem().toString())* 
                   Double.valueOf(this.formDetalle.lblPrecio.getText().toString());
           this.formDetalle.lblTotal.setText(String.valueOf(suma));
       }
       if (ae.getSource().equals(this.formDetalle.getBtnAtras())){
           
              formDetalle.dispose();
        //      formDetalle.toFront();
              //vinicio.setVisible(true);
          
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

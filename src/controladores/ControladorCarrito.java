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
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import utilidades.CargarDatos;
import vistas.VCarrito;
import vistas.VInicio;


/**
 *
 * @author Moises
 */
public class ControladorCarrito implements ActionListener,KeyListener {
  private VCarrito vcarrito;
  ArrayList<Producto> productos_carrito;
  String username;

   public ControladorCarrito(String name, ArrayList<Producto> productos_carrito){
       this.username = name;
       this.vcarrito = vcarrito;
       this.vcarrito = new VCarrito();
       this.vcarrito.setVisible(true);
       this.productos_carrito = productos_carrito;
   //    this.producto = producto;
   //    formDetalle=new VDetalle();
   //    formDetalle.setVisible(true);
       
      // formDetalle.agregarListener(this);
      this.vcarrito.agregarListener(this);
      this.CargarCarrito();
       //formDetalle.lblUsuario.setText("Usuario: " + agente.getLocalName());
   }
   
   public void CargarCarrito(){
       this.vcarrito.txtfieldName.setText(this.username);
       
       
        this.vcarrito.txtFieldTotal.setText(String.valueOf(this.calcularTotalProductos()));
        
        
        DefaultTableModel model = (DefaultTableModel) this.vcarrito.tblCarrito.getModel();
        for (Producto producto : productos_carrito) {
            model.addRow(new Object[]{producto.getTitulo(),producto.getDescripcion(), CargarDatos.buscarCatxId(producto.getCategoria_id(),CargarDatos.CargarCategorias()).getNombre()     , producto.getPrecio()});
        }
       
       
        this.vcarrito.tblCarrito.setModel(model);
       /*this.formDetalle.lbltitulo.setText(producto.getTitulo());
       this.formDetalle.lbltitulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imágenes/" + producto.getImagen()))); // NOI18N
       this.formDetalle.lblPrecio.setText((String.valueOf(producto.getPrecio())));
       this.formDetalle.lblTotal.setText((String.valueOf(producto.getPrecio())));
       this.formDetalle.textAreaDetalle.setText(producto.getDescripcion());*/
    
   }
  
   public double calcularTotalProductos(){
       double total = 0;
       for (Producto producto : this.productos_carrito) {
           total += producto.getPrecio();
       }
       return total;
   }
    @Override
    public void actionPerformed(ActionEvent ae) {
        
       if (ae.getSource().equals(this.vcarrito.btnAtras)){
       this.vcarrito.dispose();
       }
       if (ae.getSource().equals(this.vcarrito.btnFinalizar)){
           if (productos_carrito.size() > 0){
                 ControladorFormaPago controladorFormaPago = new ControladorFormaPago();
           }else{
                 JOptionPane.showMessageDialog(this.vcarrito, "El carrito no tiene productos", "ERROR", JOptionPane.ERROR_MESSAGE );
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

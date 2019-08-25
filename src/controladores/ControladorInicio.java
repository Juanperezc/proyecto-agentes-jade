/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import agentes.Intermediario;
import jade.core.AID;
import jade.core.Agent;
import jade.domain.FIPANames;
import jade.lang.acl.ACLMessage;
import jade.proto.AchieveREInitiator;
import java.util.ArrayList;
import java.util.Date;
import modelos.Categoria;
import modelos.Producto;
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
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import modelos.Preferencia;
import utilidades.CargarDatos;

/**
 *
 * @author juan
 */
public final class ControladorInicio implements MouseListener,ActionListener,KeyListener,ListSelectionListener {
    
    private VInicio formInicio;
    private String username;
    DefaultListModel<String> model;
    //arreglo de productos
    private ArrayList<Producto> productos;
    
    //arreglo de categorias
    private ArrayList<Categoria> categorias;
    private ArrayList<Producto> productos_carrito;
    private agentes.Intermediario agente;
    
     public ControladorInicio(agentes.Intermediario intermediario, ArrayList<Producto> productos_carrito) throws IOException {
       this.productos_carrito =  productos_carrito;
       agente = intermediario;
    
       System.out.println("Controlador inicio");

       //cargamos productos y categorias
       this.categorias = new ArrayList<Categoria>();
       this.productos = new ArrayList<Producto>();
       // this.agente.guardarComportamiento(new Preferencia(1,1,1));
       formInicio=new VInicio();
       formInicio.setVisible(true);
       formInicio.agregarListener(this);
       formInicio.agregarSelectionListener(this);
       formInicio.lblUsuario.setText("Usuario: " + agente.getLocalName());
       formInicio.agregarMouseListener(this);
       this.cargarCategorias();
       this.cargarProductos();
       this.cargarListaProductos();
       this.cargarComboCategorias();
       

       if (productos_carrito.size() > 0){
            System.out.println("Carrito con productos" + productos_carrito.size());
           ControladorCarrito controladorCarrito = new ControladorCarrito(intermediario.getLocalName(), productos_carrito);

       }

     }
      public Integer buscarCatxNombre(String cat){
          
         Integer find = -1;
         
         for (Categoria cate : this.categorias) {
              if (cate.getNombre().equals(cat)){
                   find = cate.getId();
              }
              
          }            
         return find;
      
      }
      
      public Producto buscarProdxTitulo(String producto){
          
        Producto prod = null;
         
         for (Producto pro : this.productos) {
              if (pro.getTitulo().equals(producto)){
                  prod = pro;
              }
              
          }            
         return prod;
      
      }
     public void filtrarProdxCat(Integer cat) throws IOException{
         System.out.println("categoria" + cat.toString());
         DefaultListModel model = new DefaultListModel();
         ArrayList<Producto> prod_filtrados;
         prod_filtrados = new ArrayList<Producto>();
        
         this.productos.forEach((p) -> 
         {
             if (p.getCategoria_id() == cat || cat == 0)
                  model.addElement(p.toString());
         }); 
               
         formInicio.listProductos.setModel(model);

          System.out.println(model);
          
          this.agente.guardarComportamiento(new Preferencia(3,0,cat));
          //llamar al agente para que guarde
     }
     public void buscarProductos(String titulo){
         DefaultListModel model = new DefaultListModel();
         ArrayList<Producto> prod_filtrados;
         prod_filtrados = new ArrayList<Producto>();
         this.productos.forEach((p) -> 
         {
             if (p.getTitulo().equals(titulo)){
                 try {
                     model.addElement(p.toString());
                     this.agente.guardarComportamiento(new Preferencia(1,p.getId(),0));
                 } catch (IOException ex) {
                     Logger.getLogger(ControladorInicio.class.getName()).log(Level.SEVERE, null, ex);
                 }
             }
                
         });
         
          formInicio.listProductos.setModel(model);

          System.out.println(model);
          
          
          
          //llamar al agente para que guarde
     }
     public void cargarComboCategorias(){
               
            DefaultComboBoxModel model = new DefaultComboBoxModel();
            this.categorias.forEach((p) -> {
                model.addElement(p.toString());
            });
            formInicio.comboCategorias.setModel(model);

               
      }
      public void cargarListaProductos()
      {
            DefaultListModel model = new DefaultListModel();
            this.productos.forEach((p) -> {
                model.addElement(p.toString());
     
            });
           formInicio.listProductos.setModel(model);
           
            System.out.println(model);
  
      }
      
      public void Salir() {
          this.formInicio.dispose();
          /*if(((JButton)e.getSource()).getText().equals("Atras")){
              formInicio.setVisible(false);
             // formPrincipal.setVisible(true); //Mostrar la vista principal
          }*/
      }
      
      public void cargarCategorias(){
        this.categorias =  CargarDatos.CargarCategorias();
   
      }
     public void cargarProductos(){
        this.productos =  CargarDatos.CargarProductos();
                 
     }
     
      @Override
  public void actionPerformed(ActionEvent e) 
    {
       System.out.println(e.getSource());
       
      
        
       if (e.getSource().equals(this.formInicio.comboCategorias)){
          // ControladorInicio controladorInicio = new ControladorInicio();
          System.out.println(this.formInicio.comboCategorias.getSelectedItem());
           try {
               this.filtrarProdxCat(this.buscarCatxNombre(this.formInicio.comboCategorias.getSelectedItem().toString()));
           } catch (IOException ex) {
               Logger.getLogger(ControladorInicio.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
         if (e.getSource().equals(this.formInicio.getBtnBuscar())){
          // ControladorInicio controladorInicio = new ControladorInicio();
          System.out.println("BtnBuscar");
          this.buscarProductos(this.formInicio.getTxtBuscar().getText());
           
       }
         if (e.getSource().equals(this.formInicio.getBtnSalir())){
                agente.doDelete();
         }
          if (e.getSource().equals(this.formInicio.listProductos)){
              
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

    @Override
    public void valueChanged(ListSelectionEvent lse) {
           
                 /*if (lse.getSource().equals(this.formInicio.listProductos)){
              
                //  System.out.println(lse.getSource());
                     System.out.println(this.formInicio.listProductos.getSelectedIndex());
                     System.out.println(this.formInicio.listProductos.getSelectedValue());   
                     
                     
                     //      System.out.println(this.formInicio.listProductos.getSelectedValue());
                 }*/
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        if (me.getSource().equals(this.formInicio.listProductos)){
             JList list = (JList)me.getSource();
        if (me.getClickCount() == 2) {
        System.out.println(this.formInicio.listProductos.getSelectedValue());   

        ControladorDetalle controladorDetalle = new ControladorDetalle(buscarProdxTitulo(this.formInicio.listProductos.getSelectedValue()),this.formInicio);
            try {
                this.agente.guardarComportamiento(new Preferencia(1,buscarProdxTitulo(this.formInicio.listProductos.getSelectedValue()).getId(),0));
            } catch (IOException ex) {
                Logger.getLogger(ControladorInicio.class.getName()).log(Level.SEVERE, null, ex);
            }
            // Double-click detected
        int index = list.locationToIndex(me.getPoint());
        } 
        }
        
           if (me.getSource().equals(this.formInicio.btnCarrito)){
                 System.out.println("Carrito con productos" + productos_carrito.size());
           ControladorCarrito controladorCarrito = new ControladorCarrito(this.agente.getLocalName(), productos_carrito);
           }
      

    }

    @Override
    public void mousePressed(MouseEvent me) {
        
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        
    }

    @Override
    public void mouseEntered(MouseEvent me) {
      
    }

    @Override
    public void mouseExited(MouseEvent me) {
      
    }

}


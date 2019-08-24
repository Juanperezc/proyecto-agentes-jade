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
import javax.swing.UIManager;

/**
 *
 * @author juan
 */
public class ControladorInicio {
    
    private VPrincipal formPrincipal;
    
    
    //arreglo de productos
    private ArrayList<Producto> productos;
    
    //arreglo de categorias
    private ArrayList<Categoria> categorias;
    
    private agentes.Intermediario agente;
     public ControladorInicio(agentes.Intermediario intermediario) {
       agente = intermediario;
       System.out.println("Controlador inicio");
       
       //cargamos productos y categorias
       this.categorias = new ArrayList<Categoria>();
       this.productos = new ArrayList<Producto>();
       
       this.cargarCategorias();
       this.cargarProductos();
       this.agente.guardarComportamiento("Marico");

     }
      public void cargarCategorias(){
          this.categorias.add(new Categoria(1,"calzado"));
          this.categorias.add(new Categoria(2,"ropa interior"));
          this.categorias.add(new Categoria(3,"joyeria"));
      }
     public void cargarProductos(){
         //zapatos
         
         this.productos.add(new Producto(
         1,
         "Comodo negro etc",
         "zapato1.png",
         "Nike 1",
         40.20,
         1));
    
        
         this.productos.add(new Producto(
         1,
         "Comodo blanco etc",
         "zapato2.png",
         "Nike 2",
         50.20,
         1));
     }
     
    

}

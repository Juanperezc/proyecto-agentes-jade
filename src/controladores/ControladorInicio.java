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
import java.util.List;
import java.util.Objects;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JTable;
import javax.swing.UIManager;

/**
 *
 * @author juan
 */
public final class ControladorInicio implements ActionListener,KeyListener {
    
    private VInicio formInicio;
    private String username;
    DefaultListModel<String> model;
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
       this.agente.guardarComportamiento("Marico");
       formInicio=new VInicio();
       formInicio.setVisible(true);
       formInicio.agregarListener(this);
       formInicio.lblUsuario.setText("Usuario: " + agente.getLocalName());
       this.cargarCategorias();
       this.cargarProductos();
       this.cargarListaProductos();
       this.cargarComboCategorias();

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
     public void filtrarProdxCat(Integer cat){
         DefaultListModel model = new DefaultListModel();
         ArrayList<Producto> prod_filtrados;
         prod_filtrados = new ArrayList<Producto>();
         this.productos.forEach((p) -> 
         {
             if (p.getCategoria_id() == cat)
                  model.addElement(p);
         });
         
          formInicio.listProductos.setModel(model);

          System.out.println(model);
          //llamar al agente para que guarde
     }
     public void buscarProductos(String titulo){
         DefaultListModel model = new DefaultListModel();
         ArrayList<Producto> prod_filtrados;
         prod_filtrados = new ArrayList<Producto>();
         this.productos.forEach((p) -> 
         {
             if (p.getTitulo().equals(titulo))
                  model.addElement(p);
         });
         
          formInicio.listProductos.setModel(model);

          System.out.println(model);
          
          //llamar al agente para que guarde
     }
     public void cargarComboCategorias(){
               
            DefaultComboBoxModel model = new DefaultComboBoxModel();
            this.categorias.forEach((p) -> {
                model.addElement(p);
            });
            formInicio.comboCategorias.setModel(model);

               
      }
      public void cargarListaProductos()
      {
            DefaultListModel model = new DefaultListModel();
            this.productos.forEach((p) -> {
                model.addElement(p);
     
            });
           formInicio.listProductos.setModel(model);
           
            System.out.println(model);
  
      }
      public void cargarCategorias(){
          this.categorias.add(new Categoria(0,"Todos los productos"));
          this.categorias.add(new Categoria(1,"Calzado"));
          this.categorias.add(new Categoria(2,"Lenceria"));
          this.categorias.add(new Categoria(3,"Joyeria"));
          this.categorias.add(new Categoria(4, "Cartera"));
          this.categorias.add(new Categoria(5, "Ropa"));
      }
     public void cargarProductos(){
         //zapatos
         
         this.productos.add(new Producto(
         1,
         "Comodo, acolchado, ligero, cuero, beish",
         "calzados-inglese-100-cuero-D_NQ_NP_641175-MLV31250968985_062019-Q_opt.jpg",
         "Inglese",
         40.20,
         1));
    
        
         this.productos.add(new Producto(
         2,
         "Comodo, flexible, resistente, tela, negro",
         "201058-78025-large_default_opt.jpg",
         "Adidas",
         50.20,
         1));
         
         this.productos.add(new Producto(
         3,
         "Comodo, flexible, ligero, negro, cuero y tela",
         "luna-chiara-0190-061263-1-catalog-new_opt.jpg",
         "Converse",
         60.20,
         1));
         
         this.productos.add(new Producto(
         4,
         "Brillante, oro 18k",
         "187083nprmx_opt.jpg",
         "Fossil",
         20.20,
         3));
         
         this.productos.add(new Producto(
         5,
         "Comodas, algodón, negras",
         "carocuore_591602_02_1_opt",
         "Ovejitas",
         5.20,
         2));
         
         this.productos.add(new Producto(
         6,
         "Comodas, algodón, gris con amarillo",
         "images (1)_opt.jpg",
         "Ovejitas",
         6.50,
         2));
         
         this.productos.add(new Producto(
         7,
         "Ligera, cuero, beish",
         "images (2)_opt.jpg",
         "Pull & Bear",
         36.50,
         4));
         
         this.productos.add(new Producto(
         8,
         "Talla adaptable, Cuero y gamusa, azul y amarillo",
         "images (3)_opt.jpg",
         "Ferrari",
         60.70,
         5));
         
         this.productos.add(new Producto(
         9,
         "Absorbentes, comodas, flexibles, negras",
         "images_opt.jpg",
         "Roxy",
         24.80,
         2));
         
         this.productos.add(new Producto(
         10,
         "Ligera, cierre mágico, 8 bolsillos, azul marino",
         "isabella-cruz-carteras-7769-434762-1-product_opt.jpg",
         "H & M",
         45.90,
         4));
         
         this.productos.add(new Producto(
         11,
         "Comodas, gabaldina, refrescables, negras",
         "medias-negras-para-mujer-70975_.jpg",
         "Embajador",
         3.20,
         2));
         
         this.productos.add(new Producto(
         12,
         "Comodas, desechables, bolsillo urinario, negras",
         "newchic-sexy-perspectivo-encaje-transpirable-tanga-de-baja-cintura-ropa-interior_opt.jpg",
         "Rip Curl",
         6.20,
         2));
         
         this.productos.add(new Producto(
         13,
         "Comodas, algodón, rojas",
         "ropa-interior-482x320_opt.jpg",
         "Always",
         8.10,
         2));
         
         this.productos.add(new Producto(
         14,
         "Estirable, casual para la noche, vinotinto",
         "vestidos-beisboleros-casual-ropa-vestir-moda-D_NQ_NP_606742-MLV29633986831_032019-Q_opt.jpg",
         "Zara",
         80.40,
         5));
                 
     }
     
      @Override
  public void actionPerformed(ActionEvent e) 
    {
       System.out.println(e.getSource());
       if (e.getSource().equals(this.formInicio.comboCategorias)){
          // ControladorInicio controladorInicio = new ControladorInicio();
          System.out.println(this.formInicio.comboCategorias.getSelectedItem());
          this.filtrarProdxCat(this.buscarCatxNombre((String) this.formInicio.comboCategorias.getSelectedItem()));
       }
         if (e.getSource().equals(this.formInicio.getBtnBuscar())){
          // ControladorInicio controladorInicio = new ControladorInicio();
          System.out.println("BtnBuscar");
          this.buscarProductos(this.formInicio.getTxtBuscar().getText());
           
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

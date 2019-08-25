package utilidades;


import java.util.ArrayList;
import modelos.Categoria;

import modelos.Producto;

public class CargarDatos{
  
    public static ArrayList<Producto> CargarProductos(){
        ArrayList<Producto> productos = new ArrayList<Producto>();
          //zapatos
         
         productos.add(new Producto(
         1,
         "Comodo, acolchado, ligero, cuero, beish",
         "imagen3.jpg",
         "Inglese",
         40.20,
         1));
    
        
         productos.add(new Producto(
         2,
         "Comodo, flexible, resistente, tela, negro",
         "imagen2.jpg",
         "Adidas",
         50.20,
         1));
         
         productos.add(new Producto(
         3,
         "Comodo, flexible, ligero, negro, cuero y tela",
         "imagen10.jpg",
         "Converse",
         60.20,
         1));
         
         productos.add(new Producto(
         4,
         "Brillante, oro 18k",
         "imagen1.jpg",
         "Fossil",
         20.20,
         3));
         
         productos.add(new Producto(
         5,
         "Comodas, algodón, negras",
         "imagen4.jpg",
         "Night Dress",
         5.20,
         2));
         
         productos.add(new Producto(
         6,
         "Comodas, algodón, gris con amarillo",
         "imagen5.jpg",
         "Ovejitas 2",
         6.50,
         2));
         
         productos.add(new Producto(
         7,
         "Ligera, cuero, beish",
         "imagen6.jpg",
         "Pull & Bear",
         36.50,
         4));
         
         productos.add(new Producto(
         8,
         "Talla adaptable, Cuero y gamusa, azul y amarillo",
         "imagen7.jpg",
         "Ferrari",
         60.70,
         5));
         
         productos.add(new Producto(
         9,
         "Absorbentes, comodas, flexibles, negras",
         "imagen8.jpg",
         "Roxy",
         24.80,
         2));
         
         productos.add(new Producto(
         10,
         "Ligera, cierre mágico, 8 bolsillos, azul marino",
         "imagen9.jpg",
         "H & M",
         45.90,
         4));
         
         productos.add(new Producto(
         11,
         "Comodas, gabaldina, refrescables, negras",
         "imagen12.jpg",
         "Embajador",
         3.20,
         2));
         
         productos.add(new Producto(
         12,
         "Comodas, desechables, bolsillo urinario, negras",
         "imagen13.jpg",
         "Rip Curl",
         6.20,
         2));
         
         productos.add(new Producto(
         13,
         "Comodas, algodón, rojas",
         "imagen14.jpg",
         "Always",
         8.10,
         2));
         
         productos.add(new Producto(
         14,
         "Estirable, casual para la noche, vinotinto",
         "imagen16.jpg",
         "Zara",
         80.40,
         5));
         
         return productos;
    }
     public static ArrayList<Categoria> CargarCategorias(){
         ArrayList<Categoria> categorias = new ArrayList<Categoria>();

          categorias.add(new Categoria(0,"Todos los productos"));
          categorias.add(new Categoria(1,"Calzado"));
          categorias.add(new Categoria(2,"Lenceria"));
          categorias.add(new Categoria(3,"Joyeria"));
          categorias.add(new Categoria(4, "Cartera"));
          categorias.add(new Categoria(5, "Ropa"));
          
         return categorias;
     
     }
     
     
       public static Producto buscarProdxId(Integer id, ArrayList<Producto> productos){
          
        Producto prod = null;
         
         for (Producto pro : productos) {
              if (pro.getId() == id){
                  prod = pro;
              }
              
          }            
         return prod;
      
      }
       

      public static ArrayList<Producto>  buscarProdxCat(ArrayList<Producto> productos, Integer categorias_id){
        ArrayList<Producto> prod = new ArrayList<Producto>();
        Categoria categoria = null;
         
         for (Producto producto : productos) {
              if (producto.getCategoria_id()== categorias_id){
                  prod.add(producto);
              }
              
          }            
         return prod;
      
      }
}
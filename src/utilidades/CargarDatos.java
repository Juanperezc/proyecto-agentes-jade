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
         "Comodo, acolchado, ligero, cuero, beish, talla 15",
         "zapatos_beige.jpg",
         "Mercurial 11",
         40.20,
         1));
    
        
         productos.add(new Producto(
         2,
         "Comodo, flexible, resistente, tela, negro, talla 12",
         "zapatos_adidas.jpg",
         "Predator RX",
         50.20,
         1));
         
         productos.add(new Producto(
         3,
         "Comodo, flexible, ligero, negro, cuero y tela, talla 11",
         "zapatos_converse.jpg",
         "All star last generation",
         60.20,
         1));
         
         productos.add(new Producto(
         4,
         "Brillante, oro 18k, tamaño radio 4cm",
         "anillo_oro.jpg",
         "Sifrina girl",
         20.20,
         3));
         
         productos.add(new Producto(
         5,
         "Comodas, algodón, negras, talla M pequeño",
         "medias_negras_1.jpg",
         "Night Dress",
         5.20,
         2));
         
         productos.add(new Producto(
         6,
         "Comodas, algodón, gris con amarillo, talla L",
         "medias_grises_1.jpg",
         "Ovejitas 2",
         6.50,
         2));
         
         productos.add(new Producto(
         7,
         "Ligera, cuero, beish, peso 100gr",
         "cartera1.jpg",
         "Pavitas G",
         36.50,
         4));
         
         productos.add(new Producto(
         8,
         "Talla adaptable, Cuero y gamusa, azul y amarillo, talla M",
         "chaqueta.jpg",
         "Ferrari XSA",
         60.70,
         5));
         
         productos.add(new Producto(
         9,
         "Absorbentes, comodas, flexibles, negras, talla XX",
         "medias_mujer.jpg",
         "Damas de moda",
         24.80,
         2));
         
         productos.add(new Producto(
         10,
         "Ligera, cierre mágico, 8 bolsillos, azul marino, peso 50 gr",
         "cartera_A.jpg",
         "Joven y alocada",
         45.90,
         4));
         
         productos.add(new Producto(
         11,
         "Comodas, gabaldina, refrescables, vinotinto, talla J",
         "lenceria2.jpg",
         "Llamame Bruna",
         3.20,
         2));
         
         productos.add(new Producto(
         12,
         "Comodas, desechables, bolsillo urinario, rosadas, talla J",
         "lenceria3.jpg",
         "Rippeadora",
         6.20,
         2));
         
         productos.add(new Producto(
         13,
         "Comodas, algodón, rojas, talla Z mediana",
         "lenceria1.jpg",
         "Always young",
         8.10,
         2));
         
         productos.add(new Producto(
         14,
         "Estirable, casual para la noche, vinotinto, talla M grande",
         "vestido.jpg",
         "Zara & Yo",
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
              public static Categoria buscarCatxId(Integer id, ArrayList<Categoria> categorias){
          
        Categoria cat = null;
         
         for (Categoria categoria : categorias) {
              if (categoria.getId() == id){
                  cat = categoria;
              }
              
          }            
         return cat;
      
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
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author juan
 */
public class Preferencia implements Serializable {
    private int tipo;
    private int producto_id;
    private int categoria_id;
    //private ArrayList<String> producto_ids_buscados; // producto_ids que filtras por el buscador
   // private ArrayList<Integer> producto_ids_vistos; //producto_ids que clickeas
   // private ArrayList<Integer> categoria_ids_buscadas; //categoria_ids que clickeas

    public Preferencia(int tipo, int producto_id, int categoria_id) {
        
        //tipo 1 busqueda de producto
        //tipo 2 click de producto
        //tipo 3 filtro categoria
        this.tipo = tipo;
        this.producto_id = producto_id;
        this.categoria_id = categoria_id;
    }

    public Preferencia() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public int getProducto() {
        return producto_id;
    }

    public void setProducto(int producto_id) {
        this.producto_id = producto_id;
    }

    public int getCategoria() {
        return categoria_id;
    }

    public void setCategoria(int categoria_id) {
        this.categoria_id = categoria_id;
    }
    @Override
    public String toString() {
        return "Preferencia [tipo=" + tipo + ",categoria=" + categoria_id + ", producto=" + producto_id
                + "]";
    }
}

//* preferencias de usuario


//*que busco pero no compro

//* que categoria_id siempre busca
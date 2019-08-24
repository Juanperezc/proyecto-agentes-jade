/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

/**
 *
 * @author juan
 */
public class Categoria {
    
    private int id;
    private String nombre;

    
   @Override
   public String toString() 
   {
        return this.nombre;
    
   }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Categoria(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }


    
}

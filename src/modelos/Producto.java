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
public class Producto {
    private int id;
    private String descripcion;
    private String imagen;
    private String titulo;
    private double precio;
    private int categoria_id;
    
   public Producto(int id, String descripcion, String imagen, String titulo, double precio, int categoria_id) 
   {
        this.id = id;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.titulo = titulo;
        this.precio = precio;
        this.categoria_id = categoria_id;
   }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCategoria_id() {
        return categoria_id;
    }

    public void setCategoria_id(int categoria_id) {
        this.categoria_id = categoria_id;
    }
   
}

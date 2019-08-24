/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import vistas.VPrincipal;

/**
 *
 * @author juan
 */
public class ControladorInicio {
    
    private VPrincipal formPrincipal;
     
     public ControladorInicio(){
         
       formPrincipal=new VPrincipal();
       formPrincipal.setVisible(true);
       
       
     }

}

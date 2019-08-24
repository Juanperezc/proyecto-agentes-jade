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
public class ControladorPrincipal {
    
    private VPrincipal formPrincipal;
     
     public ControladorPrincipal(){
        formPrincipal=new VPrincipal();
      
       formPrincipal.setVisible(true);
       
     /*  formPrincipal.getjMenuMovimientos().setEnabled(false);
       formPrincipal.getjMenuArchivos().setEnabled(false);
       
       formPrincipal.getjTextFieldUsuario().addKeyListener(this);*/
     }

}

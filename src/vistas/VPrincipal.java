
package vistas;

import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class VPrincipal extends javax.swing.JFrame {

    public VPrincipal() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelEntrar = new javax.swing.JPanel();
        jButtonIngresar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextFieldUsuario = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        jMenuBar1 = new javax.swing.JMenuBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanelEntrar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanelEntrar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonIngresar.setText("Ingresar");
        jButtonIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIngresarActionPerformed(evt);
            }
        });
        jPanelEntrar.add(jButtonIngresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 190, 110, 40));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Contraseña");
        jPanelEntrar.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 100, 70, 30));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Ingrese usuario o e-mail");
        jPanelEntrar.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 20, 160, 30));

        jTextFieldUsuario.setName("jTextFieldUsuario"); // NOI18N
        jTextFieldUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldUsuarioActionPerformed(evt);
            }
        });
        jPanelEntrar.add(jTextFieldUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 60, 180, 30));
        jTextFieldUsuario.getAccessibleContext().setAccessibleName("");

        jPasswordField1.setName("jPasswordField1"); // NOI18N
        jPanelEntrar.add(jPasswordField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 140, 130, 30));

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addComponent(jPanelEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, 494, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(97, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jPanelEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(156, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIngresarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonIngresarActionPerformed

    private void jTextFieldUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldUsuarioActionPerformed

  

    //--------------------------
    public JButton getjButtonIngresar() {
        return jButtonIngresar;
    }
    
    //----------------------------------
    public JPasswordField getjPasswordField() {
    
        return jPasswordField1;
    }
    
    public JTextField getjTextFieldUsuario() {
        return jTextFieldUsuario;
    }

    public JPanel getjPanelEntrar() {
        return jPanelEntrar;
    }

    //-------------------------
 
    
   
//Listener
public void agregarListener (ActionListener accion)
{
    this.jButtonIngresar.addActionListener(accion);
}  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonIngresar;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanelEntrar;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextFieldUsuario;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;
import controladores.ControladorFormaPago;
/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class ModoPago extends javax.swing.JFrame {

    /**
     * Creates new form ModoPago
     */
    public ModoPago() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbltitulo = new javax.swing.JLabel();
        lblnombre = new javax.swing.JLabel();
        lbltarjeta = new javax.swing.JLabel();
        lblvencimiento = new javax.swing.JLabel();
        lblcodigo = new javax.swing.JLabel();
        txtnombre = new javax.swing.JTextField();
        txttarjeta = new javax.swing.JTextField();
        txtcodigo = new javax.swing.JTextField();
        cmbmes1 = new javax.swing.JComboBox<>();
        bsalir = new javax.swing.JButton();
        brealizar = new javax.swing.JButton();
        lblimagen = new javax.swing.JLabel();
        lblmes = new javax.swing.JLabel();
        lbldia = new javax.swing.JLabel();
        cmbdia1 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lbltitulo.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lbltitulo.setText("Forma de Pago");

        lblnombre.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblnombre.setText("Nombre del Titular:");

        lbltarjeta.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbltarjeta.setText("Numero de la Tarjeta:");

        lblvencimiento.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblvencimiento.setText("Fecha de Vencimiento:");

        lblcodigo.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblcodigo.setText("Codigo de Seguridad:");

        cmbmes1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mes", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));

        bsalir.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        bsalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imágenes/salir.png"))); // NOI18N
        bsalir.setText("Salir");
        bsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bsalirActionPerformed(evt);
            }
        });

        brealizar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        brealizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imágenes/hacerpago (1).png"))); // NOI18N
        brealizar.setText("Realizar Pago");
        brealizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                brealizarActionPerformed(evt);
            }
        });

        lblimagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imágenes/tarjetas (1).png"))); // NOI18N

        lblmes.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblmes.setText("Mes:");

        lbldia.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbldia.setText("Dia:");

        cmbdia1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dia", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(lbltarjeta, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txttarjeta, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(brealizar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblcodigo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(bsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblvencimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblmes)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbmes1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                                .addComponent(lbldia)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbdia1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(49, 49, 49)))
                        .addComponent(lblimagen)
                        .addGap(18, 18, 18))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(254, 254, 254)
                .addComponent(lbltitulo)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbltitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblnombre)
                    .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbltarjeta)
                    .addComponent(txttarjeta, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblvencimiento)
                    .addComponent(cmbmes1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblmes)
                    .addComponent(lbldia)
                    .addComponent(cmbdia1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblcodigo))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(brealizar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(36, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblimagen, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bsalirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bsalirActionPerformed

    private void brealizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_brealizarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_brealizarActionPerformed

    /**
     * @param args the command line arguments
     */
   public void agregar_listeners(controladores.ControladorFormaPago cfp){
       bsalir.addActionListener(cfp);
       brealizar.addActionListener(cfp);
   }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton brealizar;
    public javax.swing.JButton bsalir;
    private javax.swing.JComboBox<String> cmbdia1;
    public javax.swing.JComboBox<String> cmbmes1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblcodigo;
    private javax.swing.JLabel lbldia;
    private javax.swing.JLabel lblimagen;
    private javax.swing.JLabel lblmes;
    private javax.swing.JLabel lblnombre;
    private javax.swing.JLabel lbltarjeta;
    private javax.swing.JLabel lbltitulo;
    private javax.swing.JLabel lblvencimiento;
    public javax.swing.JTextField txtcodigo;
    public javax.swing.JTextField txtnombre;
    public javax.swing.JTextField txttarjeta;
    // End of variables declaration//GEN-END:variables
}

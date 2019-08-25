/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Moises
 */
public class VInicio extends javax.swing.JFrame {

    /**
     * Creates new form VDetalleTotal
     */
    public VInicio() {
        initComponents();
        

    }
public void agregarListener (ActionListener accion)
{
    this.btnBuscar.addActionListener(accion);
    this.comboCategorias.addActionListener(accion);
    this.btnSalir.addActionListener(accion);
 
  
}  
public void agregarSelectionListener (ListSelectionListener accion)
{
      this.listProductos.addListSelectionListener(accion);
     
}
public void agregarMouseListener (MouseListener accion)
{
     this.listProductos.addMouseListener(accion);
     this.btnCarrito.addMouseListener(accion);
}


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        btnCarrito = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        comboCategorias = new javax.swing.JComboBox<>();
        lblUsuario = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listProductos = new javax.swing.JList<>();
        lblUsuario1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtBuscar.setName("txtBuscar"); // NOI18N

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imágenes/imagen11.png"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.setName("btnBuscar"); // NOI18N

        btnSalir.setText("Atrás");
        btnSalir.setToolTipText("");
        btnSalir.setName("btnSalir"); // NOI18N
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnCarrito.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imágenes/imagen15.png"))); // NOI18N

        jLabel3.setText("Categorias");
        jLabel3.setName("lblProductos"); // NOI18N

        comboCategorias.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "Joyas", "Ropa interior", "Carteras", "Calzados" }));
        comboCategorias.setName("cbProductos"); // NOI18N
        comboCategorias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboCategoriasActionPerformed(evt);
            }
        });

        lblUsuario.setText("Usuario:");
        lblUsuario.setName("lblUsuario"); // NOI18N

        listProductos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listProductos.setToolTipText("");
        listProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listProductosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(listProductos);

        lblUsuario1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblUsuario1.setText("Inicio");
        lblUsuario1.setName("lblUsuario"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(lblUsuario1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnCarrito))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblUsuario)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtBuscar))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboCategorias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnBuscar, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnSalir, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addContainerGap())))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnCarrito, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUsuario1))
                .addGap(26, 26, 26)
                .addComponent(lblUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(comboCategorias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSalir))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comboCategoriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboCategoriasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboCategoriasActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        
        
    }//GEN-LAST:event_btnSalirActionPerformed

    private void listProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listProductosMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_listProductosMouseClicked
    public JTextField getTxtBuscar() {
        return txtBuscar;
    }
    public JButton getBtnBuscar() {
        return btnBuscar;
    }
     public JButton getBtnSalir() {
        return btnSalir;
    }
    public JLabel getBtnCarrito() {
        return btnCarrito;
    }
    /**
     * @param args the command line arguments
     */
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    public javax.swing.JLabel btnCarrito;
    private javax.swing.JButton btnSalir;
    public javax.swing.JComboBox<String> comboCategorias;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JLabel lblUsuario;
    public javax.swing.JLabel lblUsuario1;
    public javax.swing.JList<String> listProductos;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}

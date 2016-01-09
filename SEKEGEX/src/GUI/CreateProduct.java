/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import DataType.DataProduct;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import sekegex.Product;
import sekegex.User;

/**
 *
 * @author Toshiba PC
 */
public class CreateProduct extends javax.swing.JFrame {

    /**
     * Creates new form CreateProduct
     */
    public CreateProduct() {
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

        NombreProducto = new javax.swing.JLabel();
        NombreProductoField = new javax.swing.JTextField();
        DescripcionProducto = new javax.swing.JLabel();
        DescripcionProductoField = new javax.swing.JTextField();
        ImporteProducto = new javax.swing.JLabel();
        ImporteProductoField = new javax.swing.JTextField();
        VolverProducto = new javax.swing.JButton();
        GuardarProducto = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        NombreProducto.setText("Nombre");

        NombreProductoField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NombreProductoFieldActionPerformed(evt);
            }
        });

        DescripcionProducto.setText("Descripción");

        ImporteProducto.setText("Importe");

        ImporteProductoField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ImporteProductoFieldActionPerformed(evt);
            }
        });

        VolverProducto.setText("Volver");
        VolverProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                VolverProductoMouseClicked(evt);
            }
        });
        VolverProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VolverProductoActionPerformed(evt);
            }
        });

        GuardarProducto.setText("Guardar");
        GuardarProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                GuardarProductoMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(NombreProducto)
                        .addGap(36, 36, 36)
                        .addComponent(NombreProductoField))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(DescripcionProducto)
                            .addComponent(ImporteProducto))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(DescripcionProductoField, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ImporteProductoField, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(VolverProducto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(GuardarProducto)))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NombreProducto)
                    .addComponent(NombreProductoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DescripcionProducto)
                    .addComponent(DescripcionProductoField, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ImporteProductoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ImporteProducto))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(VolverProducto)
                    .addComponent(GuardarProducto))
                .addContainerGap(49, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void NombreProductoFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NombreProductoFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NombreProductoFieldActionPerformed

    private void ImporteProductoFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ImporteProductoFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ImporteProductoFieldActionPerformed

    private void VolverProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VolverProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_VolverProductoActionPerformed

    private void VolverProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_VolverProductoMouseClicked
        // TODO add your handling code here:
        ProductView obj = new ProductView();
        obj.setVisible(true);
        dispose();
    }//GEN-LAST:event_VolverProductoMouseClicked

    private void GuardarProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GuardarProductoMouseClicked
        // TODO add your handling code here:
        String name = NombreProductoField.getText().toString();
        String description = DescripcionProductoField.getText().toString();
        String amount = ImporteProductoField.getText().toString();
        float f = Float.parseFloat(amount);
        
        Product p = new Product(product.id);
        usr = User.getInstance();
        JFrame frame = new JFrame();
        
        if (usr.hasLicence(500)){
            p.insertProduct(name, description, f);
            JOptionPane.showMessageDialog(frame, "La creación se ha realizado con éxito", "Datos actualizados", JOptionPane.INFORMATION_MESSAGE);
            repaint();
        }
        else{
            JOptionPane.showMessageDialog(frame, "No tiene permisos para crear productos", "ERROR PERMISOS", JOptionPane.ERROR_MESSAGE);
        } 
    }//GEN-LAST:event_GuardarProductoMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CreateProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreateProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreateProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreateProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CreateProduct().setVisible(true);
            }
        });
    }
    private static DataProduct product;
    private static User usr;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel DescripcionProducto;
    private javax.swing.JTextField DescripcionProductoField;
    private javax.swing.JButton GuardarProducto;
    private javax.swing.JLabel ImporteProducto;
    private javax.swing.JTextField ImporteProductoField;
    private javax.swing.JLabel NombreProducto;
    private javax.swing.JTextField NombreProductoField;
    private javax.swing.JButton VolverProducto;
    // End of variables declaration//GEN-END:variables
}

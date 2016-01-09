/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import DataType.DataProduct;
import java.awt.event.KeyEvent;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import javax.swing.DefaultListModel;
import javax.swing.ListModel;
import sekegex.User;
import sekegex.MySQLTools;

/**
 *
 * @author Toshiba PC
 */
public class ProductView extends javax.swing.JFrame {

    /**
     * Creates new form ProductView
     */
    public ProductView() {
        initComponents();
        usr = User.getInstance();
        products = usr.listNameProducts();
        id_products = usr.listIDProducts();
        total_products = usr.listProducts();
        DB = MySQLTools.getInstance();
        
        DefaultListModel model = new DefaultListModel();
        for(int i=0; i<products.size(); i++){
            model.addElement(products.get(i));
        }
        listProduct.setModel(model);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        listProduct = new javax.swing.JList();
        CrearProducto = new javax.swing.JButton();
        Volver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        listProduct.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        listProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listProductMouseClicked(evt);
            }
        });
        listProduct.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listProductValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(listProduct);

        CrearProducto.setText("Crear Producto");
        CrearProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CrearProductoMouseClicked(evt);
            }
        });
        CrearProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CrearProductoActionPerformed(evt);
            }
        });

        Volver.setText("Volver");
        Volver.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                VolverMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Volver)
                    .addComponent(CrearProducto)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(73, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(CrearProducto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Volver)
                .addContainerGap(84, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CrearProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CrearProductoActionPerformed
        // TODO add your handling code here:
        // NADA
    }//GEN-LAST:event_CrearProductoActionPerformed

    private void CrearProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CrearProductoMouseClicked
        // TODO add your handling code here:
        CreateProduct obj = new CreateProduct();
        obj.setVisible(true);
        dispose();
    }//GEN-LAST:event_CrearProductoMouseClicked

    private void VolverMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_VolverMouseClicked
        // TODO add your handling code here:
        MainMenu obj = new MainMenu();
        obj.setVisible(true);
        dispose();
    }//GEN-LAST:event_VolverMouseClicked

    private void listProductValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listProductValueChanged
        // TODO add your handling code here:
       // NADA
    }//GEN-LAST:event_listProductValueChanged

    private void listProductMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listProductMouseClicked
        // TODO add your handling code here:
        int i = evt.getID();
        DataProductView obj = new DataProductView(usr.consultProduct(i));
        obj.setVisible(true);
        dispose();
    }//GEN-LAST:event_listProductMouseClicked

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
            java.util.logging.Logger.getLogger(ProductView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProductView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProductView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProductView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProductView().setVisible(true);
            }
        });
    }
    private User usr;
    private MySQLTools DB;
    public Vector products;
    public Vector id_products;
    public Vector total_products;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CrearProducto;
    private javax.swing.JButton Volver;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList listProduct;
    // End of variables declaration//GEN-END:variables
}

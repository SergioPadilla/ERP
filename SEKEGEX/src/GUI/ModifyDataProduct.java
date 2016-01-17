/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import DataType.DataProduct;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import sekegex.User;
import sekegex.Product;


/**
 *
 * @author Toshiba PC
 */
public class ModifyDataProduct extends javax.swing.JFrame {

    /**
     * Creates new form ModifyDataProduct
     */
    public ModifyDataProduct(DataProduct product) {
        initComponents();
        this.getContentPane().setBackground(Color.BLACK);
        producto = product;
        this.setTitle("Modificar producto");
        usr = User.getInstance(); 
        
        newName.setText(producto.name);
        newDescription.setText(producto.description);
        String s1 = Float.toString(producto.amount);
        newPrice.setText(s1);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        name = new javax.swing.JLabel();
        newName = new javax.swing.JTextField();
        description = new javax.swing.JLabel();
        price = new javax.swing.JLabel();
        saveButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        newDescription = new javax.swing.JTextArea();
        newPrice = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        name.setBackground(new java.awt.Color(0, 0, 0));
        name.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        name.setForeground(new java.awt.Color(255, 255, 255));
        name.setText("Nuevo nombre:");

        description.setBackground(new java.awt.Color(0, 0, 0));
        description.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        description.setForeground(new java.awt.Color(255, 255, 255));
        description.setText("Nueva descripción:");

        price.setBackground(new java.awt.Color(0, 0, 0));
        price.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        price.setForeground(new java.awt.Color(255, 255, 255));
        price.setText("Nuevo precio:");

        saveButton.setText("Guardar");
        saveButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                saveButtonMouseClicked(evt);
            }
        });

        cancelButton.setText("Volver");
        cancelButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cancelButtonMouseClicked(evt);
            }
        });

        newDescription.setColumns(20);
        newDescription.setRows(5);
        jScrollPane1.setViewportView(newDescription);

        newPrice.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(description)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(price)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(newPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(cancelButton)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(saveButton))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(name)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(newName, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(name)
                    .addComponent(newName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addComponent(description)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(price)
                    .addComponent(newPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveButton)
                    .addComponent(cancelButton))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelButtonMouseClicked
        // TODO add your handling code here:
        DataProductView obj = new DataProductView(producto);
            obj.setSize(getSize());
            obj.setLocation(getLocation());
            obj.setVisible(true);
        dispose();
    }//GEN-LAST:event_cancelButtonMouseClicked

    private void saveButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveButtonMouseClicked
        // TODO add your handling code here:
        String nuevoNombre = newName.getText().toString();
        String nuevaDescripcion = newDescription.getText().toString();
        float nuevoPrecioF = 0;
        if(!newPrice.getText().equals("")){
            //String nuevoPrecio = newPrice.getText().toString();
            nuevoPrecioF = Float.parseFloat(newPrice.getText().replace(",", ".").toString());
        }
        Product product = new Product(producto.id);
        JFrame frame = new JFrame();        
        
        if(nuevoNombre.equals("")){
            JOptionPane.showMessageDialog(this, "El campo NOMBRE no puede estar vacío", "NOMBRE Vacío", JOptionPane.ERROR_MESSAGE);
        }
        else if(nuevaDescripcion.equals("")){
            JOptionPane.showMessageDialog(this, "El campo DESCRIPCIÓN no puede estar vacío", "DESCRIPCIÓN Vacía", JOptionPane.ERROR_MESSAGE);
        }
        else if(nuevoPrecioF == 0){
            JOptionPane.showMessageDialog(this, "El IMPORTE no puede ser vacío ni contener letras", "IMPORTE Vacío", JOptionPane.ERROR_MESSAGE);
        }
        
        else if(usr.hasLicence(500)){
            product.modifyProduct(nuevoNombre,nuevaDescripcion,nuevoPrecioF);
            JOptionPane.showMessageDialog(frame, "La modificación se ha realizado con éxito", "Datos Actualizados", JOptionPane.INFORMATION_MESSAGE);
            producto = product.getData();
        }
        else{
            JOptionPane.showMessageDialog(frame, "No tiene permisos para crear productos", "ERROR PERMISOS", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_saveButtonMouseClicked

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
            java.util.logging.Logger.getLogger(ModifyDataProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModifyDataProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModifyDataProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModifyDataProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModifyDataProduct(producto).setVisible(true);
            }
        });
    }
    public static DataProduct producto;
    private User usr;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel description;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel name;
    private javax.swing.JTextArea newDescription;
    private javax.swing.JTextField newName;
    private javax.swing.JFormattedTextField newPrice;
    private javax.swing.JLabel price;
    private javax.swing.JButton saveButton;
    // End of variables declaration//GEN-END:variables
}

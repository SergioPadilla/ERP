/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Color;
import sekegex.User;

/**
 *
 * @author Sergio
 */
public class MainMenu extends javax.swing.JFrame {

    /**
     * Creates new form MainMenu
     */
    public MainMenu() {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setTitle("Menú Principal");
        usr = User.getInstance();
                this.getContentPane().setBackground(Color.BLACK);

        if(!usr.hasLicence(103)){
            workflow_button.setEnabled(false);
        }
        if(!usr.hasLicence(303)){
            clients_button.setEnabled(false);
        }
        if(!usr.hasLicence(503)){
            products_button.setEnabled(false);
        }
        if(!usr.hasLicence(903)){
            jButton1.setEnabled(false);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        clients_button = new javax.swing.JButton();
        products_button = new javax.swing.JButton();
        workflow_button = new javax.swing.JButton();
        logOut_button = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        clients_button.setText("Clientes");
        clients_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clients_buttonActionPerformed(evt);
            }
        });

        products_button.setText("Productos");
        products_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                products_buttonActionPerformed(evt);
            }
        });

        workflow_button.setText("Tareas");
        workflow_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                workflow_buttonActionPerformed(evt);
            }
        });

        logOut_button.setText("Desconectar");
        logOut_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logOut_buttonMouseClicked(evt);
            }
        });

        jButton1.setText("Empleados");
        jButton1.setToolTipText("");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/jrQlLrZf.jpeg"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(logOut_button))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(clients_button, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(99, 99, 99)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(products_button, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(workflow_button, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(clients_button)
                    .addComponent(products_button))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(workflow_button))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addComponent(logOut_button))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void logOut_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logOut_buttonMouseClicked
        SEKEGEX obj = new SEKEGEX();
        obj.setVisible(true);
        obj.setSize(getSize());
        obj.setLocation(getLocation());
        dispose();
    }//GEN-LAST:event_logOut_buttonMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        EmployeeView obj = new EmployeeView();
        obj.setSize(getSize());
        obj.setLocation(getLocation());
        obj.setVisible(true);
        dispose();

    }//GEN-LAST:event_jButton1ActionPerformed

    private void products_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_products_buttonActionPerformed
        // TODO add your handling code here:
        ProductView obj = new ProductView();
        obj.setSize(getSize());
        obj.setLocation(getLocation());
        obj.setVisible(true);
        dispose();
    }//GEN-LAST:event_products_buttonActionPerformed

    private void clients_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clients_buttonActionPerformed
        // TODO add your handling code here:
        ClientView obj = new ClientView();
        obj.setSize(getSize());
        obj.setLocation(getLocation());
        obj.setVisible(true);
        dispose();
    }//GEN-LAST:event_clients_buttonActionPerformed

    private void workflow_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_workflow_buttonActionPerformed
        // TODO add your handling code here:
        Workflow obj = new Workflow();
        obj.setSize(getSize());
        obj.setLocation(getLocation());
        obj.setVisible(true);
        dispose();
    }//GEN-LAST:event_workflow_buttonActionPerformed

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
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainMenu().setVisible(true);
            }
        });
    }

    private User usr;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton clients_button;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton logOut_button;
    private javax.swing.JButton products_button;
    private javax.swing.JButton workflow_button;
    // End of variables declaration//GEN-END:variables
}

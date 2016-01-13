/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

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
        this.setTitle("Menú Principal");
        User usr = User.getInstance();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        clients_button.setText("Clientes");
        clients_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clients_buttonMouseClicked(evt);
            }
        });

        products_button.setText("Productos");
        products_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                products_buttonMouseClicked(evt);
            }
        });

        workflow_button.setText("Tareas");
        workflow_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                workflow_buttonMouseClicked(evt);
            }
        });

        logOut_button.setText("Desconectar");
        logOut_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logOut_buttonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(clients_button)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                .addComponent(products_button)
                .addGap(28, 28, 28))
            .addGroup(layout.createSequentialGroup()
                .addGap(105, 105, 105)
                .addComponent(workflow_button)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(logOut_button))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(clients_button)
                    .addComponent(products_button))
                .addGap(52, 52, 52)
                .addComponent(workflow_button)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(logOut_button))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void clients_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clients_buttonMouseClicked
        ClientView obj = new ClientView();
        obj.setVisible(true);//Crear vista para clientes
        dispose();

    }//GEN-LAST:event_clients_buttonMouseClicked

    private void products_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_products_buttonMouseClicked
        ProductView obj = new ProductView();
        obj.setVisible(true);
        dispose();
    }//GEN-LAST:event_products_buttonMouseClicked

    private void workflow_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_workflow_buttonMouseClicked
        Workflow obj = new Workflow();
        obj.setVisible(true);
        dispose();
    }//GEN-LAST:event_workflow_buttonMouseClicked

    private void logOut_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logOut_buttonMouseClicked
        Login obj = new Login();
        obj.setVisible(true);
        dispose();
    }//GEN-LAST:event_logOut_buttonMouseClicked

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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton clients_button;
    private javax.swing.JButton logOut_button;
    private javax.swing.JButton products_button;
    private javax.swing.JButton workflow_button;
    // End of variables declaration//GEN-END:variables
}

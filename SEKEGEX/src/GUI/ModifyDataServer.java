/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import DataType.DataServer;
import sekegex.User;
import sekegex.Server;


/**
 *
 * @author jopime
 */
public class ModifyDataServer extends javax.swing.JFrame {

    /**
     * Creates new form ModifyDataServer
     */
    public ModifyDataServer(DataServer data) {
        initComponents();
        usr = User.getInstance();
        server = data;
        id_server.setText(""+server.id_server+"");
        id_client.setText(""+server.id_client+"");
        name.setText(server.name);
        ip.setText(server.ip);
        userFTP.setText(server.user_ftp);
        passFTP.setText(server.pass_ftp);
        userHOST.setText(server.user_host);
        passHOST.setText(server.pass_host);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ip = new javax.swing.JTextField();
        id_client = new javax.swing.JTextField();
        name = new javax.swing.JTextField();
        id_label = new javax.swing.JLabel();
        name_label = new javax.swing.JLabel();
        userFTP = new javax.swing.JTextField();
        ID_client_label = new javax.swing.JLabel();
        passFTP = new javax.swing.JTextField();
        ip_label = new javax.swing.JLabel();
        userFTP_label = new javax.swing.JLabel();
        save_button = new javax.swing.JButton();
        passFTP_label = new javax.swing.JLabel();
        back_button = new javax.swing.JButton();
        userHOST_label = new javax.swing.JLabel();
        id_server = new javax.swing.JTextField();
        userHOST = new javax.swing.JTextField();
        passHOST = new javax.swing.JTextField();
        passHOST_label = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameActionPerformed(evt);
            }
        });

        id_label.setText("ID Servidor");

        name_label.setText("Nombre");

        ID_client_label.setText("ID cliente");

        ip_label.setText("Ruta Acceso");

        userFTP_label.setText("Usuario FTP");

        save_button.setText("Guardar");
        save_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                save_buttonMouseClicked(evt);
            }
        });

        passFTP_label.setText("Password FTP");

        back_button.setText("Volver");
        back_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                back_buttonMouseClicked(evt);
            }
        });
        back_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back_buttonActionPerformed(evt);
            }
        });

        userHOST_label.setText("Usuario HOST");

        id_server.setEditable(false);

        passHOST_label.setText("Password HOST");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(name_label)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ip_label)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ip))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(userFTP_label)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(userFTP))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(passFTP_label)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(passFTP))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(passHOST_label)
                        .addGap(26, 26, 26)
                        .addComponent(passHOST))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(ID_client_label)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(id_client))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(id_label)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(id_server, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE))
                            .addComponent(userHOST_label, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(userHOST, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(365, Short.MAX_VALUE)
                .addComponent(save_button)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(back_button)
                .addGap(126, 126, 126))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(id_label)
                    .addComponent(id_server, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(name_label)
                    .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ID_client_label)
                    .addComponent(id_client, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ip_label)
                    .addComponent(ip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userFTP_label)
                    .addComponent(userFTP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passFTP_label)
                    .addComponent(passFTP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userHOST_label)
                    .addComponent(userHOST, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passHOST_label)
                    .addComponent(passHOST, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(save_button)
                    .addComponent(back_button))
                .addGap(0, 45, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameActionPerformed

    private void save_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_save_buttonMouseClicked
        final String namenew = name.getText().toString();
        final String access = ip.getText().toString();
        final String user_ftp = userFTP.getText().toString();
        final String password_ftp = passFTP.getText().toString();
        final String user_host = userHOST.getText().toString();
        final String password_host = passHOST.getText().toString();

        Server v = new Server(server.id_server);
        JFrame frame = new JFrame();
        if(v.modifyServer(namenew, access, user_ftp, password_ftp, user_host, password_host)){
            JOptionPane.showMessageDialog(frame, "La modificación se ha realizado con éxito", "Datos Actualizados", JOptionPane.INFORMATION_MESSAGE);
            repaint();
            server = v.getData();
        }
        else{
            JOptionPane.showMessageDialog(frame, "No tienes permisos para modificar clientes", "ERROR PERMISOS", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_save_buttonMouseClicked

    private void back_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_back_buttonMouseClicked
        DataServerView obj = new DataServerView(server);
        obj.setVisible(true);
        dispose();
    }//GEN-LAST:event_back_buttonMouseClicked

    private void back_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back_buttonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_back_buttonActionPerformed

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
            java.util.logging.Logger.getLogger(ModifyDataServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModifyDataServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModifyDataServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModifyDataServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModifyDataServer(server).setVisible(true);
            }
        });
    }
    private User usr;
    private static DataServer server;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ID_client_label;
    private javax.swing.JButton back_button;
    public javax.swing.JTextField id_client;
    private javax.swing.JLabel id_label;
    private javax.swing.JTextField id_server;
    public javax.swing.JTextField ip;
    private javax.swing.JLabel ip_label;
    public javax.swing.JTextField name;
    private javax.swing.JLabel name_label;
    public javax.swing.JTextField passFTP;
    private javax.swing.JLabel passFTP_label;
    private javax.swing.JTextField passHOST;
    private javax.swing.JLabel passHOST_label;
    private javax.swing.JButton save_button;
    public javax.swing.JTextField userFTP;
    private javax.swing.JLabel userFTP_label;
    private javax.swing.JTextField userHOST;
    private javax.swing.JLabel userHOST_label;
    // End of variables declaration//GEN-END:variables
}
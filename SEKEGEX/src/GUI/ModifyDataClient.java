/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DataType.DataClient;
import Utils.TypeClient;
import com.aeat.valida.Validador;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import sekegex.Client;
import sekegex.User;

/**
 *
 * @author Sergio
 */
public class ModifyDataClient extends javax.swing.JFrame {

    /**
     * Creates new form ModifyDataClient
     */
    public ModifyDataClient(DataClient data) {
        initComponents();
        usr = User.getInstance();
        client = data;
        date.setText(client.registration.toString());
        name.setText(client.name);
        surname.setText(client.surname+" ");
        email.setText(client.email);
        dni.setText(client.dni);
        id_client.setText(data.idToString());
    }

    ModifyDataClient() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        id_label = new javax.swing.JLabel();
        name_label = new javax.swing.JLabel();
        surname_label = new javax.swing.JLabel();
        dni_label = new javax.swing.JLabel();
        email_label = new javax.swing.JLabel();
        date_label = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        surname = new javax.swing.JTextField();
        dni = new javax.swing.JTextField();
        email = new javax.swing.JTextField();
        id_client = new javax.swing.JLabel();
        date = new javax.swing.JLabel();
        save_button = new javax.swing.JButton();
        back_button = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        id_label.setText("ID");

        name_label.setText("Nombre");

        surname_label.setText("Apellidos");

        dni_label.setText("DNI");

        email_label.setText("Email");

        date_label.setText("Fecha alta");

        name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameActionPerformed(evt);
            }
        });

        save_button.setText("Guardar");
        save_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                save_buttonMouseClicked(evt);
            }
        });

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(save_button)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(back_button)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(id_label)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(id_client))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(date))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(surname_label)
                            .addComponent(name_label)
                            .addComponent(dni_label))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(surname, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                            .addComponent(dni)
                            .addComponent(name)))
                    .addComponent(date_label)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(email_label)
                        .addGap(37, 37, 37)
                        .addComponent(email)))
                .addContainerGap(343, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(id_label)
                    .addComponent(id_client))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(name_label)
                    .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(surname_label)
                    .addComponent(surname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dni_label)
                    .addComponent(dni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(email_label)
                    .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(58, 58, 58)
                .addComponent(date)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(date_label)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(save_button)
                    .addComponent(back_button))
                .addContainerGap(68, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameActionPerformed

    private void back_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back_buttonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_back_buttonActionPerformed

    private void back_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_back_buttonMouseClicked
        DataClientView obj = new DataClientView(client);
            obj.setSize(getSize());
            obj.setLocation(getLocation());
            obj.setVisible(true);
        dispose();
    }//GEN-LAST:event_back_buttonMouseClicked

    private void save_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_save_buttonMouseClicked
        JFrame frame = new JFrame();
            Validador validador = new Validador();
            final String dninew = dni.getText().toString();
            if (validador.checkNif(dninew)>0){
            TypeClient typenew=null;
            
            if(Character.isDigit(dninew.charAt(0))){
                typenew=TypeClient.FREELANCE;
            }
            else{
                typenew=TypeClient.BUSINESS;
            }
            final String namenew = name.getText().toString();
            final String surnamenew = surname.getText().toString();
            final String emailnew = email.getText().toString();

            Client c = new Client(client.id);
            int res=c.modifyClient(typenew, namenew, surnamenew, dninew, emailnew);
            if(res>1){
                JOptionPane.showMessageDialog(frame, "La modificación se ha realizado con éxito", "Datos Actualizados", JOptionPane.INFORMATION_MESSAGE);
                repaint();
                client = c.getData();
                DataClientView obj = new DataClientView(client);
                obj.setSize(getSize());
                obj.setLocation(getLocation());
                obj.setVisible(true);
                dispose();
            }
            else if(res>0){
                JOptionPane.showMessageDialog(frame, "El DNI ies ncorrecto", "ERROR DUPLICACION DNI", JOptionPane.ERROR_MESSAGE);
            }
            else{
                JOptionPane.showMessageDialog(frame, "No tienes permisos para modificar clientes", "ERROR PERMISOS", JOptionPane.ERROR_MESSAGE);
            }
        }
        else{
            JOptionPane.showMessageDialog(frame, "DNI incorrecto", "ERROR DATOS INVALIDOS", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_save_buttonMouseClicked

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
            java.util.logging.Logger.getLogger(ModifyDataClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModifyDataClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModifyDataClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModifyDataClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModifyDataClient(client).setVisible(true);
            }
        });
    }

    private User usr;
    private static DataClient client;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back_button;
    public javax.swing.JLabel date;
    private javax.swing.JLabel date_label;
    public javax.swing.JTextField dni;
    private javax.swing.JLabel dni_label;
    public javax.swing.JTextField email;
    private javax.swing.JLabel email_label;
    public javax.swing.JLabel id_client;
    private javax.swing.JLabel id_label;
    public javax.swing.JTextField name;
    private javax.swing.JLabel name_label;
    private javax.swing.JButton save_button;
    public javax.swing.JTextField surname;
    private javax.swing.JLabel surname_label;
    // End of variables declaration//GEN-END:variables
}

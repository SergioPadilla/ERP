/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DataType.DataBill;
import DataType.DataClient;
import DataType.DataServer;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.Vector;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import sekegex.Bill;
import sekegex.Client;
import sekegex.Server;
import sekegex.User;

/**
 *
 * @author jopime
 */
public class DataClientView extends javax.swing.JFrame {


    public DataClientView(DataClient client) {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setTitle("Cliente: " + client.name);
        this.getContentPane().setBackground(Color.BLACK);

        clienti = client;

        usr = User.getInstance();
        Client clientO= new Client(clienti.id);
        servers = clientO.listServers();
        bills = clientO.listBills();
        setFilas();
        
        if(!usr.hasLicence(700))
            jButtonAddServer.setVisible(false);
        if(!usr.hasLicence(400))
            jButtonAddBill.setVisible(false);
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
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jButtonAddServer = new javax.swing.JButton();
        jButtonAddBill = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Apellido", "email", "NIF", "Tipo", "Fecha de Alta", "Modificar"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("Volver");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Servidor", "Nombre Servidor", "Ver", "Borrar"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable2);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(2).setMinWidth(70);
            jTable2.getColumnModel().getColumn(2).setPreferredWidth(70);
            jTable2.getColumnModel().getColumn(2).setMaxWidth(70);
            jTable2.getColumnModel().getColumn(3).setMinWidth(70);
            jTable2.getColumnModel().getColumn(3).setPreferredWidth(70);
            jTable2.getColumnModel().getColumn(3).setMaxWidth(70);
        }

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Factura", "Fecha", "Ver", "Borrar"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(jTable3);
        if (jTable3.getColumnModel().getColumnCount() > 0) {
            jTable3.getColumnModel().getColumn(2).setMinWidth(70);
            jTable3.getColumnModel().getColumn(2).setPreferredWidth(70);
            jTable3.getColumnModel().getColumn(2).setMaxWidth(70);
            jTable3.getColumnModel().getColumn(3).setMinWidth(70);
            jTable3.getColumnModel().getColumn(3).setPreferredWidth(70);
            jTable3.getColumnModel().getColumn(3).setMaxWidth(70);
        }

        jButtonAddServer.setText("Añadir Servidor");
        jButtonAddServer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonAddServerMouseClicked(evt);
            }
        });

        jButtonAddBill.setText("Añadir Factura");
        jButtonAddBill.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonAddBillMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(17, 17, 17))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 871, Short.MAX_VALUE)
                            .addComponent(jScrollPane2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonAddBill, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonAddServer, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                    .addComponent(jButtonAddServer, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                    .addComponent(jButtonAddBill, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addComponent(jButton1)
                .addGap(14, 14, 14))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        ClientView obj = new ClientView();
        obj.setSize(getSize());
        obj.setLocation(getLocation());
        obj.setVisible(true);
            dispose();    }//GEN-LAST:event_jButton1MouseClicked

    private void jButtonAddServerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonAddServerMouseClicked
        CreateServerView obj = new CreateServerView(clienti);
        obj.setSize(getSize());
        obj.setLocation(getLocation());
        obj.setVisible(true);                    
        dispose();
    }//GEN-LAST:event_jButtonAddServerMouseClicked

    private void jButtonAddBillMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonAddBillMouseClicked
        CreateBillView obj = new CreateBillView(clienti);
        obj.setSize(getSize());    // corregido
        obj.setLocation(getLocation());
        obj.setVisible(true);
        dispose();    }//GEN-LAST:event_jButtonAddBillMouseClicked

    Action modify = new AbstractAction() {
        public void actionPerformed(ActionEvent e) {
            if(usr.hasLicence(302)){
                ModifyDataClient obj = new ModifyDataClient(clienti);
                obj.setSize(getSize());
                obj.setLocation(getLocation());
                obj.setVisible(true);
                dispose(); 
            }
        }
    };
    Action ver = new AbstractAction() {
        public void actionPerformed(ActionEvent e) {
            javax.swing.JTable table = (javax.swing.JTable)e.getSource();
            int modelRow = Integer.valueOf(e.getActionCommand()); 
            DataServerView obj = new DataServerView((DataServer) servers.elementAt(modelRow));
            obj.setSize(getSize());
            obj.setLocation(getLocation());
            obj.setVisible(true);
            dispose(); 
        }
    };
    
        Action borrar = new AbstractAction() {
        public void actionPerformed(ActionEvent e) {
            if(usr.hasLicence(701)){
                javax.swing.JTable table = (javax.swing.JTable)e.getSource();
                int modelRow = Integer.valueOf(e.getActionCommand());
                DefaultTableModel modelo2 = (DefaultTableModel) jTable2.getModel();

                JFrame frame = new JFrame();
                int confirmacion=JOptionPane.showConfirmDialog(frame, "¿ Quieres borrar el servidor con id: "+Integer.valueOf(modelo2.getValueAt(modelRow, 0).toString()));

                if (confirmacion==JOptionPane.YES_OPTION){    
                    Server servero=new Server(Integer.valueOf(modelo2.getValueAt(modelRow, 0).toString()));
                    servero.removeServer();
                    DataClientView obj = new DataClientView(clienti);
                    obj.setSize(getSize());
                    obj.setLocation(getLocation());
                    obj.setVisible(true);
                    dispose();

                }
            }
        }
    }; 
    
    Action verFacturas = new AbstractAction() {
        public void actionPerformed(ActionEvent e) {
            javax.swing.JTable table = (javax.swing.JTable)e.getSource();
            int modelRow = Integer.valueOf(e.getActionCommand());
            DefaultTableModel modelo3 = (DefaultTableModel) jTable3.getModel();
            
            int idBill=Integer.valueOf(modelo3.getValueAt(modelRow, 0).toString());
            BillView obj = new BillView(clienti,idBill);
            obj.setSize(getSize());
            obj.setLocation(getLocation());
            obj.setVisible(true);
            dispose(); 
        }
    };
    
    
        Action borrarFacturas = new AbstractAction() {
        public void actionPerformed(ActionEvent e) {
            if(usr.hasLicence(401)){
                javax.swing.JTable table = (javax.swing.JTable)e.getSource();
                int modelRow = Integer.valueOf(e.getActionCommand());
                DefaultTableModel modelo3 = (DefaultTableModel) jTable3.getModel();


                JFrame frame = new JFrame();
                int confirmacion=JOptionPane.showConfirmDialog(frame, "¿ Quieres borrar la factura con id: "
                        +Integer.valueOf(modelo3.getValueAt(modelRow, 0).toString())+"?");
                if (confirmacion==JOptionPane.YES_OPTION){    
                    Bill billo=new Bill(Integer.valueOf(modelo3.getValueAt(modelRow, 0).toString()));
                    billo.removeBill();
                    DataClientView obj = new DataClientView(clienti);
                    obj.setSize(getSize());
                    obj.setLocation(getLocation());
                    obj.setVisible(true);
                    dispose();
                }
            }
        }
    }; 
        
    private void setFilas() {
        DefaultTableModel modelo1 = (DefaultTableModel) jTable1.getModel();
        DefaultTableModel modelo2 = (DefaultTableModel) jTable2.getModel();
        DefaultTableModel modelo3 = (DefaultTableModel) jTable3.getModel();

        
        Object[] datos1 = {clienti.id,clienti.name,clienti.surname,clienti.email,clienti.dni,clienti.type,clienti.registration}; // Cantidad de columnas de la tabla
        modelo1.addRow(datos1);
        
        ButtonColumn buttonColumn1 = new ButtonColumn(jTable1, modify, 7);
        buttonColumn1.setMnemonic(KeyEvent.VK_D); 
        

        for(int i=0;i<servers.size();i++){
            DataServer servi=(DataServer)servers.elementAt(i);
            Object[] datos2 = {servi.id_server,servi.name}; 
            modelo2.addRow(datos2);
        }
        
        ButtonColumn buttonColumn2 = new ButtonColumn(jTable2, ver, 2);
        buttonColumn2.setMnemonic(KeyEvent.VK_D); 
        ButtonColumn buttonColumn3 = new ButtonColumn(jTable2, borrar, 3);
        buttonColumn3.setMnemonic(KeyEvent.VK_D); 
        
        for(int i=0;i<bills.size();i++){
            DataBill billi=(DataBill)bills.elementAt(i);
            Object[] datos3 = {billi.id_bill,billi.date}; 
            modelo3.addRow(datos3);
        }
        
        
        ButtonColumn buttonColumn4 = new ButtonColumn(jTable3, verFacturas, 2);
        buttonColumn4.setMnemonic(KeyEvent.VK_D);
        ButtonColumn buttonColumn5 = new ButtonColumn(jTable3, borrarFacturas, 3);
        buttonColumn4.setMnemonic(KeyEvent.VK_D);
    }
    
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
            java.util.logging.Logger.getLogger(DataClientView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DataClientView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DataClientView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DataClientView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DataClientView(clienti).setVisible(true);
            }
        });
    }

    public static DataClient clienti;
    public Vector servers;
    public Vector bills;
    private User usr;
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonAddBill;
    private javax.swing.JButton jButtonAddServer;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    // End of variables declaration//GEN-END:variables
}

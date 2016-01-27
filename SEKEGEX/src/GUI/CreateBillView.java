/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DataType.DataClient;
import DataType.DataProduct;
import DataType.DataPurchase;
import static GUI.DataClientView.clienti;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.Vector;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.table.DefaultTableModel;
import sekegex.Bill;
import sekegex.Client;
import sekegex.User;

/**
 *
 * @author jopime
 */
public class CreateBillView extends javax.swing.JFrame {

    /**
     * Creates new form CreateBillView
     */
    public CreateBillView(DataClient data, int idBill) {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
        clienti = data;

        this.setTitle("Modificacion de factura para cliente: " + clienti.name);
        borrar=false;
                this.getContentPane().setBackground(Color.BLACK);

        User usr = User.getInstance();
        billi=new Bill(idBill);
        products = usr.listProducts();
        billproducts=billi.listProductsforbill();
        setFilas1();
        setFilas2();
    }
    
    public CreateBillView(DataClient data) {
        initComponents();
        clienti = data;
        this.setTitle("Cracion de factura para cliente: " + clienti.name);     
                        this.getContentPane().setBackground(Color.BLACK);

        User usr = User.getInstance();
        int idBill=usr.insertBill(data.id);
        borrar=true;
        billi=new Bill(idBill);
        products = usr.listProducts();
        setFilas1();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        returnButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableAdd = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTablelist = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        totalBill = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        returnButton.setText("Volver");
        returnButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                returnButtonMouseClicked(evt);
            }
        });

        jTableAdd.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Añadir Productos"
            }
        ));
        jTableAdd.setIntercellSpacing(new java.awt.Dimension(2, 2));
        jTableAdd.setRowHeight(32);
        jScrollPane1.setViewportView(jTableAdd);
        if (jTableAdd.getColumnModel().getColumnCount() > 0) {
            jTableAdd.getColumnModel().getColumn(0).setHeaderValue("Añadir Productos");
        }

        jTablelist.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nombre", "Cantidad", ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTablelist.setRowHeight(32);
        jScrollPane3.setViewportView(jTablelist);
        if (jTablelist.getColumnModel().getColumnCount() > 0) {
            jTablelist.getColumnModel().getColumn(0).setMinWidth(70);
            jTablelist.getColumnModel().getColumn(0).setPreferredWidth(70);
            jTablelist.getColumnModel().getColumn(0).setMaxWidth(70);
            jTablelist.getColumnModel().getColumn(2).setMinWidth(70);
            jTablelist.getColumnModel().getColumn(2).setPreferredWidth(70);
            jTablelist.getColumnModel().getColumn(2).setMaxWidth(70);
            jTablelist.getColumnModel().getColumn(3).setMinWidth(50);
            jTablelist.getColumnModel().getColumn(3).setPreferredWidth(50);
            jTablelist.getColumnModel().getColumn(3).setMaxWidth(50);
        }

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Precio Total:");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/jrQlLrZf.jpeg"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(returnButton))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(10, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(42, 42, 42)
                                .addComponent(totalBill, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)))
                        .addGap(0, 65, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(totalBill, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(returnButton, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void returnButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_returnButtonMouseClicked
       if(borrar||jTablelist.getRowCount()<1){
            billi.removeBill();
       }
        DataClientView obj = new DataClientView(clienti);
       obj.setSize(getSize());
       obj.setLocation(getLocation());
       obj.setVisible(true);
       dispose();
    }//GEN-LAST:event_returnButtonMouseClicked

        Action add = new AbstractAction() {
        public void actionPerformed(ActionEvent e) {
            javax.swing.JTable table = (javax.swing.JTable)e.getSource();
            
            int modelRow = Integer.valueOf(e.getActionCommand()); 
            DataProduct prodi=(DataProduct)products.elementAt(modelRow);
            billi.insertPurchase(prodi.id);
            
            CreateBillView obj = new CreateBillView(clienti,billi.getData().id_bill);
            obj.setSize(getSize());
            obj.setLocation(getLocation());
            obj.setVisible(true);
            dispose();
            
        }
    };
        
        Action less = new AbstractAction() {
        public void actionPerformed(ActionEvent e) {
            javax.swing.JTable table = (javax.swing.JTable)e.getSource();
            
            int modelRow = Integer.valueOf(e.getActionCommand()); 
            DefaultTableModel modelo1 = (DefaultTableModel) jTablelist.getModel();
            billi.deletePurchase(Integer.valueOf(modelo1.getValueAt(modelRow, 0).toString()));           
            CreateBillView obj = new CreateBillView(clienti,billi.getData().id_bill);
            obj.setSize(getSize());
            obj.setLocation(getLocation());
            obj.setVisible(true);        }
    };
        private void setFilas1() {
        User usr = User.getInstance();
        DefaultTableModel modelo1 = (DefaultTableModel) jTableAdd.getModel();    

        for(int i=0;i<products.size();i++){
            DataProduct prodi=(DataProduct)products.elementAt(i);
            Object[] datos1 = {prodi.name}; 
            modelo1.addRow(datos1);
        }
        
        ButtonColumn buttonColumn1 = new ButtonColumn(jTableAdd, add, 0);
        buttonColumn1.setMnemonic(KeyEvent.VK_D); 
        }
        private void setFilas2(){
            float ganancia=0;
        User usr = User.getInstance();
        DefaultTableModel modelo2 = (DefaultTableModel) jTablelist.getModel();    
            DataProduct prodi,prodj;
        for(int i=0;i<billproducts.size();i++){
             prodi=(DataProduct)billproducts.elementAt(i);
            Object[] datos2 = {prodi.id,prodi.name,billi.consultPurchase(prodi.id).quantity,"-"};
            ganancia=ganancia+prodi.amount*Integer.valueOf(datos2[2].toString());
           
            totalBill.setText(Float.toString(ganancia));
            modelo2.addRow(datos2);            
        }
        
        ButtonColumn buttonColumn2 = new ButtonColumn(jTablelist, less, 3);
        buttonColumn2.setMnemonic(KeyEvent.VK_D); 
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
            java.util.logging.Logger.getLogger(CreateBillView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreateBillView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreateBillView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreateBillView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CreateBillView(clienti,billi.getData().id_bill).setVisible(true);
            }
        });
    }

    
    public static DataClient clienti;
    public Vector products;
    public Vector billproducts=null;
    public static Bill billi;
    public boolean borrar=false;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTableAdd;
    private javax.swing.JTable jTablelist;
    private javax.swing.JButton returnButton;
    private javax.swing.JTextField totalBill;
    // End of variables declaration//GEN-END:variables
}

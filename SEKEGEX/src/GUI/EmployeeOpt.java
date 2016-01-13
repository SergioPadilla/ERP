/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DataType.DataEmployee;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import sekegex.Employee;
import sekegex.User;

/**
 *
 * @author Ivan
 */
public class EmployeeOpt extends javax.swing.JPanel {

    /**
     * Creates new form EmployeeOpt
     */
    public EmployeeOpt(DataEmployee emp) {
        employee=null;
        initComponents();
        ImageIcon deleteIcon = new ImageIcon(getClass().getResource("/Images/trash.png"));
        deleteButton.setIcon(deleteIcon);
        ImageIcon editIcon = new ImageIcon(getClass().getResource("/Images/edit.png"));
        editButton.setIcon(editIcon);
        ImageIcon showIcon = new ImageIcon(getClass().getResource("/Images/eye.png"));
        showButton.setIcon(showIcon);
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append(emp.id_employee);
        String id = sb.toString();
        jLabel1.setText(id);
        jLabel2.setText(emp.name);
        jLabel3.setText(emp.surname);
        dataEmp=emp;
    }
    
    public void update(DataEmployee emp){
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append(emp.id_employee);
        String id = sb.toString();
        jLabel1.setText(id);
        jLabel2.setText(emp.name);
        jLabel3.setText(emp.surname);
        dataEmp=emp;
        if(employee!=null){
            employee=new Employee(emp.id_employee);
        }
    }
    
    public void setWindow(EmployeeView win){
        window=win;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        showButton = new javax.swing.JButton();
        editButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        showButton.setMaximumSize(new java.awt.Dimension(33, 33));
        showButton.setMinimumSize(new java.awt.Dimension(33, 33));
        showButton.setName(""); // NOI18N
        showButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showButtonActionPerformed(evt);
            }
        });

        editButton.setMaximumSize(new java.awt.Dimension(33, 33));
        editButton.setMinimumSize(new java.awt.Dimension(33, 33));
        editButton.setName(""); // NOI18N
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });

        deleteButton.setMaximumSize(new java.awt.Dimension(33, 33));
        deleteButton.setMinimumSize(new java.awt.Dimension(33, 33));
        deleteButton.setName(""); // NOI18N
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("jLabel1");

        jLabel2.setText("jLabel2");

        jLabel3.setText("jLabel3");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(91, 91, 91)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 119, Short.MAX_VALUE)
                .addComponent(showButton, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(editButton, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(deleteButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(editButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(showButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void showButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showButtonActionPerformed
        // TODO add your handling code here:
        if(employee==null){
            employee=new Employee(dataEmp.id_employee);
        }
        window.showEmployee(employee);
    }//GEN-LAST:event_showButtonActionPerformed

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        // TODO add your handling code here:
        if(employee==null){
            employee=new Employee(dataEmp.id_employee);
        }
        window.modifyEmployee(employee);
        window.setActEmp(employee);
    }//GEN-LAST:event_editButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        // TODO add your handling code here:
        
        int selection = JOptionPane.showOptionDialog(window, "¿Estas seguro de quere borrar este empleado?", "Advertencia", JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null, new Object[] { "Aceptar", "Cancelar" }, null);
        if(selection==0){
            if(employee==null){
                employee=new Employee(dataEmp.id_employee);
            }
            employee.removeEmployee();
            window.update();
        }
    }//GEN-LAST:event_deleteButtonActionPerformed

    private EmployeeView window;
    private Employee employee;
    private DataEmployee dataEmp;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton editButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton showButton;
    // End of variables declaration//GEN-END:variables
}

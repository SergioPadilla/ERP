/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DataType.DataEmployee;
import DataType.DataTask;
import Utils.StatusTask;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.Time;
import java.util.Vector;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import sekegex.Task;
import sekegex.User;

/**
 *
 * @author Sergio
 */
public class ModifyTask extends javax.swing.JFrame {

    /**
     * Creates new form ModifyTask
     */
    public ModifyTask(DataTask task) {
        initComponents();
        idEmployees=new Vector();
        dateChooserCombo1.setCalendarPreferredSize(new Dimension(jButton1.getPreferredSize().width*8,dateChooserCombo1.getCalendarPreferredSize().height));
        this.setExtendedState(MAXIMIZED_BOTH);
        this.getContentPane().setBackground(Color.BLACK);
        this.setTitle("Modificar Tarea");
        this.task = task;
        
        usr = User.getInstance();        
        Vector employees = usr.listEmployees();
        idEmployees.add(0);
        for(int i = 0; i < employees.size(); i++){
            DataEmployee employee = (DataEmployee) employees.get(i);
            this.combo_employees.addItem(employee.name);
            idEmployees.add(employee.id_employee);
        }
        
        this.combo_employees.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox cb = (JComboBox)e.getSource();
                name = (String) cb.getSelectedItem();
            }
        });
        
        this.combo_status.addItem("Por hacer");
        this.combo_status.addItem("En desarrollo");
        this.combo_status.addItem("Terminada");
        
        this.combo_status.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox cb = (JComboBox)e.getSource();
                statusSelected = (String) cb.getSelectedItem();
            }
        });
        
        title.setText(task.title);
        description.setText(task.description);
        statusSelected="";
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        back_button = new javax.swing.JButton();
        combo_employees = new javax.swing.JComboBox<>();
        save_button = new javax.swing.JButton();
        due_date_label = new javax.swing.JLabel();
        title_label = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        description = new javax.swing.JTextArea();
        employee_label = new javax.swing.JLabel();
        title = new javax.swing.JTextField();
        description_label = new javax.swing.JLabel();
        status_label = new javax.swing.JLabel();
        combo_status = new javax.swing.JComboBox<>();
        dateChooserCombo1 = new datechooser.beans.DateChooserCombo();

        jButton1.setText("31");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        back_button.setText("Volver");
        back_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                back_buttonMouseClicked(evt);
            }
        });

        combo_employees.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "No modificar" }));

        save_button.setText("Guardar");
        save_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                save_buttonMouseClicked(evt);
            }
        });

        due_date_label.setBackground(new java.awt.Color(0, 0, 0));
        due_date_label.setForeground(new java.awt.Color(255, 255, 255));
        due_date_label.setText("Fecha final");

        title_label.setBackground(new java.awt.Color(0, 0, 0));
        title_label.setForeground(new java.awt.Color(255, 255, 255));
        title_label.setText("Título");

        description.setColumns(20);
        description.setRows(5);
        jScrollPane1.setViewportView(description);

        employee_label.setBackground(new java.awt.Color(0, 0, 0));
        employee_label.setForeground(new java.awt.Color(255, 255, 255));
        employee_label.setText("Asignar Empleado");

        description_label.setBackground(new java.awt.Color(0, 0, 0));
        description_label.setForeground(new java.awt.Color(255, 255, 255));
        description_label.setText("Descripción");

        status_label.setBackground(new java.awt.Color(0, 0, 0));
        status_label.setForeground(new java.awt.Color(255, 255, 255));
        status_label.setText("Estado");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(combo_status, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 395, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(back_button, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(save_button, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(dateChooserCombo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(employee_label)
                                    .addComponent(status_label)
                                    .addComponent(due_date_label))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(combo_employees, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(83, 453, Short.MAX_VALUE))))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(10, 10, 10)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(title)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 542, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(title_label)
                                .addComponent(description_label))
                            .addGap(0, 467, Short.MAX_VALUE)))
                    .addGap(11, 11, 11)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(199, 199, 199)
                .addComponent(due_date_label)
                .addGap(18, 18, 18)
                .addComponent(dateChooserCombo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(employee_label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(combo_employees, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(status_label)
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(save_button)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(back_button))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(combo_status, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 84, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(26, 26, 26)
                    .addComponent(title_label)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(description_label)
                    .addGap(18, 18, 18)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(265, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void back_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_back_buttonMouseClicked
        TaskView obj = new TaskView(this.task);
        obj.setSize(getSize());
        obj.setLocation(getLocation());
        obj.setVisible(true);
        dispose();
    }//GEN-LAST:event_back_buttonMouseClicked

    private void save_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_save_buttonMouseClicked
        String titlenew = title.getText().toString();
        String descriptionnew = description.getText().toString();
        Date date=new Date(dateChooserCombo1.getSelectedDate().getTimeInMillis());
        StatusTask status;
        
        //Check data and modify task
        if(titlenew.equals(this.task.title)){
            titlenew = "";
        }
        
        if(descriptionnew.equals(this.task.description)){
            descriptionnew = "";
        }
        
        if(this.statusSelected.equals("Por hacer")){
            status = StatusTask.TO_DO;
        }else if(this.statusSelected.equals("En desarrollo")){
            status = StatusTask.DEVELOPMENT;
        }else if(this.statusSelected.equals("Terminada")){
            status = StatusTask.DONE;
        }else{
            status = this.task.status;
        }
        int id=(int)idEmployees.elementAt(combo_employees.getSelectedIndex());
        Task task = new Task(this.task.id_task);
        if(task.modifyTask(titlenew, descriptionnew, date,id,status)){
            TaskView obj = new TaskView(this.task);
            obj.setSize(getSize());
            obj.setLocation(getLocation());
            obj.setVisible(true);
            dispose();
        }else{
            JOptionPane.showMessageDialog(this, "No tienes permisos para modificar tareas", "ERROR PERMISOS", JOptionPane.ERROR_MESSAGE);
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
            java.util.logging.Logger.getLogger(ModifyTask.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModifyTask.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModifyTask.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModifyTask.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModifyTask(task).setVisible(true);
            }
        });
    }
    
    public static DataTask task;
    private User usr;
    private String name;
    private String statusSelected;
    private Vector idEmployees;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back_button;
    private javax.swing.JComboBox<String> combo_employees;
    private javax.swing.JComboBox<String> combo_status;
    private datechooser.beans.DateChooserCombo dateChooserCombo1;
    private javax.swing.JTextArea description;
    private javax.swing.JLabel description_label;
    private javax.swing.JLabel due_date_label;
    private javax.swing.JLabel employee_label;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton save_button;
    private javax.swing.JLabel status_label;
    private javax.swing.JTextField title;
    private javax.swing.JLabel title_label;
    // End of variables declaration//GEN-END:variables
}

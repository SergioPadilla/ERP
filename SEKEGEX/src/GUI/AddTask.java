/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DataType.DataEmployee;
import DataType.DataTask;
import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.Time;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import sekegex.User;

/**
 *
 * @author Sergio
 */
public class AddTask extends javax.swing.JFrame {

    /**
     * Creates new form addTask
     */
    public AddTask() {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
        this.getContentPane().setBackground(Color.BLACK);

        dateChooserCombo1.setCalendarPreferredSize(new Dimension(jButton1.getPreferredSize().width*8,dateChooserCombo1.getCalendarPreferredSize().height));

        this.setTitle("Añadir Tarea");
        usr = User.getInstance();
        employees = usr.listEmployees();

        for(int i = 0; i < employees.size(); i++){
            DataEmployee employee = (DataEmployee) employees.get(i);
            combo_employees.addItem(employee.name);
        }

        this.combo_employees.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox cb = (JComboBox)e.getSource();
                name = (String) cb.getSelectedItem();
            }
        });
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
        title_label = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        description = new javax.swing.JTextArea();
        description_label = new javax.swing.JLabel();
        title = new javax.swing.JTextField();
        due_date_label = new javax.swing.JLabel();
        employee_label = new javax.swing.JLabel();
        combo_employees = new javax.swing.JComboBox<>();
        back_button = new javax.swing.JButton();
        new_button = new javax.swing.JButton();
        error_time = new javax.swing.JLabel();
        dateChooserCombo1 = new datechooser.beans.DateChooserCombo();

        jButton1.setText("21");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        title_label.setBackground(new java.awt.Color(0, 0, 0));
        title_label.setForeground(new java.awt.Color(255, 255, 255));
        title_label.setText("Título");

        description.setColumns(20);
        description.setRows(5);
        jScrollPane1.setViewportView(description);

        description_label.setBackground(new java.awt.Color(0, 0, 0));
        description_label.setForeground(new java.awt.Color(255, 255, 255));
        description_label.setText("Descripción");

        due_date_label.setBackground(new java.awt.Color(0, 0, 0));
        due_date_label.setForeground(new java.awt.Color(255, 255, 255));
        due_date_label.setText("Fecha final");

        employee_label.setBackground(new java.awt.Color(0, 0, 0));
        employee_label.setForeground(new java.awt.Color(255, 255, 255));
        employee_label.setText("Asignar Empleado");

        back_button.setText("Volver");
        back_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                back_buttonMouseClicked(evt);
            }
        });

        new_button.setText("Crear");
        new_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                new_buttonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(title))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 655, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(title_label)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(due_date_label)
                                        .addGap(53, 53, 53)
                                        .addComponent(error_time))
                                    .addComponent(description_label)
                                    .addComponent(combo_employees, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(employee_label)
                                    .addComponent(dateChooserCombo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(new_button, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(back_button)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(title_label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(description_label)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(due_date_label, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(error_time)
                        .addGap(18, 18, 18)
                        .addComponent(dateChooserCombo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(employee_label)
                        .addGap(18, 18, 18)
                        .addComponent(combo_employees, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 155, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(back_button)
                            .addComponent(new_button))
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void back_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_back_buttonMouseClicked
        if(this.id_task_father != 0){
            DataTask taskFather = usr.consultTask(this.id_task_father);
            TaskView obj = new TaskView(taskFather);
            obj.setSize(getSize());
            obj.setLocation(getLocation());
            obj.setVisible(true);
            dispose();
        } else{
            Workflow obj = new Workflow();
            obj.setSize(getSize());
            obj.setLocation(getLocation());
            obj.setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_back_buttonMouseClicked

    private void new_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_new_buttonMouseClicked
        String titlenew = title.getText();
        String descriptionnew = description.getText();

        /**
         * Checking Data and add task
         */
        if(titlenew.equals("")){
            JOptionPane.showMessageDialog(this, "El campo título no puede estar vacío", "Título Vacío", JOptionPane.ERROR_MESSAGE);
        }
        else if(descriptionnew.equals("")){
            JOptionPane.showMessageDialog(this, "El campo descripción no puede estar vacío", "Descripción Vacía", JOptionPane.ERROR_MESSAGE);
        }
        else{
            if(this.id_task_father != 0){
                Date date=new Date(dateChooserCombo1.getSelectedDate().getTimeInMillis());
                boolean encontrado=false;
                int id_employee=0;
                for(int i = 0; i < employees.size() && !encontrado; i++){
                    DataEmployee employee = (DataEmployee) employees.get(i);
                    encontrado=combo_employees.getSelectedItem().equals(employee.name);
                    id_employee=employee.id_employee;
                }
                if(usr.insertSubTask(titlenew, descriptionnew, date, id_employee, id_task_father)){
                    JOptionPane.showMessageDialog(this, "La tarea se ha creado con éxito", "Tarea Creada", JOptionPane.INFORMATION_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(this, "No tienes permisos para crear tareas", "ERROR PERMISOS", JOptionPane.ERROR_MESSAGE);
                }
            }else{
                Date date=new Date(dateChooserCombo1.getSelectedDate().getTimeInMillis());
                boolean encontrado=false;
                int id_employee=0;
                for(int i = 0; i < employees.size() && !encontrado; i++){
                    DataEmployee employee = (DataEmployee) employees.get(i);
                    encontrado=combo_employees.getSelectedItem().equals(employee.name);
                    id_employee=employee.id_employee;
                }
                if(usr.insertTask(titlenew, descriptionnew, date, id_employee)){
                    JOptionPane.showMessageDialog(this, "La tarea se ha creado con éxito", "Tarea Creada", JOptionPane.INFORMATION_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(this, "No tienes permisos para crear tareas", "ERROR PERMISOS", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_new_buttonMouseClicked

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
            java.util.logging.Logger.getLogger(AddTask.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddTask.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddTask.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddTask.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddTask().setVisible(true);
            }
        });
    }

    User usr;
    private String name;
    public int id_task_father = 0;
    Vector employees;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back_button;
    private javax.swing.JComboBox<String> combo_employees;
    private datechooser.beans.DateChooserCombo dateChooserCombo1;
    private javax.swing.JTextArea description;
    private javax.swing.JLabel description_label;
    private javax.swing.JLabel due_date_label;
    private javax.swing.JLabel employee_label;
    private javax.swing.JLabel error_time;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton new_button;
    private javax.swing.JTextField title;
    private javax.swing.JLabel title_label;
    // End of variables declaration//GEN-END:variables
}

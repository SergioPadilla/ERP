/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DataType.DataTask;
import java.awt.Color;
import java.util.Vector;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.ListModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import sekegex.MySQLTools;
import sekegex.Task;
import sekegex.User;

/**
 *
 * @author Sergio
 */
public class Workflow extends javax.swing.JFrame {

    /**
     * Creates new form workflow
     */
    public Workflow() {
        initComponents();
        this.getContentPane().setBackground(Color.BLACK);
        this.setTitle("Tareas");
        usr = User.getInstance();
        
        if(!usr.hasLicence(100))
            addTask.setVisible(false);
        
        //Get the tasks to show it
        tasks = usr.listTasks();
        
        //Create the model and add it the title of the task
        DefaultListModel model = new DefaultListModel();
        
        for(int i = 0; i < tasks.size(); i++){
            DataTask task =(DataTask) tasks.get(i);
            model.addElement(task.title);
        }
        
        listTasks.setModel(model);
        
        listTasks.addListSelectionListener(new ListSelectionListener(){
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int index = ((JList) e.getSource()).getSelectedIndex();
                
                TaskView obj = new TaskView((DataTask) tasks.get(index));
                obj.setVisible(true);
                dispose();
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

        jScrollPane = new javax.swing.JScrollPane();
        listTasks = new javax.swing.JList<>();
        addTask = new javax.swing.JButton();
        back_button = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        listTasks.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        listTasks.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        listTasks.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane.setViewportView(listTasks);

        addTask.setText("Nueva");
        addTask.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addTaskMouseClicked(evt);
            }
        });

        back_button.setText("Volver");
        back_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                back_buttonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(addTask)
                        .addGap(18, 18, 18)
                        .addComponent(back_button)
                        .addGap(0, 411, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addTask)
                    .addComponent(back_button))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addTaskMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addTaskMouseClicked
        AddTask obj = new AddTask();
        obj.setSize(getSize());
        obj.setLocation(getLocation());
        obj.setVisible(true);
        dispose();
    }//GEN-LAST:event_addTaskMouseClicked

    private void back_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_back_buttonMouseClicked
        MainMenu obj = new MainMenu();
        obj.setSize(getSize());
        obj.setLocation(getLocation());
        obj.setVisible(true);
        dispose();
    }//GEN-LAST:event_back_buttonMouseClicked

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
            java.util.logging.Logger.getLogger(Workflow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Workflow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Workflow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Workflow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Workflow().setVisible(true);
            }
        });
    }
    
    User usr; //Employee active
    Vector tasks; //List of the full tasks (DataTask)
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addTask;
    private javax.swing.JButton back_button;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JList<String> listTasks;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DataType.DataComment;
import DataType.DataTask;
import Utils.StatusTask;
import java.awt.Color;
import java.util.Vector;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import sekegex.User;

/**
 *
 * @author Sergio
 */
public class TaskView extends javax.swing.JFrame {

    /**
     * Creates new form TaskView
     */
    public TaskView(DataTask task) {
        initComponents();
        this.task = task;
        this.setTitle("Tarea");
        this.getContentPane().setBackground(Color.BLUE);
        usr = User.getInstance();
        update();
    }
    
    public TaskView(int task){
        initComponents();
        usr = User.getInstance();
        this.task = usr.consultTask(task);
        this.setTitle("Tarea");
        this.getContentPane().setBackground(Color.BLUE);
        update();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        title = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        description = new javax.swing.JTextArea();
        hour_estimated_label = new javax.swing.JLabel();
        hour_estimated_bar = new javax.swing.JProgressBar();
        hour_worked_label = new javax.swing.JLabel();
        hour_worked_bar = new javax.swing.JProgressBar();
        hour_remaining_label = new javax.swing.JLabel();
        hour_remaining_bar = new javax.swing.JProgressBar();
        jScrollPane2 = new javax.swing.JScrollPane();
        subTasks_list = new javax.swing.JList<>();
        subtasks_label = new javax.swing.JLabel();
        newSubTask_button = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        comments_label = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        comments_list = new javax.swing.JList<>();
        addComment_button = new javax.swing.JButton();
        back_button = new javax.swing.JButton();
        modify_button = new javax.swing.JButton();
        updateTask = new javax.swing.JButton();
        workLog_button = new javax.swing.JButton();
        status_label = new javax.swing.JLabel();
        status = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 102, 255));

        title.setBackground(new java.awt.Color(51, 102, 255));
        title.setFont(new java.awt.Font("AppleGothic", 0, 18)); // NOI18N
        title.setForeground(new java.awt.Color(255, 255, 255));
        title.setText("Título");

        description.setEditable(false);
        description.setColumns(20);
        description.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        description.setRows(5);
        jScrollPane1.setViewportView(description);

        hour_estimated_label.setBackground(new java.awt.Color(51, 102, 255));
        hour_estimated_label.setForeground(new java.awt.Color(255, 255, 255));
        hour_estimated_label.setText("Horas Estimadas");

        hour_worked_label.setBackground(new java.awt.Color(51, 102, 255));
        hour_worked_label.setForeground(new java.awt.Color(255, 255, 255));
        hour_worked_label.setText("Horas Trabajadas");

        hour_remaining_label.setBackground(new java.awt.Color(51, 102, 255));
        hour_remaining_label.setForeground(new java.awt.Color(255, 255, 255));
        hour_remaining_label.setText("Horas Restantes");

        subTasks_list.setBackground(new java.awt.Color(51, 153, 255));
        subTasks_list.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(subTasks_list);

        subtasks_label.setBackground(new java.awt.Color(51, 102, 255));
        subtasks_label.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        subtasks_label.setForeground(new java.awt.Color(255, 255, 255));
        subtasks_label.setText("SubTareas");

        newSubTask_button.setText("Crear Subtarea");
        newSubTask_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                newSubTask_buttonMouseClicked(evt);
            }
        });

        comments_label.setBackground(new java.awt.Color(51, 102, 255));
        comments_label.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        comments_label.setForeground(new java.awt.Color(255, 255, 255));
        comments_label.setText("Comentarios");

        jScrollPane3.setBackground(new java.awt.Color(51, 153, 255));

        comments_list.setBackground(new java.awt.Color(51, 153, 255));
        comments_list.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane3.setViewportView(comments_list);

        addComment_button.setText("Nuevo Comentario");
        addComment_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addComment_buttonMouseClicked(evt);
            }
        });

        back_button.setText("Atrás");
        back_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                back_buttonMouseClicked(evt);
            }
        });

        modify_button.setText("Modificar");
        modify_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                modify_buttonMouseClicked(evt);
            }
        });

        updateTask.setText("Actualizar");
        updateTask.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updateTaskMouseClicked(evt);
            }
        });

        workLog_button.setText("Registros de trabajo");
        workLog_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                workLog_buttonMouseClicked(evt);
            }
        });

        status_label.setBackground(new java.awt.Color(51, 102, 255));
        status_label.setForeground(new java.awt.Color(255, 255, 255));
        status_label.setText("ESTADO");

        status.setBackground(new java.awt.Color(51, 153, 255));
        status.setForeground(new java.awt.Color(255, 255, 255));
        status.setText("jLabel2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(newSubTask_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addComponent(jSeparator1)
                    .addComponent(jSeparator2)
                    .addComponent(jScrollPane3)
                    .addComponent(addComment_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(subtasks_label, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comments_label))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(modify_button, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(workLog_button)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(back_button, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(updateTask))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(title, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1022, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(hour_remaining_label)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(hour_estimated_bar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(hour_estimated_label)
                                        .addComponent(hour_worked_label))
                                    .addComponent(hour_worked_bar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(hour_remaining_bar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(status_label)
                            .addComponent(status))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(status_label)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(status)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(hour_estimated_label)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(hour_estimated_bar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(hour_worked_label)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(hour_worked_bar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(hour_remaining_label)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(hour_remaining_bar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(subtasks_label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(newSubTask_button)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comments_label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addComment_button)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(modify_button)
                    .addComponent(back_button)
                    .addComponent(workLog_button)
                    .addComponent(updateTask))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void newSubTask_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_newSubTask_buttonMouseClicked
        AddTask obj = new AddTask();
        obj.id_task_father = task.id_task;
        obj.setVisible(true);
        dispose();
    }//GEN-LAST:event_newSubTask_buttonMouseClicked

    private void addComment_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addComment_buttonMouseClicked
        AddComment obj = new AddComment(task.id_task);
        obj.setVisible(true);
        dispose();
    }//GEN-LAST:event_addComment_buttonMouseClicked

    private void back_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_back_buttonMouseClicked
        if(this.task.id_task_father != 0){
            DataTask taskFather = usr.consultTask(this.task.id_task_father);
            TaskView obj = new TaskView(taskFather);
            obj.setVisible(true);
            dispose();
        }else{
            Workflow obj = new Workflow();
            obj.setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_back_buttonMouseClicked

    private void modify_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_modify_buttonMouseClicked
        ModifyTask obj = new ModifyTask(this.task);
        obj.setVisible(true);
        dispose();
    }//GEN-LAST:event_modify_buttonMouseClicked

    private void updateTaskMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateTaskMouseClicked
        update();
    }//GEN-LAST:event_updateTaskMouseClicked

    private void workLog_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_workLog_buttonMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_workLog_buttonMouseClicked

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
            java.util.logging.Logger.getLogger(TaskView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TaskView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TaskView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TaskView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TaskView(task).setVisible(true);
            }
        });
    }
    
    private void update(){
        this.task = usr.consultTask(this.task.id_task);

        this.title.setText(task.title);
        this.description.setText(task.description);
        
        if(this.task.status == StatusTask.TO_DO){
            this.status.setText("Por hacer");
        } else if(this.task.status == StatusTask.DEVELOPMENT){
            this.status.setText("En desarrollo");
        } else if(this.task.status == StatusTask.DONE){
            this.status.setText("Terminada");
        }

        //Get the comments to show it
        subTasks = usr.listSubTasks(task.id_task);
        
        //Create the model and add it the title of the task
        DefaultListModel model = new DefaultListModel();
        
        for(int i = 0; i < subTasks.size(); i++){
            DataTask subtask =(DataTask) subTasks.get(i);
            model.addElement(subtask.title);
        }
        
        this.subTasks_list.setModel(model);
        
        this.subTasks_list.addListSelectionListener(new ListSelectionListener(){
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int index = ((JList) e.getSource()).getSelectedIndex();
                
                TaskView obj = new TaskView((DataTask) subTasks.get(index));
                obj.setVisible(true);
                dispose();
            }
        });
        
        //Get the comments of the task to show it
        comments = usr.listComments(task.id_task);
        
        //Create the model and add it the title of the task
        DefaultListModel modelc = new DefaultListModel();
        
        for(int i = 0; i < comments.size(); i++){
            DataTask comment =(DataTask) comments.get(i);
            model.addElement(comment.title);
        }
        
        this.comments_list.setModel(modelc);
        
        this.comments_list.addListSelectionListener(new ListSelectionListener(){
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int index = ((JList) e.getSource()).getSelectedIndex();
                
                CommentView obj = new CommentView((DataComment) comments.get(index));
                obj.setVisible(true);
                dispose();
            }
        });
    }

    public static DataTask task;
    private User usr;
    Vector subTasks;
    Vector comments;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addComment_button;
    private javax.swing.JButton back_button;
    private javax.swing.JLabel comments_label;
    private javax.swing.JList<String> comments_list;
    private javax.swing.JTextArea description;
    private javax.swing.JProgressBar hour_estimated_bar;
    private javax.swing.JLabel hour_estimated_label;
    private javax.swing.JProgressBar hour_remaining_bar;
    private javax.swing.JLabel hour_remaining_label;
    private javax.swing.JProgressBar hour_worked_bar;
    private javax.swing.JLabel hour_worked_label;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JButton modify_button;
    private javax.swing.JButton newSubTask_button;
    private javax.swing.JLabel status;
    private javax.swing.JLabel status_label;
    private javax.swing.JList<String> subTasks_list;
    private javax.swing.JLabel subtasks_label;
    private javax.swing.JLabel title;
    private javax.swing.JButton updateTask;
    private javax.swing.JButton workLog_button;
    // End of variables declaration//GEN-END:variables
}

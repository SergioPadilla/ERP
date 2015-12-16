/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sekegex;

import Utils.StatusTask;
import DataType.DataTask;
import java.sql.Date;
import java.sql.Time;


/**
 *
 * @author Sergio
 */
public class Task {
    private DataTask data;
    MySQLTools DB = MySQLTools.getInstance();

    
    public Task(int id_task){
        data = consultTask(id_task);
    }
    
    /**
     * Call the DB and consult the information for the task specified
     * @param id_task
     * @return Full atributes of task
     */
    public DataTask consultTask(int id_task){
        return DB.consultTask(id_task);
    }
    
    public void update(){
        data=consultTask(data.id_task);
    }
    
    /**
     * Modify task
     */
    public void modifyTask(int id_task, String title, String description, Time time_estimated, Date due_date, int id_task_father, int id_employee, StatusTask status){
        
    }
    
    /**
     * Erase task
     */
    public void eraseTask(int id_task){
        
    }
    
}

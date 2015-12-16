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
    private User activeEmployee = User.getInstance();
    private static MySQLTools DB = MySQLTools.getInstance();
    private DataTask data;

    
    public Task(int id_task){
        data = activeEmployee.consultTask(id_task);
    }
        
    public void update(){
        data=DB.consultTask(getData().id_task);
    }
    
    /**
     * Modify task
     * @param title
     * @param description
     * @param time_estimated
     * @param due_date
     * @param status
     */
    public void modifyTask(String title, String description, Time time_estimated, Date due_date, StatusTask status){
        if (activeEmployee.hasLicence(102)){
            DB.modifyTask(getData().id_task, title, description, time_estimated, due_date, getData().id_task_father, getData().id_employee, status);
        }
    }
    
    /**
     * Erase task
     */
    public void eraseTask(){
        if (activeEmployee.hasLicence(201)){
            DB.eraseTask(getData().id_task);
        }

    }

    /**
     * @return the data
     */
    public DataTask getData() {
        return data;
    }
    
}

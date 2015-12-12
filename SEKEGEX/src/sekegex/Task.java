/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sekegex;

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
    
    public Task(int id_task){
        data = consultTask(id_task);
    }
    
    /**
     * Call the DB and consult the information for the task specified
     * @param id_task
     * @return Full atributes of task
     */
    public DataTask consultTask(int id_task){
        return data; //Esto va fuera, hay que llamar a la DB
    }
    
    /**
     * Change the title of the task
     * @param title 
     */
    public void modifyTitle(String title){
        data.title = title;
        //LLamar al método de PLSQLTools para modificar una tarea
    }
    
    /**
     * Change the due_date of the task
     * @param date 
     */
    public void modifyDueDate(Date date){
        data.due_date = date;
        //LLamar al método de PLSQLTools para modificar una tarea
    }
    
    /**
     * Change the task father of the task
     * @param id 
     */
    public void modifyIdTaskFather(int id){
        data.id_task_father = id;
        //LLamar al método de PLSQLTools para modificar una tarea
    }
    
    /**
     * Change the time estimated to complete the task
     * @param time 
     */
    public void modifyTimeEstimated(Time time){
        data.time_estimated = time;
        //LLamar al método de PLSQLTools para modificar una tarea
    }
    
    /**
     * Change the employee assigned to this task
     * @param id 
     */
    public void modifyIdEmployee(int id){
        data.id_employee = id;
        //LLamar al método de PLSQLTools para modificar una tarea
    }
    
    /**
     * Change the status of the task
     * @param status 
     */
    public void modifyStatus(StatusTask status){
        data.status = status;
        //LLamar al método de PLSQLTools para modificar una tarea
    }
    
    /**
     * Change the description of the task
     * @param description 
     */
    public void modifyDescription(String description){
        data.description = description;
        //LLamar al método de PLSQLTools para modificar una tarea
    }
}

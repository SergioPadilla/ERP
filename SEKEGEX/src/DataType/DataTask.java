/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataType;

import java.sql.Date;
import java.sql.Time;
import sekegex.StatusTask;

/**
 *
 * @author Sergio
 */
public class DataTask {
    public int id_task;
    public String title;
    public Date due_date;
    public int id_task_father;
    public Time time_estimated;
    public int id_employee;
    public StatusTask status;
    public String description;
    
    public DataTask(int id_task, String title, Date due_date, int id_task_father, Time time_estimated, int id_employee, StatusTask status, String description){
        this.id_task = id_task;
        this.title = title;
        this.due_date = due_date;
        this.id_task_father = id_task_father;
        this.time_estimated = time_estimated;
        this.id_employee = id_employee;
        this.status = status;
        this.description = description;
    }
}
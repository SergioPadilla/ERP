/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataType;

/**
 *
 * @author Sergio
 */
public class DataComment {
    public int id_comment;
    public String text;
    public int id_task;
    public int id_employee;
    
    public DataComment(int id_comment, String text, int id_task,int id_employee){
        this.id_comment = id_comment;
        this.id_task = id_task;
        this.id_employee = id_employee;
        this.text = text;
    }

    public DataComment(DataComment c) {
        this.id_comment = c.id_comment;
        this.id_task = c.id_task;
        this.id_employee = c.id_employee;
        this.text = c.text;
    }
}
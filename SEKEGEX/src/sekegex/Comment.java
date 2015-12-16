/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sekegex;
import DataType.DataComment;
/**
 *
 * @author jopime
 */
public class Comment {
    private User activeEmployee = User.getInstance();
    private static MySQLTools DB = MySQLTools.getInstance();
    private DataComment data;
    
    public Comment(int id_comment){
        data = activeEmployee.consultComment(id_comment);
    }
        
    public void update(){
        data=activeEmployee.consultComment(data.id_comment);
    }
    /**
     * Change the text of the comment
     * @param text 
     */
    public void modifyComment(String text){
        if (activeEmployee.hasLicence(202)){
            DB.modifyComment(data.id_comment, data.id_task, text);
        } //consideramos que solo se puede modificar el texto no las id
    }
    
    /**
     * Erase Comment
     */
    public void removeComment(int id_comment){
        if (activeEmployee.hasLicence(201)){
            DB.removeComment(id_comment);
        } //consideramos que solo se puede modificar el texto no las id
    }
}

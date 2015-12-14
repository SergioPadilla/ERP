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
    private DataComment data;
    
    public Comment(int id_task){
        data = consultComment(id_task);
    }
    
    /**
     * Call the DB and consult the information for the comment specified
     * @param id_comment
     * @return Full atributes of comment
     */
    public DataComment consultComment(int id_task){
        return data; //Esto va fuera, hay que llamar a la DB
    }
    
    /**
     * Change the text of the comment
     * @param text 
     */
    public void modifyComment(String text){
        data.text = text;
        //LLamar al método de PLSQLTools para modificar un comentario
    }
}

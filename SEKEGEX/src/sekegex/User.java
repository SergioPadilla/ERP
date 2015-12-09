/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sekegex;

/**
 *
 * @author Ivan
 */
public class User {
    private static final User instance = new User();
    private boolean active;
    private int id_employee;
    private String dni;
    private String name;
    private String surname;
    //private int licence;
    
    
    private User(){
        active=false;
    }
    
    public static User getInstance(){
        return instance;
    }
    
    /*
    Comprueba si el user y el pass esta en la base de datos si esta 
    se pasan todos los datos a los atributos de la clase y pone activo a true
    */
    public boolean login(String user,String pass){
        
        return false;
    }
    
    /*
    Borra todos los atributos y pone activo a false
    */
    public void logOut(){
        
    }
    
    /*
    Devuelve si hay o no alguien logeado o no
    */
    public boolean isLogin(){
        return active;
    }
    
    public String getName(){
        if(active)
            return name;
        else
            return "Usuario no registrado";
    }
    
    public String getSurname(){
        if(active)
            return surname;
        else
            return "Usuario no registrado";
    }
    
    public int getId(){
        if(active)
            return id_employee;
        else
            return 0;
    }
    
    public String getDni(){
        if(active)
            return dni;
        else
            return "Usuario no registrado";
    }
    
    //Aquí funcionalidades
    
    
}

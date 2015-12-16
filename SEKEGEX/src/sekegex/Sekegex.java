/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sekegex;

import DataType.*;
import java.util.*;


/**
 *
 * @author Sergio Padilla López
 * @author Iván Calle Gil
 * @author Marina Estévez Almenzar
 * @author Jose Pimentel Mesones
 *
 */
public class Sekegex {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        User activeEmployee=User.getInstance();
        MySQLTools DB=MySQLTools.getInstance();
        Scanner sc = new Scanner(System.in);
        String dni;
        String pass;
        String opc,opcC;
        while(true){
            while(!activeEmployee.isLogin()){
                System.out.print("Dni: ");
                dni = sc.nextLine();
                System.out.print("contraseña: ");
                pass = sc.nextLine();
                if(!activeEmployee.login(dni, pass)){
                    System.out.println("Error de autentificación");
                }
            }
            System.out.println("opciones: \n "
                    + "x-->desconectar\n"
                    + "c-->Clientes");
            System.out.print("opción: ");
            opc = sc.nextLine();
            if(opc.equals("x")){
                activeEmployee.logOut();
            }
            if(opc.equals("c")){
                Vector clients=DB.listClients();
                for(int i=0; i<clients.size();i++){
                    DataClient clienti=(DataClient)clients.elementAt(i);
                    System.out.println(clienti.id+"-->"+clienti.name+" "+clienti.surname);
                }
                System.out.println("opciones de cliente: \n "
                    + "i-->Insertar\n"
                    + "m-->Modificar\n"
                    + "v-->Ver cliente");
                System.out.print("opción: ");
                opcC = sc.nextLine();
                if(opcC.equals("v")){
                    System.out.print("Id: ");
                    int Id = sc.nextInt();
                    sc.nextLine();
                    DataClient client=DB.consultClient(Id);
                    System.out.println("Id: "+Id);
                    System.out.println("Nombre: "+client.name);
                    System.out.println("Apellidos: "+client.surname);
                    System.out.println("nif: "+client.dni);
                    System.out.println("email: "+client.email);
                    System.out.println("fecha de alta: "+client.registration);
                }else if(opcC.equals("m") || opcC.equals("i")){
                    System.out.print("nombre: ");
                    String name = sc.nextLine();
                    System.out.print("apellidos: ");
                    String surname = sc.nextLine();
                    System.out.print("tipo: ");
                    String type = sc.nextLine();
                    System.out.print("nif: ");
                    String nif = sc.nextLine();
                    System.out.print("email: ");
                    String email = sc.nextLine();
                    
                
                }
            }
            opc=null;
            opcC=null;
       }
    }
    
}

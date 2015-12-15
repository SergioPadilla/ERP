/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sekegex;

import MySQL.MySQLTools;
import java.util.Scanner;

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
        Scanner sc = new Scanner(System.in);
        System.out.print("Dni: ");
        String dni = sc.nextLine();
        System.out.print("contraseña: ");
        String pass = sc.nextLine();
        while(!activeEmployee.login(dni, pass)){
            System.out.println("Error de autentificación");
            System.out.print("Dni: ");
            dni = sc.nextLine();
            System.out.print("contraseña: ");
            pass = sc.nextLine();
        }
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sekegex;

import DataType.*;
import Utils.TypeClient;
import java.sql.Date;
import Utils.StatusTask;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.util.Arrays;
import java.util.Vector;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Base64;
/**
 *
 * @author Sergio
 * 
 * Class to work with MySQL
 */
public class MySQLTools {
    
    private static final MySQLTools instance = new MySQLTools();
    private static String sDriver = "com.mysql.jdbc.Driver";
    private static String sURL = "jdbc:mysql://85.10.205.173:3306/erpseke";
    private static String user="sekegex";
    private static String pass="sekegex";
    //private static String sURL = "jdbc:mysql://85.10.205.173:3306/erpseke";
    private MySQLTools(){}
    
    public static MySQLTools getInstance(){
        return instance;
    }
    //Encrypting functions
    
    private static String encrypt(String text) {
 
        String secretKey = "97f8c8e8a2802a"; //llave para encriptar datos
        String base64EncryptedString = "";
 
        try {
 
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digestOfPassword = md.digest(secretKey.getBytes("utf-8"));
            byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);
 
            SecretKey key = new SecretKeySpec(keyBytes, "DESede");
            Cipher cipher = Cipher.getInstance("DESede");
            cipher.init(Cipher.ENCRYPT_MODE, key);
 
            byte[] plainTextBytes = text.getBytes("utf-8");
            byte[] buf = cipher.doFinal(plainTextBytes);
            byte[] base64Bytes = Base64.encodeBase64(buf);
            base64EncryptedString = new String(base64Bytes);
 
        } catch (Exception ex) {
        }
        return base64EncryptedString;
}
    
    private static String decrypt(String textEncrypted) throws Exception {
 
        String secretKey = "97f8c8e8a2802a"; 
        String base64EncryptedString = "";
 
        try {
            byte[] message = Base64.decodeBase64(textEncrypted.getBytes("utf-8"));
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digestOfPassword = md.digest(secretKey.getBytes("utf-8"));
            byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);
            SecretKey key = new SecretKeySpec(keyBytes, "DESede");
 
            Cipher decipher = Cipher.getInstance("DESede");
            decipher.init(Cipher.DECRYPT_MODE, key);
 
            byte[] plainText = decipher.doFinal(message);
 
            base64EncryptedString = new String(plainText, "UTF-8");
 
        } catch (Exception ex) {
        }
        return base64EncryptedString;
}
    
    private static String toHexadecimal(byte[] digest){
        String hash = "";
        for(byte aux : digest) {
            int b = aux & 0xff;
            if (Integer.toHexString(b).length() == 1) hash += "0";
            hash += Integer.toHexString(b);
        }
        return hash;
    }
    
    public static String encryptSHA(String message){
        byte[] digest = null;
        byte[] buffer = message.getBytes();
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-512");
            messageDigest.reset();
            messageDigest.update(buffer);
            digest = messageDigest.digest();
        } catch (NoSuchAlgorithmException ex) {
            System.out.println("Error creando Digest");
        }
        return toHexadecimal(digest);
    }

    //END Encrypting functions
    
    public static void install(){
        Connection con = null;
        PreparedStatement stmt = null;

        try{
           Class.forName(sDriver).newInstance();    
           con = DriverManager.getConnection(sURL,user,pass);
           
           stmt = con.prepareStatement("CREATE TABLE clientes (id_cliente INT NOT NULL PRIMARY KEY AUTO_INCREMENT, tipo ENUM('FREELANCE', 'BUSINESS'),nombre TEXT, apellido TEXT, nif varchar(10) UNIQUE , email TEXT, fecha_alta DATETIME)");
           stmt.executeUpdate();
           stmt = con.prepareStatement("CREATE TABLE productos (id_producto INT NOT NULL PRIMARY KEY AUTO_INCREMENT, nombre TEXT,  descripcion TEXT,  importe FLOAT, ventas INT DEFAULT 0)");
           stmt.executeUpdate();
           stmt = con.prepareStatement("CREATE TABLE facturas (id_factura INT NOT NULL PRIMARY KEY AUTO_INCREMENT, fecha DATETIME, id_cliente INT REFERENCES clientes (id_cliente))");
           stmt.executeUpdate();
           stmt = con.prepareStatement("CREATE TABLE compras (id_producto INT REFERENCES productos (id_producto), id_factura INT REFERENCES facturas (id_factura),precio FLOAT, PRIMARY KEY(id_producto,id_factura))");
           stmt.executeUpdate();
           stmt = con.prepareStatement("CREATE TABLE servidores (id_servidor INT NOT NULL PRIMARY KEY AUTO_INCREMENT, id_cliente INT REFERENCES clientes (id_cliente), nombre TEXT,  ruta_de_acceso TEXT, usuario_ftp TEXT, password_ftp TEXT, usuario_host TEXT, password_host TEXT)");
           stmt.executeUpdate();
           stmt = con.prepareStatement("CREATE TABLE dominios (id_dominio INT NOT NULL PRIMARY KEY AUTO_INCREMENT, id_servidor INT REFERENCES servidores (id_servidor), web TEXT)");
           stmt.executeUpdate();
           stmt = con.prepareStatement("CREATE TABLE empleados (id_empleado INT NOT NULL PRIMARY KEY AUTO_INCREMENT, dni varchar(9) UNIQUE NOT NULL,  nombre TEXT, password TEXT, apellidos TEXT, rol INT)");
           stmt.executeUpdate();
           stmt = con.prepareStatement("CREATE TABLE tareas (id_tarea INT NOT NULL PRIMARY KEY AUTO_INCREMENT,titulo TEXT, fecha DATE, id_tarea_padre INT, horas_estimadas TIME, empleado_asignado INT REFERENCES empleados (id_empleado), estado ENUM('TO_DO', 'DEVELOPMENT', 'DONE'), descripcion TEXT)");
           stmt.executeUpdate();
           stmt = con.prepareStatement("CREATE TABLE registros (id_registro INT NOT NULL PRIMARY KEY AUTO_INCREMENT, id_empleado INT REFERENCES empleados (id_empleado), horas_trabajadas TIME, descripcion TEXT, fecha DATE)");
           stmt.executeUpdate();
           stmt = con.prepareStatement("CREATE TABLE comentarios (id_comentario INT NOT NULL PRIMARY KEY AUTO_INCREMENT, texto TEXT, tarea INT REFERENCES tareas (id_tarea))");
           stmt.executeUpdate(); 
           stmt = con.prepareStatement("CREATE TABLE rol (rol INT NOT NULL , permiso INT, PRIMARY KEY(rol,permiso))");
           stmt.executeUpdate();
           stmt = con.prepareStatement("INSERT INTO rol (rol, permiso) VALUES(1,100)");
           stmt.executeUpdate();
           stmt = con.prepareStatement("INSERT INTO rol (rol, permiso) VALUES(1,101)");
           stmt.executeUpdate();
           stmt = con.prepareStatement("INSERT INTO rol (rol, permiso) VALUES(1,102)");
           stmt.executeUpdate();
           stmt = con.prepareStatement("INSERT INTO rol (rol, permiso) VALUES(1,103)");
           stmt.executeUpdate();
           stmt = con.prepareStatement("INSERT INTO rol (rol, permiso) VALUES(1,200)");
           stmt.executeUpdate();
           stmt = con.prepareStatement("INSERT INTO rol (rol, permiso) VALUES(1,201)");
           stmt.executeUpdate();
           stmt = con.prepareStatement("INSERT INTO rol (rol, permiso) VALUES(1,202)");
           stmt.executeUpdate();
           stmt = con.prepareStatement("INSERT INTO rol (rol, permiso) VALUES(1,203)");
           stmt.executeUpdate();
           stmt = con.prepareStatement("INSERT INTO rol (rol, permiso) VALUES(1,300)");
           stmt.executeUpdate();
           stmt = con.prepareStatement("INSERT INTO rol (rol, permiso) VALUES(1,301)");
           stmt.executeUpdate();
           stmt = con.prepareStatement("INSERT INTO rol (rol, permiso) VALUES(1,302)");
           stmt.executeUpdate();
           stmt = con.prepareStatement("INSERT INTO rol (rol, permiso) VALUES(1,303)");
           stmt.executeUpdate();
           stmt = con.prepareStatement("INSERT INTO rol (rol, permiso) VALUES(1,400)");
           stmt.executeUpdate();
           stmt = con.prepareStatement("INSERT INTO rol (rol, permiso) VALUES(1,401)");
           stmt.executeUpdate();
           stmt = con.prepareStatement("INSERT INTO rol (rol, permiso) VALUES(1,402)");
           stmt.executeUpdate();
           stmt = con.prepareStatement("INSERT INTO rol (rol, permiso) VALUES(1,403)");
           stmt.executeUpdate();
           stmt = con.prepareStatement("INSERT INTO rol (rol, permiso) VALUES(1,500)");
           stmt.executeUpdate();
           stmt = con.prepareStatement("INSERT INTO rol (rol, permiso) VALUES(1,501)");
           stmt.executeUpdate();
           stmt = con.prepareStatement("INSERT INTO rol (rol, permiso) VALUES(1,502)");
           stmt.executeUpdate();
           stmt = con.prepareStatement("INSERT INTO rol (rol, permiso) VALUES(1,503)");
           stmt.executeUpdate();
           stmt = con.prepareStatement("INSERT INTO rol (rol, permiso) VALUES(1,600)");
           stmt.executeUpdate();
           stmt = con.prepareStatement("INSERT INTO rol (rol, permiso) VALUES(1,601)");
           stmt.executeUpdate();
           stmt = con.prepareStatement("INSERT INTO rol (rol, permiso) VALUES(1,602)");
           stmt.executeUpdate();
           stmt = con.prepareStatement("INSERT INTO rol (rol, permiso) VALUES(1,603)");
           stmt.executeUpdate();
           stmt = con.prepareStatement("INSERT INTO rol (rol, permiso) VALUES(1,700)");
           stmt.executeUpdate();
           stmt = con.prepareStatement("INSERT INTO rol (rol, permiso) VALUES(1,701)");
           stmt.executeUpdate();
           stmt = con.prepareStatement("INSERT INTO rol (rol, permiso) VALUES(1,702)");
           stmt.executeUpdate();
           stmt = con.prepareStatement("INSERT INTO rol (rol, permiso) VALUES(1,703)");
           stmt.executeUpdate();
           stmt = con.prepareStatement("INSERT INTO rol (rol, permiso) VALUES(1,800)");
           stmt.executeUpdate();
           stmt = con.prepareStatement("INSERT INTO rol (rol, permiso) VALUES(1,801)");
           stmt.executeUpdate();
           stmt = con.prepareStatement("INSERT INTO rol (rol, permiso) VALUES(1,802)");
           stmt.executeUpdate();
           stmt = con.prepareStatement("INSERT INTO rol (rol, permiso) VALUES(1,803)");
           stmt.executeUpdate();
           stmt = con.prepareStatement("INSERT INTO rol (rol, permiso) VALUES(1,900)");
           stmt.executeUpdate();
           stmt = con.prepareStatement("INSERT INTO rol (rol, permiso) VALUES(1,901)");
           stmt.executeUpdate();
           stmt = con.prepareStatement("INSERT INTO rol (rol, permiso) VALUES(1,902)");
           stmt.executeUpdate();
           stmt = con.prepareStatement("INSERT INTO rol (rol, permiso) VALUES(1,903)");
           stmt.executeUpdate();
           stmt = con.prepareStatement("INSERT INTO empleados (id_empleado , dni,  nombre, password, apellidos, rol) VALUES (NULL,'root','Admin','cf83e1357eefb8bdf1542850d66d8007d620e4050b5715dc83f4a921d36ce9ce47d0d13c5d85f2b0ff8318d2877eec2f63b931bd47417a81a538327af927da3e','',1)");
           stmt.executeUpdate();
           

        } catch (SQLException sqle){
           System.out.println("SQLState: " 
              + sqle.getSQLState());
           System.out.println("SQLErrorCode: " 
              + sqle.getErrorCode());
           sqle.printStackTrace();
        } catch (Exception e){
           e.printStackTrace();
        } finally {
           if (con != null) {
              try{
                 stmt.close();
                 con.close();
              } catch(Exception e){
                 e.printStackTrace();
              }
           }
        }
    }
    
    //"CLIENTES" table
    
    /**
     * Insert new client in the table
     */
    boolean insertClient(String type, String name, String surname, String dni, String email){
        Connection con = null;
        PreparedStatement stmt = null;
        boolean res=false;
        try{
           Class.forName(sDriver).newInstance();    
           con = DriverManager.getConnection(sURL,user,pass);
           
           stmt = con.prepareStatement("INSERT INTO clientes (tipo, nombre, apellido, nif, email,fecha_alta) VALUES(?,?,?,?,?,UTC_TIMESTAMP());");
           
           stmt.setString(1, type);
           stmt.setString(2, name);
           stmt.setString(3, surname);
           stmt.setString(4, dni);
           stmt.setString(5, email);
           
           res=stmt.execute();

        } catch (SQLException sqle){
           System.out.println("SQLState: " + sqle.getSQLState());
           System.out.println("SQLErrorCode: " + sqle.getErrorCode());
           sqle.printStackTrace();
        } catch (Exception e){
           e.printStackTrace();
        } finally {
           if (con != null) {
              try{
                 stmt.close();
                 con.close();
              } catch(Exception e){
                 e.printStackTrace();
              }
           }
        }
        return res;
    }
    
    /**
     * Modify client with the params specified
     */
     boolean modifyClient(int id_client, String type, String name, String surname, String dni, String email){
        Connection con = null;
        PreparedStatement stmt = null;
        boolean res=false;

        try{
           Class.forName(sDriver).newInstance();    
           con = DriverManager.getConnection(sURL,user,pass);
           String query="UPDATE clientes SET ";
           boolean first=true;
           
           if(!type.equals("")){
               query +="tipo='"+type+"'";
               first=false;
           }
           if(!name.equals("")){
               if(!first){
                   query +=",";
               }
               query +="nombre='"+name+"'";
               first=false;
           }
           if(!surname.equals("")){
               if(!first){
                   query +=",";
               }
               query +="apellidos='"+surname+"'";
               first=false;
           }
           if(!dni.equals("")){
               if(!first){
                   query +=",";
               }
               query +="nif='"+dni+"'";
               first=false;
           }
           if(!email.equals("")){
               if(!first){
                   query +=",";
               }
               query +="email='"+email+"'";
               first=false;
           }
           query +=" WHERE id_cliente="+id_client;
           
           //"UPDATE clientes SET tipo = ? nombre = ? apellido = ? nif = ? email = ? WHERE id_cliente = ?"
           stmt = con.prepareStatement(query);
           
           res=stmt.execute();

        } catch (SQLException sqle){
           System.out.println("SQLState: " + sqle.getSQLState());
           System.out.println("SQLErrorCode: " + sqle.getErrorCode());
           sqle.printStackTrace();
        } catch (Exception e){
           e.printStackTrace();
        } finally {
           if (con != null) {
              try{
                 stmt.close();
                 con.close();
              } catch(Exception e){
                 e.printStackTrace();
              }
           }
        }
        return res;
    }
    
    /**
     * Get the data of the client with id specified
     * @param id_client
     * @return 
     */
    DataClient consultClient(int id_client){
        Connection con = null;
        PreparedStatement stmt = null;
        TypeClient type=null;
        String name=null;
        String surname=null;
        String nif=null;
        String email=null;
        Date date=null;

        try{
            Class.forName(sDriver).newInstance();    
            con = DriverManager.getConnection(sURL,user,pass);
            stmt = con.prepareStatement("SELECT * FROM clientes WHERE id_cliente='"+id_client+"'");
            
            ResultSet rs;
            rs = stmt.executeQuery();
            
             if (rs.next()) {
                type=TypeClient.valueOf(rs.getString("tipo"));
                name=rs.getString("nombre");
                surname=rs.getString("apellido");
                nif=rs.getString("nif");
                email=rs.getString("email");
                date=rs.getDate("fecha_alta");
            }

        } catch (SQLException sqle){
            System.out.println("SQLState: " + sqle.getSQLState());
            System.out.println("SQLErrorCode: " + sqle.getErrorCode());
            sqle.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            if (con != null) {
              try{
                 stmt.close();
                 con.close();
              } catch(Exception e){
                 e.printStackTrace();
              }
            }
            return new DataClient(id_client,type,name,surname,nif,email,date);
        }
    }
    
    /**
     * 
     * @param id_client
     * @return List of bills of the cliente specified by id
     */
    public Vector listBills(int id_client){
        Connection con = null;
        PreparedStatement stmt = null;
        Vector res=new Vector();
        int id_bill;
        Date date;

        try{
            Class.forName(sDriver).newInstance();    
            con = DriverManager.getConnection(sURL,user,pass);
            stmt = con.prepareStatement("SELECT * FROM facturas WHERE id_cliente="+id_client);
            
            ResultSet rs;
            rs = stmt.executeQuery();
            
             while (rs.next()) {
                id_bill=rs.getInt("id_factura");
                date=rs.getDate("fecha_alta");
                res.addElement(new DataBill(id_bill,id_client,date));
            }

        } catch (SQLException sqle){
            System.out.println("SQLState: " + sqle.getSQLState());
            System.out.println("SQLErrorCode: " + sqle.getErrorCode());
            sqle.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            if (con != null) {
              try{
                 stmt.close();
                 con.close();
              } catch(Exception e){
                 e.printStackTrace();
              }
            }
            return res;
        }
    }
    
    /**
     * Remove client
     */
     void removeClient(int id_client){
        
    }
    
    Vector listClients(){
        Connection con = null;
        PreparedStatement stmt = null;
        int id_product=-1;
        String name=null;
        String description=null;
        float amount=0;
        int nSold=-1;
        Vector res=new Vector();

        try{
            Class.forName(sDriver).newInstance();    
            con = DriverManager.getConnection(sURL,user,pass);
            stmt = con.prepareStatement("SELECT * FROM productos");
            
            ResultSet rs;
            rs = stmt.executeQuery();
            
             while (rs.next()) {
                id_product=rs.getInt("id_producto");
                name=rs.getString("nombre");
                description=rs.getString("descripcion");
                amount=rs.getFloat("importe");
                nSold=rs.getInt("ventas");
                res.addElement(new DataProduct(id_product,name,description,amount,nSold));
            }

        } catch (SQLException sqle){
            System.out.println("SQLState: " + sqle.getSQLState());
            System.out.println("SQLErrorCode: " + sqle.getErrorCode());
            sqle.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            if (con != null) {
              try{
                 stmt.close();
                 con.close();
              } catch(Exception e){
                 e.printStackTrace();
              }
            }
            return res;
        }
    }
    
    //"PRODUCTOS" table
    
    /**
     * Insert new product in the table
     */
     void insertProduct(String name, String description, float amount){
        Connection con = null;
        PreparedStatement stmt = null;

        try{
           Class.forName(sDriver).newInstance();    
           con = DriverManager.getConnection(sURL,user,pass);
           
           stmt = con.prepareStatement("INSERT INTO produtos (nombre, descripcion, importe) VALUES(?,?,?);");
           
           stmt.setString(1, name);
           stmt.setString(2, description);
           stmt.setFloat(3, amount);
           
           stmt.executeUpdate();

        } catch (SQLException sqle){
           System.out.println("SQLState: " + sqle.getSQLState());
           System.out.println("SQLErrorCode: " + sqle.getErrorCode());
           sqle.printStackTrace();
        } catch (Exception e){
           e.printStackTrace();
        } finally {
           if (con != null) {
              try{
                 stmt.close();
                 con.close();
              } catch(Exception e){
                 e.printStackTrace();
              }
           }
        }
    }
    
    /**
     * Modify product
     */
     void modifyProduct(int id_product, String name, String description, float amount){
        Connection con = null;
        PreparedStatement stmt = null;

        try{
           Class.forName(sDriver).newInstance();    
           con = DriverManager.getConnection(sURL,user,pass);
           
           stmt = con.prepareStatement("UPDATE productos SET nombre = ? descripcion = ? importe = ? WHERE id_producto = ?");
           
           stmt.setString(1,name);
           stmt.setString(2,description);
           stmt.setFloat(3, amount);
           stmt.setInt(4,id_product);
           
           stmt.executeUpdate();

        } catch (SQLException sqle){
           System.out.println("SQLState: " + sqle.getSQLState());
           System.out.println("SQLErrorCode: " + sqle.getErrorCode());
           sqle.printStackTrace();
        } catch (Exception e){
           e.printStackTrace();
        } finally {
           if (con != null) {
              try{
                 stmt.close();
                 con.close();
              } catch(Exception e){
                 e.printStackTrace();
              }
           }
        }
    }
    
    Vector listProducts(){
        Connection con = null;
        PreparedStatement stmt = null;
        int id_task=-1;
        String title=null;
        Date due_date=null;
        int id_task_father=-1;
        Time time_estimated=null;
        int id_employee=-1;
        StatusTask status=null;
        String description=null;
        Vector res=null;

        try{
            Class.forName(sDriver).newInstance();    
            con = DriverManager.getConnection(sURL,user,pass);
            stmt = con.prepareStatement("SELECT * FROM tareas");
            
            ResultSet rs;
            rs = stmt.executeQuery();
            
             while (rs.next()) {
                id_task=rs.getInt("id_tarea");
                status=StatusTask.valueOf(rs.getString("estado"));
                title=rs.getString("titulo");
                id_task_father=rs.getInt("id_tarea_padre");
                due_date=rs.getDate("fecha");
                time_estimated=rs.getTime("horas_estimadas");
                id_employee=rs.getInt("empleado_asignado");
                description=rs.getString("descripcion");            
                res.addElement(new DataTask(id_task, title, due_date, id_task_father, time_estimated, id_employee, status, description));
            }

        } catch (SQLException sqle){
            System.out.println("SQLState: " + sqle.getSQLState());
            System.out.println("SQLErrorCode: " + sqle.getErrorCode());
            sqle.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            if (con != null) {
              try{
                 stmt.close();
                 con.close();
              } catch(Exception e){
                 e.printStackTrace();
              }
            }
            return res;
        }
    }
     
     
    /**
     * Update the purchases of the product with id specified
     * @param id_product 
     */
     void updatePurchases(int id_product){
        
    }
    
    /**
     * Consult Product
     * @return Object with the data of a product
     */
    public DataProduct consultProduct(int id_product){
        Connection con = null;
        PreparedStatement stmt = null;
        String name=null;
        String description=null;
        float amount=0;
        int nSold=0;

        try{
            Class.forName(sDriver).newInstance();    
            con = DriverManager.getConnection(sURL,user,pass);
            stmt = con.prepareStatement("SELECT * FROM productos WHERE id_producto='"+id_product+"'");
            
            ResultSet rs;
            rs = stmt.executeQuery();
            
             if (rs.next()) {
                name=rs.getString("nombre");;
                description=rs.getString("descripcion");
                amount=rs.getFloat("importe");
                nSold=rs.getInt("ventas");;
            }

        } catch (SQLException sqle){
            System.out.println("SQLState: " + sqle.getSQLState());
            System.out.println("SQLErrorCode: " + sqle.getErrorCode());
            sqle.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            if (con != null) {
              try{
                 stmt.close();
                 con.close();
              } catch(Exception e){
                 e.printStackTrace();
              }
            }
            return new DataProduct(id_product,name,description,amount,nSold);
        }
    }
    
    /**
     * Remove Product
     */
     void removeProduct(int id_product){
        
    }
    
    //"FACTURAS" table
    
    /**
     * Insert new bill in the table
     */
     int insertBill(int id_client){
        Connection con = null;
        PreparedStatement stmt = null;
        int Id=0;
        try{
           Class.forName(sDriver).newInstance();    
           con = DriverManager.getConnection(sURL,user,pass);
           String[] returnId = { "BATCHID" };
           stmt = con.prepareStatement("INSERT INTO facturas (id_cliente,fecha) VALUES(?,UTC_TIMESTAMP());",returnId);
           
           stmt.setInt(1, id_client);
           
           stmt.executeUpdate();
           try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    Id=rs.getInt(1);
                }
                rs.close();
           }
        } catch (SQLException sqle){
           System.out.println("SQLState: " + sqle.getSQLState());
           System.out.println("SQLErrorCode: " + sqle.getErrorCode());
           sqle.printStackTrace();
        } catch (Exception e){
           e.printStackTrace();
        } finally {
           if (con != null) {
              try{
                 stmt.close();
                 con.close();
              } catch(Exception e){
                 e.printStackTrace();
              }
           }
           return Id;
        }
    }
    
    /**
     * Modify bill
     */
     void modifyBill(int id_bill, float amount, int id_client){
        Connection con = null;
        PreparedStatement stmt = null;

        try{
           Class.forName(sDriver).newInstance();    
           con = DriverManager.getConnection(sURL,user,pass);
           
           stmt = con.prepareStatement("UPDATE facturas SET id_cliente = ? importe = ? WHERE id_factura = ?");
           
           stmt.setInt(1, id_client);
           stmt.setFloat(2,amount);
           stmt.setInt(3,id_bill);
           
           stmt.executeUpdate();

        } catch (SQLException sqle){
           System.out.println("SQLState: " + sqle.getSQLState());
           System.out.println("SQLErrorCode: " + sqle.getErrorCode());
           sqle.printStackTrace();
        } catch (Exception e){
           e.printStackTrace();
        } finally {
           if (con != null) {
              try{
                 stmt.close();
                 con.close();
              } catch(Exception e){
                 e.printStackTrace();
              }
           }
        }
    }
    
    /**
     * Remove bill
     */
     void removeBill(int id_bill){
        
    }
    
    //"COMPRAS" table
    
    /**
     * Insert new bill in the table
     */
     void insertPurchase(int id_bill, int id_product){
        Connection con = null;
        PreparedStatement stmt = null;

        try{
           Class.forName(sDriver).newInstance();    
           con = DriverManager.getConnection(sURL,user,pass);
           DataProduct P=consultProduct(id_product);
           stmt = con.prepareStatement("INSERT INTO compras (id_factura, id_producto,precio) VALUES(?,?,"+P.amount+");");
           
           stmt.setInt(1, id_bill);
           stmt.setInt(2, id_product);
           
           stmt.executeUpdate();
           
            

        } catch (SQLException sqle){
           System.out.println("SQLState: " + sqle.getSQLState());
           System.out.println("SQLErrorCode: " + sqle.getErrorCode());
           sqle.printStackTrace();
        } catch (Exception e){
           e.printStackTrace();
        } finally {
           if (con != null) {
              try{
                 stmt.close();
                 con.close();
              } catch(Exception e){
                 e.printStackTrace();
              }
           }
        }
    }
    
    /**
     * Erase a product of a purchase
     */
    void removeProductOfPurchase(int id_bill, int id_product){
        
    }
    
    //"SERVIDORES" table
    
    /**
     * Insert new server
     */
    void insertServer(int id_client, String name, String access, String user_ftp, String password_ftp, String user_host, String password_host){
        Connection con = null;
        PreparedStatement stmt = null;

        try{
           Class.forName(sDriver).newInstance();    
           con = DriverManager.getConnection(sURL,user,pass);
           
           stmt = con.prepareStatement("INSERT INTO servidores (id_cliente, nombre, ruta_de_acceso, usuario_ftp, password_ftp, usuario_host, password_host) VALUES(?,?,?,?,?,?,?);");
           
           stmt.setInt(1, id_client);
           stmt.setString(2, name);
           stmt.setString(3, access);
           stmt.setString(4, user_ftp);
           stmt.setString(5, password_ftp);
           stmt.setString(6, user_host);
           stmt.setString(7, password_host);
           
           stmt.executeUpdate();

        } catch (SQLException sqle){
           System.out.println("SQLState: " + sqle.getSQLState());
           System.out.println("SQLErrorCode: " + sqle.getErrorCode());
           sqle.printStackTrace();
        } catch (Exception e){
           e.printStackTrace();
        } finally {
           if (con != null) {
              try{
                 stmt.close();
                 con.close();
              } catch(Exception e){
                 e.printStackTrace();
              }
           }
        }
    }
    
    /**
     * Modify server
     */
    void modifyServer(int id_server, int id_client, String name, String access, String user_ftp, String password_ftp, String user_host, String password_host){
        Connection con = null;
        PreparedStatement stmt = null;

        try{
           Class.forName(sDriver).newInstance();    
           con = DriverManager.getConnection(sURL,user,pass);
           
           stmt = con.prepareStatement("UPDATE servidores SET nombre = ? ruta_de_acceso = ? usuario_ftp = ? password_ftp = ? usuario_host = ? password_host = ? id_cliente = ? WHERE id_servidor = ?");
           
           stmt.setString(1,name);
           stmt.setString(2,access);
           stmt.setString(3, user_ftp);
           stmt.setString(4, password_ftp);
           stmt.setString(5, user_host);
           stmt.setString(6, password_host);
           stmt.setInt(7, id_client);
           stmt.setInt(8, id_server);
           
           stmt.executeUpdate();

        } catch (SQLException sqle){
           System.out.println("SQLState: " + sqle.getSQLState());
           System.out.println("SQLErrorCode: " + sqle.getErrorCode());
           sqle.printStackTrace();
        } catch (Exception e){
           e.printStackTrace();
        } finally {
           if (con != null) {
              try{
                 stmt.close();
                 con.close();
              } catch(Exception e){
                 e.printStackTrace();
              }
           }
        }
    }
    
    /**
     * 
     * @param id_client
     * @return List with the servers for the client with id specified
     */
    public Vector listServers(int id_client){
        Connection con = null;
        PreparedStatement stmt = null;
        Vector res=new Vector();
        int id_server;
        String name;
        String ip;
        String user_ftp;
        String pass_ftp;
        String user_host;
        String pass_host;

        try{
            Class.forName(sDriver).newInstance();    
            con = DriverManager.getConnection(sURL,user,pass);
            stmt = con.prepareStatement("SELECT * FROM servidores WHERE id_cliente="+id_client);
            
            ResultSet rs;
            rs = stmt.executeQuery();
            
             while (rs.next()){
                id_server=rs.getInt("id_servidor");
                name=rs.getString("nombre");
                ip=rs.getString("ruta_de_acceso");
                user_ftp=rs.getString("usuario_ftp");
                pass_ftp=decrypt(rs.getString("password_ftp"));
                user_host=rs.getString("usuario_host");
                pass_host=decrypt(rs.getString("password_host"));
                res.addElement(new DataServer(id_server,id_client,name,ip,user_ftp, pass_ftp,user_host,pass_host));
            }

        } catch (SQLException sqle){
            System.out.println("SQLState: " + sqle.getSQLState());
            System.out.println("SQLErrorCode: " + sqle.getErrorCode());
            sqle.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            if (con != null) {
              try{
                 stmt.close();
                 con.close();
              } catch(Exception e){
                 e.printStackTrace();
              }
            }
            return res;
        }
    }
    
   
    
    /**
     * Erase server
     */
    void removeServer(int id_server){
        
    }
    
    //"EMPLEADOS" table
    
    /**
     * Insert new employee
     */
    void insertEmployee(String dni, String name, String surname, int role){
        Connection con = null;
        PreparedStatement stmt = null;

        try{
           Class.forName(sDriver).newInstance();    
           con = DriverManager.getConnection(sURL,user,pass);
           
           stmt = con.prepareStatement("INSERT INTO empleados (dni, nombre, apellidos, rol) VALUES(?,?,?,?);");
           
           stmt.setString(1, dni);
           stmt.setString(2, name);
           stmt.setString(3, surname);
           stmt.setInt(4, role);


           
           stmt.executeUpdate();

        } catch (SQLException sqle){
           System.out.println("SQLState: " + sqle.getSQLState());
           System.out.println("SQLErrorCode: " + sqle.getErrorCode());
           sqle.printStackTrace();
        } catch (Exception e){
           e.printStackTrace();
        } finally {
           if (con != null) {
              try{
                 stmt.close();
                 con.close();
              } catch(Exception e){
                 e.printStackTrace();
              }
           }
        }
    }
    
    /**
     * Modify employee
     */
    void modifyEmployee(int id_employee, String dni, String name, String surname, int role){
        Connection con = null;
        PreparedStatement stmt = null;

        try{
           Class.forName(sDriver).newInstance();    
           con = DriverManager.getConnection(sURL,user,pass);
           
           stmt = con.prepareStatement("UPDATE empleados SET dni = ? nombre = ? apellidos = ? rol = ? WHERE id_empleado = ?");
           
           stmt.setString(1,dni);
           stmt.setString(2,name);
           stmt.setString(3, surname);
           stmt.setInt(4, role);
           stmt.setInt(5, id_employee);
           
           stmt.executeUpdate();

        } catch (SQLException sqle){
           System.out.println("SQLState: " + sqle.getSQLState());
           System.out.println("SQLErrorCode: " + sqle.getErrorCode());
           sqle.printStackTrace();
        } catch (Exception e){
           e.printStackTrace();
        } finally {
           if (con != null) {
              try{
                 stmt.close();
                 con.close();
              } catch(Exception e){
                 e.printStackTrace();
              }
           }
        }
    }
    
    /**
     * Erase employee
     */
    void removeEmployee(int id_employee){
        
    }
    
    /**
     * Get employee with dni specified
     * @param dni
     * @return 
     */
    public DataEmployee consultEmployee(String dni){
        Connection con = null;
        PreparedStatement stmt = null;
        int id_employee = -1;
        String name = null;
        String surname = null;
        int role = -1;
        String password = null;

        try{
            Class.forName(sDriver).newInstance();    
            con = DriverManager.getConnection(sURL,user,pass);
            stmt = con.prepareStatement("SELECT * FROM empleados WHERE dni='"+dni+"'");
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                id_employee=rs.getInt("id_empleado");
                name=rs.getString("nombre");
                surname=rs.getString("apellidos");
                role=rs.getInt("rol");
                password=rs.getString("password");
            }

        } catch (SQLException sqle){
            System.out.println("SQLState: " + sqle.getSQLState());
            System.out.println("SQLErrorCode: " + sqle.getErrorCode());
            sqle.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            if (con != null) {
              try{
                 stmt.close();
                 con.close();
              } catch(Exception e){
                 e.printStackTrace();
              }
            }
        }

        return new DataEmployee(id_employee, name, dni, password, surname, role);
    }
    
    /**
     * Get employee with id specified
     * @param id_employee
     * @return 
     */
    public DataEmployee consultEmployee(int id_employee){
        Connection con = null;
        PreparedStatement stmt = null;
        String name = null;
        String surname = null;
        int role = -1;
        String password = null;
        String dni = null;
        
       try{
            Class.forName(sDriver).newInstance();    
            con = DriverManager.getConnection(sURL,user,pass);
            stmt = con.prepareStatement("SELECT * FROM empleados WHERE id_empleado='"+id_employee+"'");
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                dni=rs.getString("dni");
                name=rs.getString("nombre");
                surname=rs.getString("apellidos");
                role=rs.getInt("rol");
                password=rs.getString("password");
            }

        } catch (SQLException sqle){
            System.out.println("SQLState: " + sqle.getSQLState());
            System.out.println("SQLErrorCode: " + sqle.getErrorCode());
            sqle.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            if (con != null) {
              try{
                 stmt.close();
                 con.close();
              } catch(Exception e){
                 e.printStackTrace();
              }
            }
        }
 
        
        return new DataEmployee(id_employee, name, dni, password, surname, role);
    }
    
    //"TAREAS" table
    
    /**
     * Insert new task
     */
    void insertTask(String title, String description, Time time_estimated){
        Connection con = null;
        PreparedStatement stmt = null;

        try{
           Class.forName(sDriver).newInstance();    
           con = DriverManager.getConnection(sURL,user,pass);
           
           stmt = con.prepareStatement("INSERT INTO tareas (titulo, descripcion, horas_estimadas) VALUES(?,?,?);");
           
           stmt.setString(1, title);
           stmt.setString(2, description);
           stmt.setTime(3, time_estimated);
       
           stmt.executeUpdate();

        } catch (SQLException sqle){
           System.out.println("SQLState: " + sqle.getSQLState());
           System.out.println("SQLErrorCode: " + sqle.getErrorCode());
           sqle.printStackTrace();
        } catch (Exception e){
           e.printStackTrace();
        } finally {
           if (con != null) {
              try{
                 stmt.close();
                 con.close();
              } catch(Exception e){
                 e.printStackTrace();
              }
           }
        }
    }
    
    
        Vector listTasks(){
        Connection con = null;
        PreparedStatement stmt = null;
        int id_task=-1;
        String title=null;
        Date due_date=null;
        int id_task_father=-1;
        Time time_estimated=null;
        int id_employee=-1;
        StatusTask status=null;
        String description=null;
        Vector res=null;

        try{
            Class.forName(sDriver).newInstance();    
            con = DriverManager.getConnection(sURL,user,pass);
            stmt = con.prepareStatement("SELECT * FROM tareas");
            
            ResultSet rs;
            rs = stmt.executeQuery();
            
             while (rs.next()) {
                id_task=rs.getInt("id_tarea");
                status=StatusTask.valueOf(rs.getString("estado"));
                title=rs.getString("titulo");
                id_task_father=rs.getInt("id_tarea_padre");
                due_date=rs.getDate("fecha");
                time_estimated=rs.getTime("horas_estimadas");
                id_employee=rs.getInt("empleado_asignado");
                description=rs.getString("descripcion");            
                res.addElement(new DataTask(id_task, title, due_date, id_task_father, time_estimated, id_employee, status, description));
            }

        } catch (SQLException sqle){
            System.out.println("SQLState: " + sqle.getSQLState());
            System.out.println("SQLErrorCode: " + sqle.getErrorCode());
            sqle.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            if (con != null) {
              try{
                 stmt.close();
                 con.close();
              } catch(Exception e){
                 e.printStackTrace();
              }
            }
            return res;
        }
    }
    
    /**
     * Modify task
     */
    void modifyTask(int id_task, String title, String description, Time time_estimated, Date due_date, int id_task_father, int id_employee, StatusTask status){
        Connection con = null;
        PreparedStatement stmt = null;

        try{
           Class.forName(sDriver).newInstance();    
           con = DriverManager.getConnection(sURL,user,pass);
           
           stmt = con.prepareStatement("UPDATE tareas SET titulo = ? descripcion = ? horas_estimadas = ? fecha = ? id_tarea_padre = ? empleado_asignado = ? estado = ? WHERE id_tareas = ?");
          
           stmt.setString(1,title);
           stmt.setString(2,description);
           stmt.setTime(3, time_estimated);
           stmt.setDate(4, due_date);
           stmt.setInt(5, id_task_father);
           stmt.setInt(6, id_employee);
           stmt.setObject(7, status);
           stmt.setInt(8, id_task);
           
           stmt.executeUpdate();

        } catch (SQLException sqle){
           System.out.println("SQLState: " + sqle.getSQLState());
           System.out.println("SQLErrorCode: " + sqle.getErrorCode());
           sqle.printStackTrace();
        } catch (Exception e){
           e.printStackTrace();
        } finally {
           if (con != null) {
              try{
                 stmt.close();
                 con.close();
              } catch(Exception e){
                 e.printStackTrace();
              }
           }
        }
    }
    
    /**
     * Get the data of the task with id specified
     * @param id_task
     * @return 
     */
    public DataTask consultTask(int id_task){
        Connection con = null;
        PreparedStatement stmt = null;
        String title = null;
        Date due_date = new Date(1,1,1);
        int id_task_father = -1;
        Time time_estimated = new Time(1,1,1);
        int id_employee = -1;
        StatusTask status = StatusTask.TO_DO;
        String description = null;
        
        try{
            Class.forName(sDriver).newInstance();    
            con = DriverManager.getConnection(sURL,user,pass);
            stmt = con.prepareStatement("SELECT * FROM empleados WHERE id_tarea='"+id_task+"'");
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                title=rs.getString("titulo");
                due_date=rs.getDate("fecha");
                id_task_father=rs.getInt("id_tatea_padre");
                time_estimated=rs.getTime("horas_estimadas");
                id_employee=rs.getInt("empleado_asignado");
                status=StatusTask.valueOf(rs.getString("estado"));
                description=rs.getString("descripcion");

            }

        } catch (SQLException sqle){
            System.out.println("SQLState: " + sqle.getSQLState());
            System.out.println("SQLErrorCode: " + sqle.getErrorCode());
            sqle.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            if (con != null) {
              try{
                 stmt.close();
                 con.close();
              } catch(Exception e){
                 e.printStackTrace();
              }
            }
        }
        
        return new DataTask(id_task, title, due_date, id_task_father, time_estimated, id_employee, status, description);
    }
    
    /**
     * Erase task
     */
    void eraseTask(int id_task){
        
    }
    
    //"REGISTROS" table
    
    /**
     * Insert new register
     */
    void insertRegister(int id_employee, Time time_worked, String description, Date date){
        Connection con = null;
        PreparedStatement stmt = null;

        try{
           Class.forName(sDriver).newInstance();    
           con = DriverManager.getConnection(sURL,user,pass);
           
           stmt = con.prepareStatement("INSERT INTO registros (id_empleado, horas_trabajadas, descripcion, fecha) VALUES(?,?,?,?);");
           
           stmt.setInt(1, id_employee);
           stmt.setTime(2, time_worked);
           stmt.setString(3, description);
           stmt.setDate(4, date);

           stmt.executeUpdate();

        } catch (SQLException sqle){
           System.out.println("SQLState: " + sqle.getSQLState());
           System.out.println("SQLErrorCode: " + sqle.getErrorCode());
           sqle.printStackTrace();
        } catch (Exception e){
           e.printStackTrace();
        } finally {
           if (con != null) {
              try{
                 stmt.close();
                 con.close();
              } catch(Exception e){
                 e.printStackTrace();
              }
           }
        }
    }
    
    /**
     * Modify register
     */
    void modifyRegister(int id_register, int id_employee, Time time_worked, String description, Date date){
        Connection con = null;
        PreparedStatement stmt = null;

        try{
           Class.forName(sDriver).newInstance();    
           con = DriverManager.getConnection(sURL,user,pass);
           
           stmt = con.prepareStatement("UPDATE registros SET id_empleado = ? horas_trabajadas = ? descripcion = ? fecha = ? WHERE id_registro = ?");
           
           stmt.setInt(1,id_employee);
           stmt.setObject(2,time_worked);
           stmt.setString(3, description);
           stmt.setObject(4, date);
           stmt.setInt(5, id_register);
           
           stmt.executeUpdate();

        } catch (SQLException sqle){
           System.out.println("SQLState: " + sqle.getSQLState());
           System.out.println("SQLErrorCode: " + sqle.getErrorCode());
           sqle.printStackTrace();
        } catch (Exception e){
           e.printStackTrace();
        } finally {
           if (con != null) {
              try{
                 stmt.close();
                 con.close();
              } catch(Exception e){
                 e.printStackTrace();
              }
           }
        }
    }
    
    /**
     * Erase register
     */
    void removeRegister(int id_register){
        
    }
    
    //"COMENTARIOS" table
    
    /**
     * Insert Comment
     */
    void insertComment(int id_tarea, String comment){
        Connection con = null;
        PreparedStatement stmt = null;

        try{
           Class.forName(sDriver).newInstance();    
           con = DriverManager.getConnection(sURL,user,pass);
           
           stmt = con.prepareStatement("INSERT INTO comentarios (tarea, texto) VALUES(?,?);");
           
           stmt.setInt(1, id_tarea);
           stmt.setString(2, comment);

           stmt.executeUpdate();

        } catch (SQLException sqle){
           System.out.println("SQLState: " + sqle.getSQLState());
           System.out.println("SQLErrorCode: " + sqle.getErrorCode());
           sqle.printStackTrace();
        } catch (Exception e){
           e.printStackTrace();
        } finally {
           if (con != null) {
              try{
                 stmt.close();
                 con.close();
              } catch(Exception e){
                 e.printStackTrace();
              }
           }
        }
    }
    
    /**
     * Modify Comment
     */
    void modifyComment(int id_comment, int id_tarea, String comment){
        Connection con = null;
        PreparedStatement stmt = null;

        try{
           Class.forName(sDriver).newInstance();    
           con = DriverManager.getConnection(sURL,user,pass);
           
           stmt = con.prepareStatement("UPDATE comentarios SET texto = ? tarea = ? WHERE id_comentario = ?");
           
           stmt.setString(1,comment);
           stmt.setInt(2,id_tarea);
           stmt.setInt(3, id_comment);
           
           stmt.executeUpdate();

        } catch (SQLException sqle){
           System.out.println("SQLState: " + sqle.getSQLState());
           System.out.println("SQLErrorCode: " + sqle.getErrorCode());
           sqle.printStackTrace();
        } catch (Exception e){
           e.printStackTrace();
        } finally {
           if (con != null) {
              try{
                 stmt.close();
                 con.close();
              } catch(Exception e){
                 e.printStackTrace();
              }
           }
        }
    }
    
    /**
     * Erase Comment
     */
    void removeComment(int id_comment){
        
    }
    
    // "ROLES" table
    
    /**
     * Insert Role
     */
    void insertRole(int rol, int licence){
        Connection con = null;
        PreparedStatement stmt = null;

        try{
           Class.forName(sDriver).newInstance();    
           con = DriverManager.getConnection(sURL,user,pass);
           
           stmt = con.prepareStatement("INSERT INTO roles (rol, permiso) VALUES(?,?);");
           
           stmt.setInt(1, rol);
           stmt.setInt(2, licence);

           stmt.executeUpdate();

        } catch (SQLException sqle){
           System.out.println("SQLState: " + sqle.getSQLState());
           System.out.println("SQLErrorCode: " + sqle.getErrorCode());
           sqle.printStackTrace();
        } catch (Exception e){
           e.printStackTrace();
        } finally {
           if (con != null) {
              try{
                 stmt.close();
                 con.close();
              } catch(Exception e){
                 e.printStackTrace();
              }
           }
        }
    }
    
    /**
     * Modify Role
     */
    void modifyRole(int rol, int licence){
        
    }
    
    /**
     * 
     * @param rol
     * @return List of licences permitied for this role
     */
    public Vector consultRole(int rol){
        Connection con = null;
        PreparedStatement stmt = null;

        Vector res=new Vector();

        try{
            Class.forName(sDriver).newInstance();    
            con = DriverManager.getConnection(sURL,user,pass);
            stmt = con.prepareStatement("SELECT permiso FROM rol WHERE rol = '"+rol+"'");
            
            ResultSet rs;
            rs = stmt.executeQuery();
            
             while (rs.next()) {
                res.addElement(rs.getInt("permiso"));
            }

        } catch (SQLException sqle){
            System.out.println("SQLState: " + sqle.getSQLState());
            System.out.println("SQLErrorCode: " + sqle.getErrorCode());
            sqle.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            if (con != null) {
              try{
                 stmt.close();
                 con.close();
              } catch(Exception e){
                 e.printStackTrace();
              }
            }
            return res;
        }
    }
    
    /**
     * Erase Role
     */
    void removeRole(int rol){
        
    }
    
    //"DOMINIOS" table
    
    /**
     * Insert domain
     */
    void insertDomain(int id_server, String web){
        Connection con = null;
        PreparedStatement stmt = null;

        try{
           Class.forName(sDriver).newInstance();    
           con = DriverManager.getConnection(sURL,user,pass);
           
           stmt = con.prepareStatement("INSERT INTO dominios (id_servidor, web) VALUES(?,?);");
           
           stmt.setInt(1, id_server);
           stmt.setString(2, web);

           stmt.executeUpdate();

        } catch (SQLException sqle){
           System.out.println("SQLState: " + sqle.getSQLState());
           System.out.println("SQLErrorCode: " + sqle.getErrorCode());
           sqle.printStackTrace();
        } catch (Exception e){
           e.printStackTrace();
        } finally {
           if (con != null) {
              try{
                 stmt.close();
                 con.close();
              } catch(Exception e){
                 e.printStackTrace();
              }
           }
        }
    }
     /**
     * list domain 
     * @param id_server
     */
    Vector lisDomains(int id_server){
        Connection con = null;
        PreparedStatement stmt = null;
        int id_domain=-1;   
        String name=null;
        Vector res=new Vector();

        try{
            Class.forName(sDriver).newInstance();    
            con = DriverManager.getConnection(sURL,user,pass);
            stmt = con.prepareStatement("SELECT * FROM dominios WHERE id_servidor='"+id_server+"'");

            
            ResultSet rs;
            rs = stmt.executeQuery();
            
             while (rs.next()) {
                id_domain=rs.getInt("id_dominio");
                name=rs.getString("web");
                res.addElement(new DataDomain(id_server,id_domain,name));
            }

        } catch (SQLException sqle){
            System.out.println("SQLState: " + sqle.getSQLState());
            System.out.println("SQLErrorCode: " + sqle.getErrorCode());
            sqle.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            if (con != null) {
              try{
                 stmt.close();
                 con.close();
              } catch(Exception e){
                 e.printStackTrace();
              }
            }
            return res;
        }
    }
    
    /**
     * Erase domain
     */
    void removeDomain(int id_domain){
        
    }
}

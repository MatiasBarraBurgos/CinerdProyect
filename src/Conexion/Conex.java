
package Conexion;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
        
public class Conex {
    Connection cn;
        
public Connection ConectarBD() {
    try{
        Class.forName("com.mysql.jdbc.Driver");
        cn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost/CinerdProyect","root","");
        System.out.println("conexion exitosa");
    }catch (ClassNotFoundException | SQLException e) { 
        System.out.println("conexion fallida"+e);
    }
    return cn;
}   

}


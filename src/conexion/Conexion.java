
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    public Connection obtenerConexion(){
        Connection conec = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conec = DriverManager.getConnection("jdbc:mysql://localhost:3306/libreria","root","");
            System.out.println("Conexion exitosa!");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error en conexion "+ e.getMessage());
        }
        return conec;
    }    

}



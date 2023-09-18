
package accesoADatos;

import java.sql.*;
import javax.swing.JOptionPane;

public class Conexion {
    
    private static final String URL = "jdbc:mariadb://localhost/";
    private static final String BD = "universidadgrupo14";
    private static final String USUARIO= "root";
    private static final String PASSWORD= "";
    private static Connection connection;
    
    private Conexion (){}
    
    public static Connection getConexion(){
        
        if (connection == null){
            
            try {
                Class.forName("org.mariadb.jdbc.Driver");
                connection = DriverManager.getConnection(URL+BD, USUARIO, PASSWORD);
                
                
                
            } catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "Error al cargar los Driver.");
            } catch (SQLException ex) {
               JOptionPane.showMessageDialog(null, "Error al conectarse a la base de datos.");
            }
            
        }
        return connection;
        
    }
    
}

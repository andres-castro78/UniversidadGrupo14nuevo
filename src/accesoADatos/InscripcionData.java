
package accesoADatos;

import entidades.Alumno;
import entidades.Inscripcion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class InscripcionData {
    
    private Connection con = null;
    private MateriaData matData;
    private AlumnoData aluData;
    
    public InscripcionData() {
        con = Conexion.getConexion();
  
    }
    
    //Cargar datos (INSERT)
    public void guardarInscripcion(Inscripcion insc) {
        String sql = "INSERT INTO inscripcion (nota, idAlumno, idMateria) "
                + "VALUES(?,?,?)";

       try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setDouble(1, insc.getNota());
            ps.setInt(2, insc.alumno.getIdAlumno());
            ps.setInt(3, insc.materia.getIdMateria());
                       
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                insc.setIdInscripcion(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Alumno Inscripto");

            }
            ps.close();

        } catch (SQLException ex) {
            // mensaje error al acceder al al db
            JOptionPane.showMessageDialog(null, "Error al acceder. " + ex);
        }
      
    }
    
    
}

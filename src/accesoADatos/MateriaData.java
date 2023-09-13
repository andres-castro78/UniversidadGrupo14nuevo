package accesoADatos;

import entidades.Materia;
import java.sql.*;
import javax.swing.JOptionPane;

public class MateriaData {

    private Connection con = null;

    public MateriaData() {
        con = Conexion.getConexion();
    }

    public void guardarMateria(Materia materia) {
        String sql = "INSERT INTO materia (nombre, año, estado)"
                + "VALUES(?,?,?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, materia.getNombre());
            ps.setInt(2, materia.getAnioMateria());
            ps.setBoolean(3, materia.isActivo());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {

                materia.setIdMateria(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Materia guardada exitosamente.");

            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla materia." + ex);
        }
    }

    public Materia buscarMateria(int id) {

        String sql = "SELECT nombre, año, estado FROM materia "
                + "WHERE idMateria = ? AND estado = 1";
        System.out.println(sql);
        Materia materia = null;

        try {

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                
               materia = new Materia();
               materia.setIdMateria(id);
               materia.setNombre(rs.getString("nombre"));
               materia.setAnioMateria(rs.getInt("año"));
               materia.setActivo(true);
                
                
            }else{
                JOptionPane.showMessageDialog(null, "No existe una materia con el Id indicado o no está activa.");
            }
            ps.close();
            
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla materia." + ex);

        }
        return materia;

    }
    
    public void modificarMateria(Materia materia){
        String sql = "UPDATE materia SET nombre =?, año =? "
                + "WHERE idMateria = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, materia.getNombre());
            ps.setInt(2, materia.getAnioMateria());
            ps.setInt(3, materia.getIdMateria());
            
            int exito = ps.executeUpdate();
            
            if (exito == 1){
                JOptionPane.showMessageDialog(null, "Materia modificada");
                
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla materia." + ex);
        }
               
    }
     
    public void eliminarMateria(int id){
            
        String sql = "UPDATE materia SET estado = 0 WHERE idMateria = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int exito = ps.executeUpdate();
            
            if (exito == 1) {
                
                JOptionPane.showMessageDialog(null, "Materia Eliminada");
            }
            
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla materia." + ex);
        }
        
        
        }

}
//CAMBIADO
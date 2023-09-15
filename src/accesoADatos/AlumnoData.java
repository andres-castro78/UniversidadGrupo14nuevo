package accesoADatos;

import entidades.Alumno;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class AlumnoData {

    private Connection con = null;

    public AlumnoData() {
        con = Conexion.getConexion();
    }

    //Cargar datos (INSERT)
    public void guardarAlumno(Alumno alumno) {
        String sql = "INSERT INTO alumno (dni, apellido, nombre, fechaNacimiento,estado)"
                + "VALUES(?,?,?,?,?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, alumno.getDni());
            ps.setString(2, alumno.getApellido());
            ps.setString(3, alumno.getNombre());
            ps.setDate(4, Date.valueOf(alumno.getFechaNac()));
            ps.setBoolean(5, alumno.isActivo());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                alumno.setIdAlumno(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "alumno Guardado");

            }
            ps.close();

        } catch (SQLException ex) {
            // mensaje error al acceder al al db
            JOptionPane.showMessageDialog(null, "Error al acceder. " + ex);
        }

    }

    //Modificar Datos (UPDATE)
    public void modificarAlumno(Alumno alumno) {
        String sql = "UPDATE alumno SET dni = ?, apellido = ?, nombre = ?, fechaNacimiento = ? "
                + "WHERE idAlumno = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, alumno.getDni());
            ps.setString(2, alumno.getApellido());
            ps.setString(3, alumno.getNombre());
            ps.setDate(4, Date.valueOf(alumno.getFechaNac()));
            ps.setInt(5, alumno.getIdAlumno());

            //Ejecutamos sentencia desde el método main
            int exito = ps.executeUpdate();//executeUpdate devuelve un entero

            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Alumno modificado");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla alumno");
        }
    }

    //Borarar datos (Se eliminan logicamente, se dan de baja)
    public void eliminarAlumno(int id) {
        String sql = "UPDATE alumno SET estado = 0 WHERE idAlumno = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, id);
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Alumno Eliminado");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla alumno");
        }

    }
    
    //SELECT BUSCAR DATO (ResultSet usa executeQuery)
    public Alumno buscarAlumno(int id) {
        String sql = "SELECT dni, apellido, nombre, fechaNacimiento FROM alumno WHERE idAlumno = ? AND estado = 1";
        //Fuera de try - catch creamos una variable: 
        Alumno alumno = null;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                //Dentro de if creamos un objeto alumno con la variable alumno:
                alumno = new Alumno(); // Estamos usando el contructor vacío de alumno
                //Vamos a setear los datos en base a los que devolvio el ResulSet
                alumno.setIdAlumno(id);
                alumno.setDni(rs.getInt("dni"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setFechaNac(rs.getDate("fechaNacimiento").toLocalDate());
                alumno.setActivo(true);

            } else {
                JOptionPane.showMessageDialog(null, "No existe ese alumno");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error  tabla alumno");
        }
        return alumno;
    }
    
    public Alumno buscarAlumnoPorDni(int dni) {
        String sql = "SELECT * FROM alumno WHERE dni = ? AND estado = 1 ";
        //Fuera de try - catch creamos una variable: 
        Alumno alumno = null;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, dni);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                //Dentro de if creamos un objeto alumno con la variable alumno:
                alumno = new Alumno(); // Estamos usando el contructor vacío de alumno
                //Vamos a setear los datos en base a los que devolvio el ResulSet
                alumno.setIdAlumno(rs.getInt("idAlumno"));
                alumno.setDni(dni);
                alumno.setApellido(rs.getString("apellido"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setFechaNac(rs.getDate("fechaNacimiento").toLocalDate());
                alumno.setActivo(true);

            } else {
                JOptionPane.showMessageDialog(null, "No existe ese alumno");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error  tabla alumno");
        }
        return alumno;
    }
    
    //SELECT LISTAR TODOS LOS ELEMENTOS (ResultSet usa executeQuery)
    public List<Alumno>listarAlumnos() {
        String sql = "SELECT idAlumno, dni, apellido, nombre, fechaNacimiento FROM alumno WHERE estado = 1";
        //Fuera de try - catch creamos un ArrayList: 
        ArrayList<Alumno> alumnos = new ArrayList<>();
        try {
            PreparedStatement ps= con.prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                //Dentro de while creamos un objeto vacio:
                Alumno alumno= new Alumno(); // Estamos usando el contructor vacío de alumno
                //Vamos a setear los datos en base a los que devolvio el ResulSet
                alumno.setIdAlumno(rs.getInt("idAlumno"));
                alumno.setDni(rs.getInt("dni"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setFechaNac(rs.getDate("fechaNacimiento").toLocalDate());
                alumno.setActivo(true);
        
        //Guardamos el objeto en la lista de alumnos
                alumnos.add(alumno);
            
            ps.close();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error  tabla alumno");
        }
        return alumnos;          
    }
}



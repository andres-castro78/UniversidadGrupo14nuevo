
package universidadgrupo14nuevo;

import accesoADatos.AlumnoData;
import accesoADatos.Conexion;
import accesoADatos.InscripcionData;
import accesoADatos.MateriaData;
import entidades.Alumno;
import entidades.Inscripcion;
import entidades.Materia;
import java.sql.Connection;
import java.time.LocalDate;

public class UniversidadGrupo14nuevo {

    public static void main(String[] args) {
        
        
        Connection conect = Conexion.getConexion();
       Alumno juan = new Alumno (3, 111111111, "Luna", "Juan Pedro",LocalDate.of(1970, 5 , 17),false);
//       AlumnoData alu = new AlumnoData();
//       alu.guardarAlumno(juan); 
      //alu.modificarAlumno(juan);
      //alu.eliminarAlumno(1);
//       Alumno alumnoEncontrado = alu.buscarAlumno(5);
//        if(alumnoEncontrado!=null){
//        System.out.println("Apellido: " + alumnoEncontrado.getApellido());
//        System.out.println("Nombre: " + alumnoEncontrado.getNombre());
//        System.out.println("DNI: " + alumnoEncontrado.getDni());
      

    Materia mat1 = new Materia (3,"Lengua", 2, true);
//    Materia mat2 = new Materia ("Ciencias Políticas", 1, true);
        MateriaData mat = new MateriaData();
        
//       materia.guardarMateria(mat1);
//       materia.guardarMateria(mat2);
       // materia.modificarMateria(matem);
       //materia.eliminarMateria(1);
       //materia.buscarMateria(3);
 
       
       
  /*     
AlumnoData alu=new AlumnoData();
    for(Alumno alumno:alu.listarAlumnos()){
        //mostrar los datos que queramos de cada elemento
           System.out.println(alumno.getDni());
           System.out.println(alumno.getNombre());
           System.out.println(" ----- ");
    
           
//        for(Materia materia: mat.listarMaterias()){
            
 //           System.out.println(materia.toString());
 */
 
 InscripcionData inscrip = new InscripcionData();
 Inscripcion insc1 = new Inscripcion(juan, mat1, 8);
 inscrip.guardarInscripcion(insc1);
        }

    }
    

    
    

    
    



package universidadgrupo14nuevo;

import accesoADatos.AlumnoData;
import accesoADatos.MateriaData;
import entidades.Alumno;
import entidades.Materia;
import java.time.LocalDate;

public class UniversidadGrupo14nuevo {

    public static void main(String[] args) {
        
//       Alumno juan = new Alumno (1, 111111111, "Luna", "Juan Pedro",LocalDate.of(1970, 5 , 17),false);
//       AlumnoData alu = new AlumnoData();
//       alu.guardarAlumno(juan); 
      //alu.modificarAlumno(juan);
      //alu.eliminarAlumno(1);
//       Alumno alumnoEncontrado = alu.buscarAlumno(5);
//        if(alumnoEncontrado!=null){
//        System.out.println("Apellido: " + alumnoEncontrado.getApellido());
//        System.out.println("Nombre: " + alumnoEncontrado.getNombre());
//        System.out.println("DNI: " + alumnoEncontrado.getDni());
      

//Materia matem = new Materia ("Física", 1, true);
        MateriaData materia = new MateriaData();
        
       // materia.guardarMateria(matem);
       // materia.modificarMateria(matem);
       //materia.eliminarMateria(1);
       materia.buscarMateria(3);
       
AlumnoData alu=new AlumnoData();
    for(Alumno alumno:alu.listarAlumnos()){
        //mostrar los datos que queramos de cada elemento
           System.out.println(alumno.getDni());
           System.out.println(alumno.getNombre());
           System.out.println(" ----- ");

    }
    }
}
    
    

    
    


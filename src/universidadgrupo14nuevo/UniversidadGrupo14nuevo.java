
package universidadgrupo14nuevo;

import accesoADatos.AlumnoData;
import entidades.Alumno;
import java.time.LocalDate;

public class UniversidadGrupo14nuevo {

    public static void main(String[] args) {
        
       Alumno juan = new Alumno (1, 12345678, "Perez", "Rodrigo",LocalDate.of(1970, 5 , 17),true);
       AlumnoData alu = new AlumnoData();
       //alu.guardarAlumno(juan); 
      //alu.modificarAlumno(juan);
      //alu.eliminarAlumno(1);
       Alumno alumnoEncontrado = alu.buscarAlumno(5);
        if(alumnoEncontrado!=null){
        System.out.println("Apellido: " + alumnoEncontrado.getApellido());
        System.out.println("Nombre: " + alumnoEncontrado.getNombre());
        System.out.println("DNI: " + alumnoEncontrado.getDni());
    }

    }
    
}

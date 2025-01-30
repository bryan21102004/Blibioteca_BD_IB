package Logic;

import java.sql.Connection;
import Conexion_BD.Conexion;
import Entidad.Autor;
import Entidad.Prestamos;
import java.sql.Date;

//En esta clase haremos las pruebas correspondientes del crud
public class Main {

    public static void main(String[] args) {
        //Conexion a la BD
        Conexion conexionBD = new Conexion();
        Connection conexion = conexionBD.conectar();

        //Instancia de la clase prestamo
//        Prestamos prestamos = new Prestamos();
//        prestamos.setIdEstudiante(27);
//        prestamos.setIdEjemplar(13);
        //Instancia clase Autor
//        Autor autor = new Autor();
//        autor.setIdAutor(1);
//        autor.setNombreAutor("Bryan Martínez");

      /*  CRUD crud = new CRUD(conexion);
        String cv[]=crud.consultarLibroPorID(8);
        for (int i = 0; i < cv.length; i++) {
            System.out.print(cv[i]+" ");
        }*/
        //crud.eliminarEstudiante(7);
        //boolean insertar = crud.insertarPrestamo(prestamos);
//        boolean actualizar = crud.actualizarAutores(autor);
//        if (actualizar) {
//            System.out.println("Prestamo insertado");
//        } else {
//            System.out.println("Error");
//        }
    }
}

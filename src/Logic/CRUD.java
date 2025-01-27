package Logic;

import Entidad.Autor;
import Entidad.Prestamos;
import java.sql.PreparedStatement;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.Connection;

public class CRUD {

    //Conectamos a la base de datos
    Connection conexion;

    public CRUD(Connection conexion) {
        this.conexion = conexion;
    }

    //Metodo para insertar un prestamo de un libro
    public boolean insertarPrestamo(Prestamos prestamos) {
        //Query de sql para insertar el prestamo
        String sql = "{CALL InsertarPrestamos(?,?)}";
        //Con el preparedStatement parametrizamos las consultas
        try (CallableStatement cs = conexion.prepareCall(sql)) {
            cs.setInt(1, prestamos.getIdEstudiante());
            cs.setInt(2, prestamos.getIdEjemplar());

            //con el executeUpdate es el que ejecuta y modifica la BD correctamente
            int filasAfectada = cs.executeUpdate();
            if (filasAfectada >= 0) {
                System.out.println("Se inserto correctamente");
                return true;
            } else {
                System.out.println("No se afectaron filas, pero el préstamo puede haber sido insertado.");
                return false;
            }

        } catch (SQLException e) {
            System.out.println("Error al ejecutar el procedimiento almacenado: " + e.getMessage());
            e.printStackTrace();
            return false;

        }
    }

    public boolean actualizarAutores(Autor autor) {
        String sql = "{CALL ActualizarAutores(?,?)}";
        try (CallableStatement cs = conexion.prepareCall(sql)) {
            cs.setInt(1, autor.getIdAutor());
            cs.setString(2, autor.getNombreAutor());

            int filasAfectadas = cs.executeUpdate();
            if (filasAfectadas > 0) {
                System.out.println("Autor actualizado");
                return true;
            } else {
                System.out.println("Posible autor actualizado");
                return false;
            }
        } catch (Exception e) {
            System.out.println("Error en el procedimiento almacenado");
            e.printStackTrace();
            return false;
        }
    }
}

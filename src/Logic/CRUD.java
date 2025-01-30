package Logic;

import Conexion_BD.Conexion;
import Entidad.Autor;
import Entidad.Estudiante;
import Entidad.Libros;
import Entidad.Prestamos;
import java.sql.PreparedStatement;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    
    public void eliminarEstudiante(int idEstudiante){
        String sql = "{CALL EliminarEstudiante(?)}";
        CallableStatement stm=null;
        try {
            stm = conexion.prepareCall(sql);
            //Parametros
            stm.setInt(1, idEstudiante);//Indica la posicion y el parametro de nuestro procedimiento
            stm.execute();//ejecutar
        } catch (SQLException ex) {
            System.out.println("Hubo un fallo al eliminar el estudiante: "+ex);
        }finally{
            try {
              if(stm != null) stm.close();
              if (conexion != null) conexion.close(); 
            } catch (SQLException ex) {
                System.out.println("Ocurrió un error al cerrar las conexiones: "+ex);
            }
        }

    }
    
    public Libros consultarLibroPorNombre(String nombre){
        String sql="{CALL ConsultarLibros(?,?,?,?,?)}";
        CallableStatement stm=null;    
        ResultSet resultado=null;
        Libros libro=null;
        try {
            stm=conexion.prepareCall(sql);
            //Parametros
            stm.setNull(1, java.sql.Types.INTEGER);
            stm.setString(2, nombre);
            stm.setNull(3, java.sql.Types.VARCHAR);
            stm.setNull(4, java.sql.Types.VARCHAR);
            stm.setNull(5, java.sql.Types.DATE);
            
            resultado=stm.executeQuery();
            while(resultado.next()){
                int idLibro=resultado.getInt("ID_Libro");
                String nombreLibro=resultado.getString("Nombre_Libro");
                String isbn=resultado.getString("ISBN");
                int cantidadPaginas=resultado.getInt("Cantidad_Paginas");
                String editorial=resultado.getString("Editorial");
                java.sql.Date fechaPublicacion=resultado.getDate("Fecha_Publicacion");
                libro= new Libros(idLibro, nombreLibro, isbn, cantidadPaginas,
                        editorial, fechaPublicacion);
            }
        } catch (SQLException ex) {
            System.out.println("No se pudo consultar el libro: "+ex);
        }
       return libro;
    }
    public Libros consultarLibroPorID(int idLibro){
        String sql="{CALL ConsultarLibros(?,?,?,?,?)}";
        CallableStatement stm=null;    
        ResultSet resultado=null;
        Libros libro=null;
        try {
            stm=conexion.prepareCall(sql);
            //Parametros
            stm.setInt(1,idLibro);
            stm.setNull(2, java.sql.Types.VARCHAR);
            stm.setNull(3, java.sql.Types.VARCHAR);
            stm.setNull(4, java.sql.Types.VARCHAR);
            stm.setNull(5, java.sql.Types.DATE);
            
            resultado=stm.executeQuery();
            while(resultado.next()){
                int idLibroE=resultado.getInt("ID_Libro");
                String nombreLibro=resultado.getString("Nombre_Libro");
                String isbn=resultado.getString("ISBN");
                int cantidadPaginas=resultado.getInt("Cantidad_Paginas");
                String editorial=resultado.getString("Editorial");
                java.sql.Date fechaPublicacion=resultado.getDate("Fecha_Publicacion");
                libro = new Libros(idLibro, nombreLibro, isbn, cantidadPaginas,
                        editorial, fechaPublicacion);
            }
        } catch (SQLException ex) {
            System.out.println("No se pudo consultar el libro: "+ex);
        }
       return libro;
    }
    
    public ArrayList<Libros> consultarLibros(){
        ArrayList<Libros>listaLibros=new ArrayList();
        String sql="{CALL ConsultaDeLibros()}";
        CallableStatement stm=null;
        try {
            stm=conexion.prepareCall(sql);
            ResultSet resultado=stm.executeQuery();
            while (resultado.next()) {  
                int idLibroE=resultado.getInt("ID_Libro");
                String nombreLibro=resultado.getString("Nombre_Libro");
                String isbn=resultado.getString("ISBN");
                int cantidadPaginas=resultado.getInt("Cantidad_Paginas");
                String editorial=resultado.getString("Editorial");
                java.sql.Date fechaPublicacion=resultado.getDate("Fecha_Publicacion");
                Libros libro = new Libros(idLibroE, nombreLibro, isbn, cantidadPaginas,
                        editorial, fechaPublicacion);
                listaLibros.add(libro);
            }
        } catch (SQLException ex) {
            System.out.println("No se pudo hacer la consulta de los libros: "+ex);
        }
        return listaLibros;
    }
    

    public ArrayList<Autor> consultarAutores(){
    ArrayList<Autor>listaAutores=new ArrayList();
        String sql="{CALL ConsultaDeAutores()}";
        CallableStatement stm=null;
        try {
            stm=conexion.prepareCall(sql);
            ResultSet resultado=stm.executeQuery();
            while (resultado.next()) {  
                int idAutor = resultado.getInt("ID_Autor");
                String nombreAutor = resultado.getString("Nombre_Autor");
                Autor autor = new Autor(idAutor, nombreAutor);
                listaAutores.add(autor);
            }
        } catch (SQLException ex) {
            System.out.println("No se pudo hacer la consulta de los libros: "+ex);
        }
        return listaAutores;
    }
    
    public ArrayList<Estudiante> consultarEstudiantes(){
        ArrayList<Estudiante>listaEstudiantes=new ArrayList();
        String sql="{CALL ConsultaDeEstudiantes()}";
        CallableStatement stm=null;
        try {
            stm=conexion.prepareCall(sql);
            ResultSet resultado=stm.executeQuery();
            while (resultado.next()) {  
                int idEstudiante = resultado.getInt("ID_Estudiante");
                String nombreEstudiante = resultado.getString("Nombre_Estudiante");
                String apellidosEstudiane=resultado.getString("Apellidos_Estudiante");
                String telefonoEstudiante=resultado.getString("Telefono");
                String direccion=resultado.getString("Direccion");
                String carrera=resultado.getString("Carrera");
                int idLocalizacion=resultado.getInt("ID_Localizacion");
                
                Estudiante estudiante= new Estudiante(idEstudiante, nombreEstudiante,
                        apellidosEstudiane, direccion, direccion, carrera, idLocalizacion);
                listaEstudiantes.add(estudiante);
            }
        } catch (SQLException ex) {
            System.out.println("No se pudo hacer la consulta de los libros: "+ex);
        }
        return listaEstudiantes;
    }
    
}

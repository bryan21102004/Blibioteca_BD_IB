package Entidad;

public class Libros {
  private int idLibro;
  private String nombreLibro;
  private String isbn;
  private int cantidadPaginas;
  private String editorial;
  private java.sql.Date fechaPublicacion;
  
  //Constructor con todos sus atributos como parametro
    public Libros(int idLibro, String nombreLibro, String isbn, int cantidadPaginas,
            String editorial, java.sql.Date fechaPublicacion) {
        this.idLibro = idLibro;
        this.nombreLibro = nombreLibro;
        this.isbn = isbn;
        this.cantidadPaginas = cantidadPaginas;
        this.editorial = editorial;
        this.fechaPublicacion = fechaPublicacion;
    }
   //Constructor vacio
    public Libros() {
    }
   
  //Metodos de acceso (Set y get)

    public int getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }

    public String getNombreLibro() {
        return nombreLibro;
    }

    public void setNombreLibro(String nombreLibro) {
        this.nombreLibro = nombreLibro;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getCantidadPaginas() {
        return cantidadPaginas;
    }

    public void setCantidadPaginas(int cantidadPaginas) {
        this.cantidadPaginas = cantidadPaginas;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public java.sql.Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(java.sql.Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }
    @Override
    public String toString(){
        return "ID Libro: "+idLibro+",Titulo: "+nombreLibro+",ISBN: "+isbn
                +",Cantidad de páginas: "+cantidadPaginas+",Editorial: "
                +editorial+",Fecha de publicación: "+fechaPublicacion;
    }
    
    
    
}

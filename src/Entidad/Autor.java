package Entidad;

public class Autor {
  private int idAutor;
  private String nombreAutor;
    
    //Constructor con todos sus atributos como parametros
    public Autor(int idAutor, String nombreAutor) {
        this.idAutor = idAutor;
        this.nombreAutor = nombreAutor;
    }
    //Constructor vacio
    public Autor() {
    }
    //Metodos de acceso (Set y get)

    public int getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(int idAutor) {
        this.idAutor = idAutor;
    }

    public String getNombreAutor() {
        return nombreAutor;
    }

    public void setNombreAutor(String nombreAutor) {
        this.nombreAutor = nombreAutor;
    }
    @Override
    public String toString(){
       return idAutor+" "+nombreAutor; 
    }
    
    
    
    
    
}

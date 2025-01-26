package Entidad;

public class Ejemplar {
  private int idEjemplar;
  private String cantidadEjemplares;
  private int idLibro;
  private int idLocalizacion;
    //Constructor con todos los atributos como parametro
    public Ejemplar(int idEjemplar, String cantidadEjemplares, int idLibro, int idLocalizacion) {
        this.idEjemplar = idEjemplar;
        this.cantidadEjemplares = cantidadEjemplares;
        this.idLibro = idLibro;
        this.idLocalizacion = idLocalizacion;
    }
    //Constructor vacio
    public Ejemplar() {
    }
    
    //Metodos de acceso (Set y get)

    public int getIdEjemplar() {
        return idEjemplar;
    }

    public void setIdEjemplar(int idEjemplar) {
        this.idEjemplar = idEjemplar;
    }

    public String getCantidadEjemplares() {
        return cantidadEjemplares;
    }

    public void setCantidadEjemplares(String cantidadEjemplares) {
        this.cantidadEjemplares = cantidadEjemplares;
    }

    public int getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }

    public int getIdLocalizacion() {
        return idLocalizacion;
    }

    public void setIdLocalizacion(int idLocalizacion) {
        this.idLocalizacion = idLocalizacion;
    }
    
    @Override
    public String toString(){
      return idEjemplar+" "+cantidadEjemplares+" "+idLibro+" "+idLocalizacion;  
    }
          
    
    
    
}

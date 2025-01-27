package Entidad;
public class Prestamos {
    private int idPrestamo;
    private int idEstudiante;
    private int idEjemplar;
    private String fechaPrestamo;
    private String fechaDevolucion;
    private String estado;
    //Constructor que recibe todos sus atributos como parametro
    public Prestamos(int idPrestamo, int idEstudiante, int idEjemplar, String fechaPrestamo,String estado) {
        this.idPrestamo = idPrestamo;
        this.idEstudiante = idEstudiante;
        this.idEjemplar = idEjemplar;
        this.fechaPrestamo = fechaPrestamo;
        this.estado=estado;
    }
    //Constructor vacio
    public Prestamos() {
    }
    
    //Metodos de acceso (Set y get)

    public int getIdPrestamo() {
        return idPrestamo;
    }

    public void setIdPrestamo(int idPrestamo) {
        this.idPrestamo = idPrestamo;
    }

    public int getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(int idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public int getIdEjemplar() {
        return idEjemplar;
    }

    public void setIdEjemplar(int idEjemplar) {
        this.idEjemplar = idEjemplar;
    }

    public String getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(String fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public String getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(String fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }
    @Override
    public String toString(){
      return idPrestamo+" "+idEstudiante+" "+idEjemplar+" "
              +fechaPrestamo+" "+fechaDevolucion+" "+estado;
    }
    
}

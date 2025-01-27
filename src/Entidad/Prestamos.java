package Entidad;

import java.sql.Date;

public class Prestamos {
    private int idPrestamo;
    private int idEstudiante;
    private int idEjemplar;
    private String fechaPrestamo;
    private  java.sql.Date fechaDevolucion;
    private String estado;
    //Constructor que recibe todos sus atributos como parametro
    public Prestamos(int idPrestamo, int idEstudiante, int idEjemplar, 
            String fechaPrestamo,java.sql.Date fechaDevolucion,String estado) {
        this.idPrestamo = idPrestamo;
        this.idEstudiante = idEstudiante;
        this.idEjemplar = idEjemplar;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion= fechaDevolucion;
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

    public Date getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(Date fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

  
    @Override
    public String toString(){
      return idPrestamo+" "+idEstudiante+" "+idEjemplar+" "
              +fechaPrestamo+" "+fechaDevolucion+" "+estado;
    }
    
}

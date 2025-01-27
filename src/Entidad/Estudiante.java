package Entidad;

public class Estudiante {
  
    private int idEstudiante;
    private String nombreEstudiante;
    private String apellidosEstudiante;
    private String telefono;
    private String direccion;
    private String carrera;
    private int idLocalizacion;
    //Constructor con todos sus atributos en parametros
    public Estudiante(int idEstudiante, String nombreEstudiante, String apellidosEstudiante, String telefono, String direccion, String carrera, int idLocalizacion) {
        this.idEstudiante = idEstudiante;
        this.nombreEstudiante = nombreEstudiante;
        this.apellidosEstudiante = apellidosEstudiante;
        this.telefono = telefono;
        this.direccion = direccion;
        this.carrera = carrera;
        this.idLocalizacion = idLocalizacion;
    }
    //Constructor vacio en caso de ser necesario no inicializar 
    //los atributos dentro de los parametros
    public Estudiante() {
    }
    //Metodos de acceso (Set y get)

    public int getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(int idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public String getNombreEstudiante() {
        return nombreEstudiante;
    }

    public void setNombreEstudiante(String nombreEstudiante) {
        this.nombreEstudiante = nombreEstudiante;
    }

    public String getApellidosEstudiante() {
        return apellidosEstudiante;
    }

    public void setApellidosEstudiante(String apellidosEstudiante) {
        this.apellidosEstudiante = apellidosEstudiante;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public int getIdLocalizacion() {
        return idLocalizacion;
    }

    public void setIdLocalizacion(int idLocalizacion) {
        this.idLocalizacion = idLocalizacion;
    }
    
    @Override 
    public String toString(){
      return idEstudiante +" "+nombreEstudiante+" "+apellidosEstudiante+" "
              +telefono+" "+direccion+" "+carrera+" "+idLocalizacion;
    }
    
    
    
    
}

package Entidad;

public class Localizacion {
  private int idLocalizacion;
  private String recinto;

    public Localizacion(int idLocalizacion, String recinto) {
        this.idLocalizacion = idLocalizacion;
        this.recinto = recinto;
    }

    public Localizacion() {
    }

    public int getIdLocalizacion() {
        return idLocalizacion;
    }

    public void setIdLocalizacion(int idLocalizacion) {
        this.idLocalizacion = idLocalizacion;
    }

    public String getRecinto() {
        return recinto;
    }

    public void setRecinto(String recinto) {
        this.recinto = recinto;
    }
    @Override
    public String toString(){
       return idLocalizacion+" "+recinto;
    }
  
}

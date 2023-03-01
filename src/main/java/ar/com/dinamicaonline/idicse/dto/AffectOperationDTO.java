package ar.com.dinamicaonline.idicse.dto;

public class AffectOperationDTO {
    private String numeroOperacion; 
    private String importe;
    private String cantidadCuotas;
    private String dni;
    
    public AffectOperationDTO(String numeroOperacion, String importe, String cantidadCuotas, String dni) {
        this.numeroOperacion = numeroOperacion;
        this.importe = importe;
        this.cantidadCuotas = cantidadCuotas;
        this.dni = dni;
    }
    public AffectOperationDTO() {
    }
    public String getNumeroOperacion() {
        return numeroOperacion;
    }
    public void setNumeroOperacion(String numeroOperacion) {
        this.numeroOperacion = numeroOperacion;
    }
    public String getImporte() {
        return importe;
    }
    public void setImporte(String importe) {
        this.importe = importe;
    }
    public String getCantidadCuotas() {
        return cantidadCuotas;
    }
    public void setCantidadCuotas(String cantidadCuotas) {
        this.cantidadCuotas = cantidadCuotas;
    }
    public String getDni() {
        return dni;
    }
    public void setDni(String dni) {
        this.dni = dni;
    }
    @Override
    public String toString() {
        return "AffectOperationDTO [numeroOperacion=" + numeroOperacion + ", importe=" + importe + ", cantidadCuotas="
                + cantidadCuotas + ", dni=" + dni + "]";
    }
           
}

package ar.com.dinamicaonline.idicse.dto;

public class UnaffectedOperationDTO {
    private String numeroOperacion;
    private String dni;
    
    public UnaffectedOperationDTO(String numeroOperacion, String dni) {
        this.numeroOperacion = numeroOperacion;
        this.dni = dni;
    }
    public UnaffectedOperationDTO() {
    }
    public String getNumeroOperacion() {
        return numeroOperacion;
    }
    public void setNumeroOperacion(String numeroOperacion) {
        this.numeroOperacion = numeroOperacion;
    }
    public String getDni() {
        return dni;
    }
    public void setDni(String dni) {
        this.dni = dni;
    }
    @Override
    public String toString() {
        return "UnaffectedOperationDTO [numeroOperacion=" + numeroOperacion + ", dni=" + dni + "]";
    }
    
}

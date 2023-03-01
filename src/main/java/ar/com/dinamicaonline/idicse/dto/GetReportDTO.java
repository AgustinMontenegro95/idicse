package ar.com.dinamicaonline.idicse.dto;

public class GetReportDTO {
    private String dni;
    private String sexo;
    
    public GetReportDTO(String dni, String sexo) {
        this.dni = dni;
        this.sexo = sexo;
    }
    public GetReportDTO() {
    }
    public String getDni() {
        return dni;
    }
    public void setDni(String dni) {
        this.dni = dni;
    }
    public String getSexo() {
        return sexo;
    }
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    @Override
    public String toString() {
        return "ClientDTO [dni=" + dni + ", sexo=" + sexo + "]";
    }
    
}

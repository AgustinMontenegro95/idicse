package ar.com.dinamicaonline.idicse.dto;

public class ConfirmOperationDTO {
    private String numeroOperacion;
    private String importeTotal;
    private String cantidadCuotas;
    private String importeCuota;
    private String fechaPrimerVto;
    private String dni;

    public ConfirmOperationDTO(String numeroOperacion, String importeTotal, String cantidadCuotas, String importeCuota,
            String fechaPrimerVto, String dni) {
        this.numeroOperacion = numeroOperacion;
        this.importeTotal = importeTotal;
        this.cantidadCuotas = cantidadCuotas;
        this.importeCuota = importeCuota;
        this.fechaPrimerVto = fechaPrimerVto;
        this.dni = dni;
    }
    public ConfirmOperationDTO() {
    }
    public String getNumeroOperacion() {
        return numeroOperacion;
    }
    public void setNumeroOperacion(String numeroOperacion) {
        this.numeroOperacion = numeroOperacion;
    }
    public String getImporteTotal() {
        return importeTotal;
    }
    public void setImporteTotal(String importeTotal) {
        this.importeTotal = importeTotal;
    }
    public String getCantidadCuotas() {
        return cantidadCuotas;
    }
    public void setCantidadCuotas(String cantidadCuotas) {
        this.cantidadCuotas = cantidadCuotas;
    }
    public String getImporteCuota() {
        return importeCuota;
    }
    public void setImporteCuota(String importeCuota) {
        this.importeCuota = importeCuota;
    }
    public String getFechaPrimerVto() {
        return fechaPrimerVto;
    }
    public void setFechaPrimerVto(String fechaPrimerVto) {
        this.fechaPrimerVto = fechaPrimerVto;
    }
    public String getDni() {
        return dni;
    }
    public void setDni(String dni) {
        this.dni = dni;
    }
    @Override
    public String toString() {
        return "ConfirmOperationDTO [numeroOperacion=" + numeroOperacion + ", importeTotal=" + importeTotal
                + ", cantidadCuotas=" + cantidadCuotas + ", importeCuota=" + importeCuota + ", fechaPrimerVto="
                + fechaPrimerVto + ", dni=" + dni + "]";
    }
    
}

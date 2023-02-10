package ar.com.dinamicaonline.idicse.models;

public class ProyeccionCuotas {
    private String FechaAcuerdo;
    private String ImporteCuota;
    private String CreditosId;

    public ProyeccionCuotas() {
    }
    public ProyeccionCuotas(String fechaAcuerdo, String importeCuota, String creditosId) {
        FechaAcuerdo = fechaAcuerdo;
        ImporteCuota = importeCuota;
        CreditosId = creditosId;
    }
    public String getFechaAcuerdo() {
        return FechaAcuerdo;
    }
    public void setFechaAcuerdo(String fechaAcuerdo) {
        FechaAcuerdo = fechaAcuerdo;
    }
    public String getImporteCuota() {
        return ImporteCuota;
    }
    public void setImporteCuota(String importeCuota) {
        ImporteCuota = importeCuota;
    }
    public String getCreditosId() {
        return CreditosId;
    }
    public void setCreditosId(String creditosId) {
        CreditosId = creditosId;
    }
}

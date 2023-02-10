package ar.com.dinamicaonline.idicse.models;

public class PersonaBoletin {
    private String BoletinObservaciones;
    
    public PersonaBoletin(String boletinObservaciones) {
        BoletinObservaciones = boletinObservaciones;
    }

    public PersonaBoletin() {
    }

    public String getBoletinObservaciones() {
        return BoletinObservaciones;
    }

    public void setBoletinObservaciones(String boletinObservaciones) {
        BoletinObservaciones = boletinObservaciones;
    }
}

package ar.com.dinamicaonline.idicse.models;

public class PersonaJudiciales {
    private String JudicialesObservaciones;

    public PersonaJudiciales(String judicialesObservaciones) {
        JudicialesObservaciones = judicialesObservaciones;
    }

    public PersonaJudiciales() {
    }

    public String getJudicialesObservaciones() {
        return JudicialesObservaciones;
    }

    public void setJudicialesObservaciones(String judicialesObservaciones) {
        JudicialesObservaciones = judicialesObservaciones;
    }
    
}

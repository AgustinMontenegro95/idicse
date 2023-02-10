package ar.com.dinamicaonline.idicse.models;

import java.util.List;

public class Persona {
    private Integer InformesId;
    private Integer InformesNumeroOperacion;
    private String InformesFecha;
    private Integer InformeScore;
    private Integer PersonaCuil;
    private Integer PersonaDocumento;
    private String PersonaTipoDocumentoDescripcion;
    private String PersonaApellido;
    private String PersonaNombre;
    private String PersonaEdad;
    private String PersonaEstado;
    private String PersonaEstadoCivil;
    private String PersonaFechaNacimiento;
    private String PersonaSexo;
    private String PersonaTelefono;
    private String PersonaConyugeApellido;
    private String PersonaConyugeNombre;
    private String PersonaConyugeDocumento;
    private String PersonaConyugeTipoDocumento;
    private String PersonaConyugeTipoDocumentoDescripcion;
    private List<String> PersonaDomicilios;
    private List<String> PersonaTrabajos;
    private List<String> PersonaObservaciones;
    private PersonaBoletin PersonaBoletin;
    private PersonaJudiciales PersonaJudiciales;
    private List<String> PersonaSolicitudes;
    private List<String> PersonaAfectaciones;
    private ProyeccionCuotas ProyeccionCuotas;
    private String SocioId;
    private String SocioRazonSocial;
    private String UsuarioId;
	
	public Persona() {
	}
	
	public Persona(Integer informesId, Integer informesNumeroOperacion, String informesFecha, Integer informeScore,
			Integer personaCuil, Integer personaDocumento, String personaTipoDocumentoDescripcion,
			String personaApellido, String personaNombre, String personaEdad, String personaEstado,
			String personaEstadoCivil, String personaFechaNacimiento, String personaSexo, String personaTelefono,
			String personaConyugeApellido, String personaConyugeNombre, String personaConyugeDocumento,
			String personaConyugeTipoDocumento, String personaConyugeTipoDocumentoDescripcion,
			List<String> personaDomicilios, List<String> personaTrabajos, List<String> personaObservaciones,
			ar.com.dinamicaonline.idicse.models.PersonaBoletin personaBoletin,
			ar.com.dinamicaonline.idicse.models.PersonaJudiciales personaJudiciales, List<String> personaSolicitudes,
			List<String> personaAfectaciones, ar.com.dinamicaonline.idicse.models.ProyeccionCuotas proyeccionCuotas,
			String socioId, String socioRazonSocial, String usuarioId) {
		InformesId = informesId;
		InformesNumeroOperacion = informesNumeroOperacion;
		InformesFecha = informesFecha;
		InformeScore = informeScore;
		PersonaCuil = personaCuil;
		PersonaDocumento = personaDocumento;
		PersonaTipoDocumentoDescripcion = personaTipoDocumentoDescripcion;
		PersonaApellido = personaApellido;
		PersonaNombre = personaNombre;
		PersonaEdad = personaEdad;
		PersonaEstado = personaEstado;
		PersonaEstadoCivil = personaEstadoCivil;
		PersonaFechaNacimiento = personaFechaNacimiento;
		PersonaSexo = personaSexo;
		PersonaTelefono = personaTelefono;
		PersonaConyugeApellido = personaConyugeApellido;
		PersonaConyugeNombre = personaConyugeNombre;
		PersonaConyugeDocumento = personaConyugeDocumento;
		PersonaConyugeTipoDocumento = personaConyugeTipoDocumento;
		PersonaConyugeTipoDocumentoDescripcion = personaConyugeTipoDocumentoDescripcion;
		PersonaDomicilios = personaDomicilios;
		PersonaTrabajos = personaTrabajos;
		PersonaObservaciones = personaObservaciones;
		PersonaBoletin = personaBoletin;
		PersonaJudiciales = personaJudiciales;
		PersonaSolicitudes = personaSolicitudes;
		PersonaAfectaciones = personaAfectaciones;
		ProyeccionCuotas = proyeccionCuotas;
		SocioId = socioId;
		SocioRazonSocial = socioRazonSocial;
		UsuarioId = usuarioId;
	}



	public Integer getInformesId() {
		return InformesId;
	}

	public void setInformesId(Integer informesId) {
		InformesId = informesId;
	}

	public Integer getInformesNumeroOperacion() {
		return InformesNumeroOperacion;
	}

	public void setInformesNumeroOperacion(Integer informesNumeroOperacion) {
		InformesNumeroOperacion = informesNumeroOperacion;
	}

	public String getInformesFecha() {
		return InformesFecha;
	}

	public void setInformesFecha(String informesFecha) {
		InformesFecha = informesFecha;
	}

	public Integer getInformeScore() {
		return InformeScore;
	}

	public void setInformeScore(Integer informeScore) {
		InformeScore = informeScore;
	}

	public Integer getPersonaCuil() {
		return PersonaCuil;
	}

	public void setPersonaCuil(Integer personaCuil) {
		PersonaCuil = personaCuil;
	}

	public Integer getPersonaDocumento() {
		return PersonaDocumento;
	}

	public void setPersonaDocumento(Integer personaDocumento) {
		PersonaDocumento = personaDocumento;
	}

	public String getPersonaTipoDocumentoDescripcion() {
		return PersonaTipoDocumentoDescripcion;
	}

	public void setPersonaTipoDocumentoDescripcion(String personaTipoDocumentoDescripcion) {
		PersonaTipoDocumentoDescripcion = personaTipoDocumentoDescripcion;
	}

	public String getPersonaApellido() {
		return PersonaApellido;
	}

	public void setPersonaApellido(String personaApellido) {
		PersonaApellido = personaApellido;
	}

	public String getPersonaNombre() {
		return PersonaNombre;
	}

	public void setPersonaNombre(String personaNombre) {
		PersonaNombre = personaNombre;
	}

	public String getPersonaEdad() {
		return PersonaEdad;
	}

	public void setPersonaEdad(String personaEdad) {
		PersonaEdad = personaEdad;
	}

	public String getPersonaEstado() {
		return PersonaEstado;
	}

	public void setPersonaEstado(String personaEstado) {
		PersonaEstado = personaEstado;
	}

	public String getPersonaEstadoCivil() {
		return PersonaEstadoCivil;
	}

	public void setPersonaEstadoCivil(String personaEstadoCivil) {
		PersonaEstadoCivil = personaEstadoCivil;
	}

	public String getPersonaFechaNacimiento() {
		return PersonaFechaNacimiento;
	}

	public void setPersonaFechaNacimiento(String personaFechaNacimiento) {
		PersonaFechaNacimiento = personaFechaNacimiento;
	}

	public String getPersonaSexo() {
		return PersonaSexo;
	}

	public void setPersonaSexo(String personaSexo) {
		PersonaSexo = personaSexo;
	}

	public String getPersonaTelefono() {
		return PersonaTelefono;
	}

	public void setPersonaTelefono(String personaTelefono) {
		PersonaTelefono = personaTelefono;
	}

	public String getPersonaConyugeApellido() {
		return PersonaConyugeApellido;
	}

	public void setPersonaConyugeApellido(String personaConyugeApellido) {
		PersonaConyugeApellido = personaConyugeApellido;
	}

	public String getPersonaConyugeNombre() {
		return PersonaConyugeNombre;
	}

	public void setPersonaConyugeNombre(String personaConyugeNombre) {
		PersonaConyugeNombre = personaConyugeNombre;
	}

	public String getPersonaConyugeDocumento() {
		return PersonaConyugeDocumento;
	}

	public void setPersonaConyugeDocumento(String personaConyugeDocumento) {
		PersonaConyugeDocumento = personaConyugeDocumento;
	}

	public String getPersonaConyugeTipoDocumento() {
		return PersonaConyugeTipoDocumento;
	}

	public void setPersonaConyugeTipoDocumento(String personaConyugeTipoDocumento) {
		PersonaConyugeTipoDocumento = personaConyugeTipoDocumento;
	}

	public String getPersonaConyugeTipoDocumentoDescripcion() {
		return PersonaConyugeTipoDocumentoDescripcion;
	}

	public void setPersonaConyugeTipoDocumentoDescripcion(String personaConyugeTipoDocumentoDescripcion) {
		PersonaConyugeTipoDocumentoDescripcion = personaConyugeTipoDocumentoDescripcion;
	}

	public List<String> getPersonaDomicilios() {
		return PersonaDomicilios;
	}

	public void setPersonaDomicilios(List<String> personaDomicilios) {
		PersonaDomicilios = personaDomicilios;
	}

	public List<String> getPersonaTrabajos() {
		return PersonaTrabajos;
	}

	public void setPersonaTrabajos(List<String> personaTrabajos) {
		PersonaTrabajos = personaTrabajos;
	}

	public List<String> getPersonaObservaciones() {
		return PersonaObservaciones;
	}

	public void setPersonaObservaciones(List<String> personaObservaciones) {
		PersonaObservaciones = personaObservaciones;
	}

	public PersonaBoletin getPersonaBoletin() {
		return PersonaBoletin;
	}

	public void setPersonaBoletin(PersonaBoletin personaBoletin) {
		PersonaBoletin = personaBoletin;
	}

	public PersonaJudiciales getPersonaJudiciales() {
		return PersonaJudiciales;
	}

	public void setPersonaJudiciales(PersonaJudiciales personaJudiciales) {
		PersonaJudiciales = personaJudiciales;
	}

	public List<String> getPersonaSolicitudes() {
		return PersonaSolicitudes;
	}

	public void setPersonaSolicitudes(List<String> personaSolicitudes) {
		PersonaSolicitudes = personaSolicitudes;
	}

	public List<String> getPersonaAfectaciones() {
		return PersonaAfectaciones;
	}

	public void setPersonaAfectaciones(List<String> personaAfectaciones) {
		PersonaAfectaciones = personaAfectaciones;
	}

	public ProyeccionCuotas getProyeccionCuotas() {
		return ProyeccionCuotas;
	}

	public void setProyeccionCuotas(ProyeccionCuotas proyeccionCuotas) {
		ProyeccionCuotas = proyeccionCuotas;
	}

	public String getSocioId() {
		return SocioId;
	}

	public void setSocioId(String socioId) {
		SocioId = socioId;
	}

	public String getSocioRazonSocial() {
		return SocioRazonSocial;
	}

	public void setSocioRazonSocial(String socioRazonSocial) {
		SocioRazonSocial = socioRazonSocial;
	}

	public String getUsuarioId() {
		return UsuarioId;
	}

	public void setUsuarioId(String usuarioId) {
		UsuarioId = usuarioId;
	}
	
	
	
}

/* Json valido

{
	" Persona": {
		"InformesId": "",
		"InformesNumeroOperacion": "79377229",
		"InformesFecha ": "2022-10-17",
		"InformeScore": 600,
		"PersonaCuil": "",
		"PersonaDocumento": "33333333",
		"PersonaTipoDocumento": "",
		"PersonaTipoDocumentoDescripcion": "",
		"PersonaApellido": "Gomez",
		"PersonaNombre": "Juan",
		"PersonaEdad": "0",
		"PersonaEstado": "SIN ANTECEDENTES",
		"PersonaEstadoCivil": "",
		"PersonaFechaNacimiento": "0000-00-00 ",
		"PersonaSexo": "M",
		"PersonaTelefono": "",
		"PersonaConyugeApellido ": "",
		"PersonaConyugeNombre": "",
		"PersonaConyugeDocumento ": "0",
		"PersonaConyugeTipoDocumento": "",
		"PersonaConyugeTipoDocumentoDescripcion ": "",
		"PersonaDomicilios": [],
		"PersonaTrabajos": [],
		"PersonaObservaciones": [],
		"PersonaBoletin": {
			"BoletinObservaciones": ""
		},
		"PersonaJudiciales": {
			"JudicialesObservaciones": ""
		},
		"PersonaSolicitudes": [],
		"PersonaAfectaciones": [],
		"ProyeccionCuotas": {
			"FechaAcuerdo": "",
			"ImporteCuota": "",
			"CreditosId": ""
		},
		"SocioId": "1000000",
		"SocioRazonSocial": "Comercio 1",
		"UsuarioId": "analistaComercio1"
	}
} */
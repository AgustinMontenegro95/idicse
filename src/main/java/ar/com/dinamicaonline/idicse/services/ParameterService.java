package ar.com.dinamicaonline.idicse.services;

public interface ParameterService {

    String fetchParamById(int id);

    String fetchParamByParameterName(String parameterName);
}

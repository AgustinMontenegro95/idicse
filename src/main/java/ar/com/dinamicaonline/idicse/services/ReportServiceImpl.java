package ar.com.dinamicaonline.idicse.services;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import ar.com.dinamicaonline.idicse.dto.GetReportDTO;
import ar.com.dinamicaonline.idicse.dto.UnaffectedOperationDTO;
import ar.com.dinamicaonline.idicse.dto.AffectOperationDTO;
import ar.com.dinamicaonline.idicse.dto.ConfirmOperationDTO;
//import ar.com.dinamicaonline.idicse.security.SSLUtilities;

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    ReceiveAndSendService receiveAndSendService;

    @Autowired
    private ParameterService parameterService;

    @Override
    public ResponseEntity<?> getClientReport(GetReportDTO clientDTO) {
        // Solo version de prueba - deshabilitado ssl
        /*
         * try {
         * SSLUtilities.trustAllHttpsCertificates();
         * } catch (Exception e) {
         * // Manejar la excepción
         * }
         */

        Map<String, Object> responseBody = new HashMap<>();

        // Get user and pass
        String userIdicse = parameterService.fetchParamByParameterName("IDICSE-USER");
        String passIdicse = parameterService.fetchParamByParameterName("IDICSE-PASS");

        // Verification entry
        System.out.println(clientDTO.getDni());
        System.out.println(clientDTO.getSexo());
        System.out.println(userIdicse);
        System.out.println(passIdicse);

        // JSON send
        String body = "{\"PersonaDNI\": \"" + clientDTO.getDni() + "\", " +
                "\"PersonaSexo\": \"" + clientDTO.getSexo() + "\", " +
                "\"UsuarioId\": \"" + userIdicse + "\", " +
                "\"PasswordClave\":\"" + passIdicse + "\" " +
                "}";

        // verification sent
        System.out.println("Body sent: " + body);

        // Request https://www.idicse.org.ar/pruebaapi/ws/crearInforme - post - Json
        // send
        URL url;
        try {
            url = new URL("https://www.idicse.org.ar/pruebaapi/ws/crearInforme");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Accept", "application/json");
            connection.setDoOutput(true);

            String json = body;
            byte[] postData = json.getBytes(StandardCharsets.UTF_8);

            connection.setRequestProperty("Content-Length", Integer.toString(postData.length));

            try (DataOutputStream wr = new DataOutputStream(connection.getOutputStream())) {
                wr.write(postData);
            }
            int responseCode = connection.getResponseCode();
            System.out.println("Response code: " + responseCode);

            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Get response
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                JSONParser parser = new JSONParser();
                JSONObject jsonResponse = new JSONObject();
                try {
                    jsonResponse = (JSONObject) parser.parse(response.toString());
                } catch (ParseException e) {
                    System.out.println("Error al decodificar respuesta de BIND");
                    System.out.println(response.toString());
                }

                responseBody.put("respuesta", jsonResponse);

                // guardo datos en tabla "Api_ReceiveAndSend"
                receiveAndSendService.saveReceiveAndSend(body, jsonResponse.toString(), clientDTO.getDni());

            } else {
                // error
                System.out.println("POST request failed");
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getConfirmOperation(ConfirmOperationDTO confirmOperationDTO) {
        // Solo version de prueba - deshabilitado ssl
        /*
         * try {
         * SSLUtilities.trustAllHttpsCertificates();
         * } catch (Exception e) {
         * // Manejar la excepción
         * }
         */

        Map<String, Object> responseBody = new HashMap<>();

        // Get user and pass
        String userIdicse = parameterService.fetchParamByParameterName("IDICSE-USER");
        String passIdicse = parameterService.fetchParamByParameterName("IDICSE-PASS");

        // Verification entry
        System.out.println(confirmOperationDTO.getNumeroOperacion());
        System.out.println(confirmOperationDTO.getImporteTotal());
        System.out.println(confirmOperationDTO.getCantidadCuotas());
        System.out.println(confirmOperationDTO.getImporteCuota());
        System.out.println(confirmOperationDTO.getFechaPrimerVto());
        System.out.println(confirmOperationDTO.getDni());
        System.out.println(userIdicse);
        System.out.println(passIdicse);

        // JSON send
        String body = "{\"numeroOperacion\": \"" + confirmOperationDTO.getNumeroOperacion() + "\", " +
                "\"importeTotal\": \"" + confirmOperationDTO.getImporteTotal() + "\", " +
                "\"cantidadCuotas\": \"" + confirmOperationDTO.getCantidadCuotas() + "\", " +
                "\"importeCuota\": \"" + confirmOperationDTO.getImporteCuota() + "\", " +
                "\"fechaPrimerVto\": \"" + confirmOperationDTO.getFechaPrimerVto() + "\", " +
                "\"UsuarioId\": \"" + userIdicse + "\", " +
                "\"PasswordClave\":\"" + passIdicse + "\" " +
                "}";

        // verification sent
        System.out.println("Body sent: " + body);

        // Request https://www.idicse.org.ar/pruebaapi/ws/confirmarOperacion - post -
        // Json send
        URL url;
        try {
            url = new URL("https://www.idicse.org.ar/pruebaapi/ws/confirmarOperacion");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Accept", "application/json");
            connection.setDoOutput(true);

            String json = body;
            byte[] postData = json.getBytes(StandardCharsets.UTF_8);

            connection.setRequestProperty("Content-Length", Integer.toString(postData.length));

            try (DataOutputStream wr = new DataOutputStream(connection.getOutputStream())) {
                wr.write(postData);
            }
            int responseCode = connection.getResponseCode();
            System.out.println("Response code: " + responseCode);

            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Get response
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                JSONParser parser = new JSONParser();
                JSONObject jsonResponse = new JSONObject();
                try {
                    jsonResponse = (JSONObject) parser.parse(response.toString());
                } catch (ParseException e) {
                    System.out.println("Error al decodificar respuesta de BIND");
                    System.out.println(response.toString());
                }

                responseBody.put("respuesta", jsonResponse);

                // guardo datos en tabla "Api_ReceiveAndSend"
                receiveAndSendService.saveReceiveAndSend(body, jsonResponse.toString(), confirmOperationDTO.getDni());

            } else {
                // error
                System.out.println("POST request failed");
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getAffectOperation(AffectOperationDTO affectOperationDTO) {
        // Solo version de prueba - deshabilitado ssl
        /*
         * try {
         * SSLUtilities.trustAllHttpsCertificates();
         * } catch (Exception e) {
         * // Manejar la excepción
         * }
         */

        Map<String, Object> responseBody = new HashMap<>();

        // Get user and pass
        String userIdicse = parameterService.fetchParamByParameterName("IDICSE-USER");
        String passIdicse = parameterService.fetchParamByParameterName("IDICSE-PASS");

        // Verification entry
        System.out.println(affectOperationDTO.getNumeroOperacion());
        System.out.println(affectOperationDTO.getImporte());
        System.out.println(affectOperationDTO.getCantidadCuotas());
        System.out.println(affectOperationDTO.getDni());
        System.out.println(userIdicse);
        System.out.println(passIdicse);

        // JSON send
        String body = "{\"numeroOperacion\": \"" + affectOperationDTO.getNumeroOperacion() + "\", " +
                "\"importe\": \"" + affectOperationDTO.getImporte() + "\", " +
                "\"cantidadCuotas\": \"" + affectOperationDTO.getCantidadCuotas() + "\", " +
                "\"UsuarioId\": \"" + userIdicse + "\", " +
                "\"PasswordClave\":\"" + passIdicse + "\" " +
                "}";

        // verification sent
        System.out.println("Body sent: " + body);

        // Request https://www.idicse.org.ar/pruebaapi/ws/afectarOperacion - post - Json
        // send
        URL url;
        try {
            url = new URL("https://www.idicse.org.ar/pruebaapi/ws/afectarOperacion");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Accept", "application/json");
            connection.setDoOutput(true);

            String json = body;
            byte[] postData = json.getBytes(StandardCharsets.UTF_8);

            connection.setRequestProperty("Content-Length", Integer.toString(postData.length));

            try (DataOutputStream wr = new DataOutputStream(connection.getOutputStream())) {
                wr.write(postData);
            }
            int responseCode = connection.getResponseCode();
            System.out.println("Response code: " + responseCode);

            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Get response
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                JSONParser parser = new JSONParser();
                JSONObject jsonResponse = new JSONObject();
                try {
                    jsonResponse = (JSONObject) parser.parse(response.toString());
                } catch (ParseException e) {
                    System.out.println("Error al decodificar respuesta de BIND");
                    System.out.println(response.toString());
                }

                responseBody.put("respuesta", jsonResponse);

                // guardo datos en tabla "Api_ReceiveAndSend"
                receiveAndSendService.saveReceiveAndSend(body, jsonResponse.toString(), affectOperationDTO.getDni());

            } else {
                // error
                System.out.println("POST request failed");
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getUnaffectedOperation(UnaffectedOperationDTO unaffectedOperationDTO) {
        // Solo version de prueba - deshabilitado ssl
        /*
         * try {
         * SSLUtilities.trustAllHttpsCertificates();
         * } catch (Exception e) {
         * // Manejar la excepción
         * }
         */

        Map<String, Object> responseBody = new HashMap<>();

        // Get user and pass
        String userIdicse = parameterService.fetchParamByParameterName("IDICSE-USER");
        String passIdicse = parameterService.fetchParamByParameterName("IDICSE-PASS");

        // Verification entry
        System.out.println(unaffectedOperationDTO.getNumeroOperacion());
        System.out.println(unaffectedOperationDTO.getDni());
        System.out.println(userIdicse);
        System.out.println(passIdicse);

        // JSON send
        String body = "{\"numeroOperacion\": \"" + unaffectedOperationDTO.getNumeroOperacion() + "\", " +
                "\"UsuarioId\": \"" + userIdicse + "\", " +
                "\"PasswordClave\":\"" + passIdicse + "\" " +
                "}";

        // verification sent
        System.out.println("Body sent: " + body);

        // Request https://www.idicse.org.ar/pruebaapi/ws/desafectarOperacion - post -
        // Json send
        URL url;
        try {
            url = new URL("https://www.idicse.org.ar/pruebaapi/ws/desafectarOperacion");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Accept", "application/json");
            connection.setDoOutput(true);

            String json = body;
            byte[] postData = json.getBytes(StandardCharsets.UTF_8);

            connection.setRequestProperty("Content-Length", Integer.toString(postData.length));

            try (DataOutputStream wr = new DataOutputStream(connection.getOutputStream())) {
                wr.write(postData);
            }
            int responseCode = connection.getResponseCode();
            System.out.println("Response code: " + responseCode);

            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Get response
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                JSONParser parser = new JSONParser();
                JSONObject jsonResponse = new JSONObject();
                try {
                    jsonResponse = (JSONObject) parser.parse(response.toString());
                } catch (ParseException e) {
                    System.out.println("Error al decodificar respuesta de BIND");
                    System.out.println(response.toString());
                }

                responseBody.put("respuesta", jsonResponse);

                // guardo datos en tabla "Api_ReceiveAndSend"
                receiveAndSendService.saveReceiveAndSend(body, jsonResponse.toString(),
                        unaffectedOperationDTO.getDni());

            } else {
                // error
                System.out.println("POST request failed");
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }

}

// OBTENER REPORTE
/*
 * {
 * "estado": -9,
 * "mensaje": "Error",
 * "excepcion": "Usuario y/o contraseña incorrecto/s",
 * "datos": null
 * }
 */

/*
 * {
 * "estado": 0,
 * "mensaje": "No se recibieron todos los parámetros requeridos",
 * "excepcion": {
 * "PersonaSexo": [
 * "El campo persona sexo es requerido"
 * ]
 * },
 * "datos": null
 * }
 */

/*
 * Respuesta 38780170
 * {
 * "estado": -3,
 * "mensaje": "Error",
 * "excepcion": "Persona no encontrada",
 * "datos": null
 * }
 */

// CONFIRMAR OPERACION

/*
 * {
 * "response": {
 * "estado": 0,
 * "datos": null,
 * "excepcion": {
 * "importeTotal": [
 * "El campo importe total es requerido"
 * ],
 * "numeroOperacion": [
 * "El campo numero operacion debe ser un número"
 * ],
 * "importeCuota": [
 * "El campo importe cuota es requerido"
 * ],
 * "fechaPrimerVto": [
 * "El campo fecha primer vto es requerido"
 * ],
 * "cantidadCuotas": [
 * "El campo cantidad cuotas es requerido"
 * ]
 * },
 * "mensaje": "No se recibieron todos los parámetros requeridos"
 * }
 * }
 */
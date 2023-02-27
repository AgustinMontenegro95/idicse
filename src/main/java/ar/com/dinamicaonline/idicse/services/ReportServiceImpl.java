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

import ar.com.dinamicaonline.idicse.dto.ClientDTO;
import ar.com.dinamicaonline.idicse.security.SSLUtilities;

@Service
public class ReportServiceImpl implements ReportService{

    @Autowired
    ReceiveAndSendService receiveAndSendService;

    @Override
    public ResponseEntity<?> getClientReport(ClientDTO clientDTO) {
        //Solo version de prueba - deshabilitado ssl
        try {
            SSLUtilities.trustAllHttpsCertificates();
        } catch (Exception e) {
            //Manejar la excepción
        }

        Map<String, Object> responseBody = new HashMap<>();
        
        //Verification entry
        System.out.println(clientDTO.getDni());
        System.out.println(clientDTO.getSexo());

        //JSON send
        String body = "{\"PersonaDNI\": \""+clientDTO.getDni()+"\", "+
            "\"PersonaSexo\": \""+clientDTO.getSexo()+"\", "+
            "\"UsuarioId\": \"dinamicawse\", "+
            "\"PasswordClave\":\"1234567890\" "+
            "}";

        //verification sent
        System.out.println("Body sent: " + body);

        //Request https://www.idicse.org.ar/pruebaapi/ws/crearInforme - post - Json send
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
            
            if(responseCode == HttpURLConnection.HTTP_OK){
                //Get response
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

                responseBody.put("response", jsonResponse);

                //guardo datos en tabla "Api_ReceiveAndSend"
                receiveAndSendService.saveReceiveAndSend(body, jsonResponse.toString(), clientDTO.getDni());

            } else {
                //error
                System.out.println("POST request failed");
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new ResponseEntity<>(responseBody,  HttpStatus.OK);
    }

    
}

    /* 
       {
    "estado": -9,
    "mensaje": "Error",
    "excepcion": "Usuario y/o contraseña incorrecto/s",
    "datos": null
}
     */

/* 
    {
    "estado": 0,
    "mensaje": "No se recibieron todos los parámetros requeridos",
    "excepcion": {
        "PersonaSexo": [
            "El campo persona sexo es requerido"
        ]
    },
    "datos": null
}
 */

/* 
    Respuesta 38780170
 {
    "estado": -3,
    "mensaje": "Error",
    "excepcion": "Persona no encontrada",
    "datos": null
}
 */
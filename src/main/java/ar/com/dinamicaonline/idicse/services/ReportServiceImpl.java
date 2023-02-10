package ar.com.dinamicaonline.idicse.services;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.nio.charset.StandardCharsets;
//import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import ar.com.dinamicaonline.idicse.dto.ClientDTO;
import ar.com.dinamicaonline.idicse.models.Persona;

@Service
public class ReportServiceImpl implements ReportService{

    @Override
    public ResponseEntity<?> getClientReport(ClientDTO clientDTO) {
        Map<String, Object> responseBody = new HashMap<>();

        //JSON send
        Map<String, Object> sendBody = new HashMap<>();
        sendBody.put("PersonaDNI", clientDTO.getDni());
        sendBody.put("PersonaSexo", clientDTO.getSexo());
        sendBody.put("UsuarioId", "dinamicawse");
        sendBody.put("PasswordClave", "geor7ivwR3"); 
        //Request https://www.idicse.org.ar/pruebaweb/ws/crearInforme - post - Json send
        URL url;
        try {
            url = new URL("https://www.idicse.org.ar/pruebaweb/ws/crearInforme");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Accept", "application/json");
            connection.setDoOutput(true);

            /* String username = "dinamicawse";
            String password = "geor7ivwR3";

            String auth = username + ":" + password;
            byte[] encodedAuth = Base64.getEncoder().encode(auth.getBytes(StandardCharsets.UTF_8));
            String authHeaderValue = "Basic " + new String(encodedAuth);
            connection.setRequestProperty("Authorization", authHeaderValue); */

            String json = sendBody.toString();
            byte[] postData = json.getBytes(StandardCharsets.UTF_8);

            connection.setRequestProperty("Content-Length", Integer.toString(postData.length));

            try (DataOutputStream wr = new DataOutputStream(connection.getOutputStream())) {
                wr.write(postData);
            }
            int responseCode = connection.getResponseCode();
            System.out.println("Response code: " + responseCode);
            
            if(responseCode == HttpURLConnection.HTTP_OK){
                //obtener respuesta
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                ObjectMapper mapper = new ObjectMapper();

                Persona persona = mapper.readValue(response.toString(), Persona.class);

                System.out.println("Nombre: " + persona.getPersonaNombre());
                System.out.println("Apellido: " + persona.getPersonaApellido());

                responseBody.put("Nombre: " , persona.getPersonaNombre());
                responseBody.put("Apellido: " , persona.getPersonaApellido());

                System.out.println(response.toString());
            } else {
                //error
                System.out.println("POST request failed");
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        responseBody.put("Agustin" , "Hola");

        return new ResponseEntity<>(responseBody,  HttpStatus.OK);
    }

    
}

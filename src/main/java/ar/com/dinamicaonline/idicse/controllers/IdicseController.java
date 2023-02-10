package ar.com.dinamicaonline.idicse.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ar.com.dinamicaonline.idicse.dto.ClientDTO;
import ar.com.dinamicaonline.idicse.services.ReportService;

@RestController
@RequestMapping("/api/v1")
public class IdicseController {

    @Autowired
    private ReportService reportService;
    
    @RequestMapping(value = "/obtener_informe", method = RequestMethod.POST)
    public ResponseEntity<?> obtenerConsulta(@RequestBody ClientDTO clientDTO) {
        return reportService.getClientReport(clientDTO);
    }
}

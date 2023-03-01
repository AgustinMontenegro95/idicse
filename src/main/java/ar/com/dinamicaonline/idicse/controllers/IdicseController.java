package ar.com.dinamicaonline.idicse.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ar.com.dinamicaonline.idicse.dto.GetReportDTO;
import ar.com.dinamicaonline.idicse.dto.UnaffectedOperationDTO;
import ar.com.dinamicaonline.idicse.dto.AffectOperationDTO;
import ar.com.dinamicaonline.idicse.dto.ConfirmOperationDTO;
import ar.com.dinamicaonline.idicse.services.ReportService;

@RestController
@RequestMapping("/api/v1")
public class IdicseController {

    @Autowired
    private ReportService reportService;
    
    @RequestMapping(value = "/obtener_informe", method = RequestMethod.POST)
    public ResponseEntity<?> obtenerInforme(@RequestBody GetReportDTO clientDTO) {
        return reportService.getClientReport(clientDTO);
    }

    @RequestMapping(value = "/confirmar_operacion", method = RequestMethod.POST)
    public ResponseEntity<?> confirmarOperacion(@RequestBody ConfirmOperationDTO confirmOperationDTO) {
        return reportService.getConfirmOperation(confirmOperationDTO);
    }

    @RequestMapping(value = "/afectar_operacion", method = RequestMethod.POST)
    public ResponseEntity<?> afectarOperacion(@RequestBody AffectOperationDTO affectOperationDTO) {
        return reportService.getAffectOperation(affectOperationDTO);
    }
    
    @RequestMapping(value = "/desafectar_operacion", method = RequestMethod.POST)
    public ResponseEntity<?> desafectarOperacion(@RequestBody UnaffectedOperationDTO unaffectedOperationDTO) {
        return reportService.getUnaffectedOperation(unaffectedOperationDTO);
    }

}

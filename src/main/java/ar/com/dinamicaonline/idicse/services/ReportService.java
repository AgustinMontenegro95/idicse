package ar.com.dinamicaonline.idicse.services;

import org.springframework.http.ResponseEntity;

import ar.com.dinamicaonline.idicse.dto.GetReportDTO;
import ar.com.dinamicaonline.idicse.dto.UnaffectedOperationDTO;
import ar.com.dinamicaonline.idicse.dto.AffectOperationDTO;
import ar.com.dinamicaonline.idicse.dto.ConfirmOperationDTO;

public interface ReportService {
    
    ResponseEntity<?> getClientReport(GetReportDTO clientDTO);

    ResponseEntity<?> getConfirmOperation(ConfirmOperationDTO confirmOperationDTO);

    ResponseEntity<?> getAffectOperation(AffectOperationDTO affectOperationDTO);
    
    ResponseEntity<?> getUnaffectedOperation(UnaffectedOperationDTO unaffectedOperationDTO);

}

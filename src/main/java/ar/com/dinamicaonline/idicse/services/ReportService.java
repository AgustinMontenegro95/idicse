package ar.com.dinamicaonline.idicse.services;

import org.springframework.http.ResponseEntity;

import ar.com.dinamicaonline.idicse.dto.ClientDTO;

public interface ReportService {
    
    ResponseEntity<?> getClientReport(ClientDTO clientDTO);
}

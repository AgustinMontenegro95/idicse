package ar.com.dinamicaonline.idicse.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.dinamicaonline.idicse.repositories.EntidadRepository;


@Service
public class EntidadServiceImpl implements EntidadService {

    @Autowired
    private EntidadRepository entidadRepository;

    @Override
    public Long fetchEntidadByDocumentId(String customerId) {
        return entidadRepository.findByDocumentId(customerId);
    }
    

}
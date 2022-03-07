package com.fina.fina.service;

import java.util.List;

import com.fina.fina.model.TempDocumentNewCustomer;
import com.fina.fina.repository.DocumentNewCustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DocumentNewCustomerService {
    @Autowired
    DocumentNewCustomerRepository documentNewCustomerRepository;

    public void saveDocument(TempDocumentNewCustomer tempDocumentNewCustomer) {
        documentNewCustomerRepository.save(tempDocumentNewCustomer);
    }

    public List<TempDocumentNewCustomer> getDataById(int id_new_customer) {
        return documentNewCustomerRepository.findByNoKontrak(id_new_customer);
    }

}

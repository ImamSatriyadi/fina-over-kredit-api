package com.fina.fina.repository;

import java.util.List;

import com.fina.fina.model.TempDocumentNewCustomer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DocumentNewCustomerRepository extends JpaRepository<TempDocumentNewCustomer, Integer> {
    @Query(value = "Select * FROM public_temp_document_new_customer where id_customer=?1", nativeQuery = true)
    List<TempDocumentNewCustomer> findByNoKontrak(int id_new_customer);
}

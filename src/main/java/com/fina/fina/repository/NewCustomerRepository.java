package com.fina.fina.repository;

import java.util.Optional;

import javax.transaction.Transactional;

import com.fina.fina.DTO.request.NewCustomerDTO;
import com.fina.fina.model.TempNewCustomer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface NewCustomerRepository extends JpaRepository<TempNewCustomer, Integer> {

    @Query(value = "Select * FROM public_temp_new_customer where old_customer=?1", nativeQuery = true)
    Optional<TempNewCustomer> findByNoKontrak(String no_kontrak);

    @Transactional
    @Modifying
    @Query(value = "UPDATE public_temp_new_customer set old_customer=?1  where nik=?2", nativeQuery = true)
    public void updateOldCustomer(String no_kontrak, String nik);

    @Transactional
    @Modifying
    @Query(value = "UPDATE public_temp_new_customer SET status_apply='commit' where old_customer=?1", nativeQuery = true)
    public void commit(String no_kontrak);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM public_temp_new_customer where status_apply='not-commit'", nativeQuery = true)
    public void rollBack();

}

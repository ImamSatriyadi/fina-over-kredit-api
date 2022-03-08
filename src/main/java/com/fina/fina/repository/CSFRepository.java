package com.fina.fina.repository;

import java.util.List;

import javax.transaction.Transactional;

import com.fina.fina.model.CSF;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface CSFRepository extends JpaRepository<CSF, String> {
    @Modifying
    @Query(value = "SELECT * FROM public_csf WHERE email_user=?1", nativeQuery = true)
    List<CSF> findByEmail(String email);

    @Transactional
    @Modifying
    @Query(value = "UPDATE public_csf SET pengajuan_overkredit=?1 where no_kontrak=?2", nativeQuery = true)
    public void updateStatusPengajuan(String status, String no_kontrak);
}

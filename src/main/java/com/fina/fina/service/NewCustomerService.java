package com.fina.fina.service;

import java.util.List;
import java.util.Optional;

import com.fina.fina.DTO.request.NewCustomerDTO;
import com.fina.fina.model.TempNewCustomer;
import com.fina.fina.repository.NewCustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class NewCustomerService {
    @Autowired
    NewCustomerRepository newCustomerRepository;

    public ResponseEntity<?> saveCustomer(NewCustomerDTO newCustomerDTO) {
        // int id, String nik, String nama, String alamat, String provinsi, String kota,
        // String kabupaten, String no_telp, String no_telp2, String email, String
        // no_rek_bca, String keterangan,
        // String status_apply

        TempNewCustomer tempNewCustomer = new TempNewCustomer(
                newCustomerDTO.getNik(), newCustomerDTO.getNama(), newCustomerDTO.getAlamat(),
                newCustomerDTO.getProvinsi(), newCustomerDTO.getKota(), newCustomerDTO.getKabupaten(),
                newCustomerDTO.getNo_telp(), newCustomerDTO.getNo_telp2(), newCustomerDTO.getEmail(),
                newCustomerDTO.getNo_rek_bca(), newCustomerDTO.getKeterangan(), newCustomerDTO.getStatus_apply());
        newCustomerRepository.save(tempNewCustomer);
        newCustomerRepository.updateOldCustomer(newCustomerDTO.getNo_kontrak(), newCustomerDTO.getNik());

        return ResponseEntity.ok(newCustomerDTO);
    }

    public void rollBack() {
        newCustomerRepository.rollBack();
    }

    public void commit(String no_kontrak) {
        newCustomerRepository.commit(no_kontrak);
    }

    public Optional<TempNewCustomer> findByNoKontrak(String no_kontrak) {

        return newCustomerRepository.findByNoKontrak(no_kontrak);
    }

    public Optional<String> findNoKontrak(int id) {

        return newCustomerRepository.finNoKontrak(id);
    }

    public Optional<Integer> findIdNoKontrak(String no_kontrak) {

        return newCustomerRepository.finIdKontrak(no_kontrak);
    }

    public List<TempNewCustomer> showData() {
        return newCustomerRepository.findAll();
    }

    public Optional<TempNewCustomer> showById(int id) {
        return newCustomerRepository.findById(id);
    }
}

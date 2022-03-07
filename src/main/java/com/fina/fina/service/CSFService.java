package com.fina.fina.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.fina.fina.DTO.response.PerhitunganDTO;
import com.fina.fina.model.CSF;
import com.fina.fina.repository.CSFRepository;

import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CSFService {
    @Autowired
    CSFRepository csfRepository;

    public List<CSF> getAll(String email) {
        return csfRepository.findByEmail(email);
    }

    public PerhitunganDTO getperhitungan(String no_kontrak) {
        Optional<CSF> dataCsf = csfRepository.findById(no_kontrak);
        Date nextJatuhTempo = DateUtils.addMonths(dataCsf.get().getTgl_jatuh_tempo(), 1);
        Date cal = new Date();
        Double denda = (double) 0;
        Double effectiveRate = (rate(dataCsf.get().getSisa_tenor(), dataCsf.get().getAngsuran(),
                dataCsf.get().getSisa_outstanding()) * 12) * (-2);

        Long difTime = cal.getTime() - nextJatuhTempo.getTime();
        Long difDay = (difTime / (1000 * 60 * 60 * 24)) % 365;

        if (difDay > 0) {
            denda = 0.004 * dataCsf.get().getAngsuran() * difDay.doubleValue();
        }

        PerhitunganDTO dataPerhitunganDTO = new PerhitunganDTO(dataCsf.get().getSisa_outstanding(),
                dataCsf.get().getAngsuran(),
                dataCsf.get().getOTR(),
                effectiveRate,
                denda,
                biayaAdmin(dataCsf.get().getSisa_outstanding()),
                dataCsf.get().getSisa_tenor(),
                cal,
                dataCsf.get().getTenor(),
                dataCsf.get().getDeposit(),
                dataCsf.get().getGantungan_pengurusan(),
                dataCsf.get().getGantungan_asuransi());
        return dataPerhitunganDTO;
    }

    public Double biayaAdmin(Double outstanding) {
        Double admin = (double) 0;
        if (outstanding <= 100000000) {
            admin = (double) 705000;
        } else if (outstanding > 100000000 && outstanding <= 250000000) {
            admin = (double) 905000;
        } else if (outstanding > 250000000 && outstanding <= 1000000000) {
            admin = (double) 1155000;
        } else if (outstanding > 1000000000) {
            admin = (double) 1655000;
        }
        return admin;
    }

    public static double rate(double nper, double pmt, double pv) {
        double rate = (2.0 * (nper * pmt - (-pv))) / ((-pv) * nper);

        return rate;
    }

    public void updateStatusPengajuan(String no_kontrak) {
        csfRepository.updateStatusPengajuan(no_kontrak);
    }

    public Optional<CSF> findById(String no_kontrak) {
        return csfRepository.findById(no_kontrak);
    }
}

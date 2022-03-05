package com.fina.fina.DTO.response;

import java.util.Date;

public class PerhitunganDTO {
    private Double sisaOutstanding, angsuran, OTR, efectiveRate, denda, admin, deposit, gantungan_pengurusan,
            gantungan_asuransi;
    private int sisaTenor, tenor;
    private Date tanggal;

    public PerhitunganDTO(Double sisaOutstanding, Double angsuran, Double oTR, Double efectiveRate, Double denda,
            Double admin, int sisaTenor, Date tanggal, int tenor, Double deposit, Double gantungan_pengurusan,
            Double gantungan_asuransi) {
        this.sisaOutstanding = sisaOutstanding;
        this.angsuran = angsuran;
        OTR = oTR;
        this.efectiveRate = efectiveRate;
        this.denda = denda;
        this.admin = admin;
        this.sisaTenor = sisaTenor;
        this.tanggal = tanggal;
        this.tenor = tenor;
        this.deposit = deposit;
        this.gantungan_pengurusan = gantungan_pengurusan;
        this.gantungan_asuransi = gantungan_asuransi;
    }

    public Double getDeposit() {
        return deposit;
    }

    public void setDeposit(Double deposit) {
        this.deposit = deposit;
    }

    public Double getGantungan_pengurusan() {
        return gantungan_pengurusan;
    }

    public void setGantungan_pengurusan(Double gantungan_pengurusan) {
        this.gantungan_pengurusan = gantungan_pengurusan;
    }

    public Double getGantungan_asuransi() {
        return gantungan_asuransi;
    }

    public void setGantungan_asuransi(Double gantungan_asuransi) {
        this.gantungan_asuransi = gantungan_asuransi;
    }

    public int getTenor() {
        return tenor;
    }

    public void setTenor(int tenor) {
        this.tenor = tenor;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }

    public Double getSisaOutstanding() {
        return sisaOutstanding;
    }

    public void setSisaOutstanding(Double sisaOutstanding) {
        this.sisaOutstanding = sisaOutstanding;
    }

    public Double getAngsuran() {
        return angsuran;
    }

    public void setAngsuran(Double angsuran) {
        this.angsuran = angsuran;
    }

    public Double getOTR() {
        return OTR;
    }

    public void setOTR(Double oTR) {
        OTR = oTR;
    }

    public Double getEfectiveRate() {
        return efectiveRate;
    }

    public void setEfectiveRate(Double efectiveRate) {
        this.efectiveRate = efectiveRate;
    }

    public Double getDenda() {
        return denda;
    }

    public void setDenda(Double denda) {
        this.denda = denda;
    }

    public int getSisaTenor() {
        return sisaTenor;
    }

    public void setSisaTenor(int sisaTenor) {
        this.sisaTenor = sisaTenor;
    }

    public Double getAdmin() {
        return admin;
    }

    public void setAdmin(Double admin) {
        this.admin = admin;
    }

}

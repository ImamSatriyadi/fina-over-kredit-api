package com.fina.fina.DTO.request;

public class NewCustomerDTO {
    private String nama;
    private String nik;
    private String alamat;
    private String provinsi;
    private String kota;
    private String kabupaten;
    private String no_telp;
    private String no_telp2;
    private String email;
    private String no_rek_bca;
    private String keterangan;
    private String status_apply;
    private String no_kontrak;

    public NewCustomerDTO() {

    }

    public NewCustomerDTO(String nama, String nik, String alamat, String provinsi, String kota, String kabupaten,
            String no_telp, String no_telp2, String email, String no_rek_bca, String keterangan, String status_apply,
            String no_kontrak) {
        this.nama = nama;
        this.nik = nik;
        this.alamat = alamat;
        this.provinsi = provinsi;
        this.kota = kota;
        this.kabupaten = kabupaten;
        this.no_telp = no_telp;
        this.no_telp2 = no_telp2;
        this.email = email;
        this.no_rek_bca = no_rek_bca;
        this.keterangan = keterangan;
        this.status_apply = status_apply;
        this.no_kontrak = no_kontrak;
    }

    public String getNo_kontrak() {
        return no_kontrak;
    }

    public void setNo_kontrak(String no_kontrak) {
        this.no_kontrak = no_kontrak;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getProvinsi() {
        return provinsi;
    }

    public void setProvinsi(String provinsi) {
        this.provinsi = provinsi;
    }

    public String getKota() {
        return kota;
    }

    public void setKota(String kota) {
        this.kota = kota;
    }

    public String getKabupaten() {
        return kabupaten;
    }

    public void setKabupaten(String kabupaten) {
        this.kabupaten = kabupaten;
    }

    public String getNo_telp() {
        return no_telp;
    }

    public void setNo_telp(String no_telp) {
        this.no_telp = no_telp;
    }

    public String getNo_telp2() {
        return no_telp2;
    }

    public void setNo_telp2(String no_telp2) {
        this.no_telp2 = no_telp2;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNo_rek_bca() {
        return no_rek_bca;
    }

    public void setNo_rek_bca(String no_rek_bca) {
        this.no_rek_bca = no_rek_bca;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public String getStatus_apply() {
        return status_apply;
    }

    public void setStatus_apply(String status_apply) {
        this.status_apply = status_apply;
    }

}

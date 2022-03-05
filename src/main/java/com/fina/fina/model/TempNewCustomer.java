package com.fina.fina.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "public.Temp_New_Customer")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "id_customer", "id_customers", "old_customer" })
public class TempNewCustomer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "nik")
    private String nik;

    @Column(name = "nama")
    private String nama;

    @Column(name = "alamat")
    private String alamat;

    @Column(name = "provinsi")
    private String provinsi;

    @Column(name = "kota")
    private String kota;

    @Column(name = "kabupaten")
    private String kabupaten;

    @Column(name = "no_telp")
    private String no_telp;

    @Column(name = "no_telp2")
    private String no_telp2;

    @Column(name = "email")
    private String email;

    @Column(name = "no_rek_bca")
    private String no_rek_bca;

    @Column(name = "keterangan")
    private String keterangan;

    @Column(name = "status_apply")
    private String status_apply;

    @OneToMany(mappedBy = "id_customer", cascade = CascadeType.ALL)
    private List<TempDocumentNewCustomer> id_customer;

    @OneToMany(mappedBy = "id_customers", cascade = CascadeType.ALL)
    private List<TempVehicle> id_customers;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "old_customer")
    private CSF old_customer;

    public TempNewCustomer() {

    }

    public TempNewCustomer(String nik, String nama, String alamat, String provinsi, String kota,
            String kabupaten, String no_telp, String no_telp2, String email, String no_rek_bca, String keterangan,
            String status_apply) {
        this.nik = nik;
        this.nama = nama;
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
    }

    public TempNewCustomer(int id) {
        this.id = id;
    }

    public List<TempDocumentNewCustomer> getId_customer() {
        return id_customer;
    }

    public void setId_customer(List<TempDocumentNewCustomer> id_customer) {
        this.id_customer = id_customer;
    }

    public List<TempVehicle> getId_customers() {
        return id_customers;
    }

    public void setId_customers(List<TempVehicle> id_customers) {
        this.id_customers = id_customers;
    }

    public CSF getOld_customer() {
        return old_customer;
    }

    public void setOld_customer(CSF old_customer) {
        this.old_customer = old_customer;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public String getStatus_apply() {
        return status_apply;
    }

    public void setStatus_apply(String status_apply) {
        this.status_apply = status_apply;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
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

    @Override
    public String toString() {
        return "TempNewCustomer [alamat=" + alamat + ", email=" + email + ", id=" + id + ", kabupaten=" + kabupaten
                + ", keterangan=" + keterangan + ", kota=" + kota + ", nama=" + nama + ", no_rek_bca=" + no_rek_bca
                + ", no_telp=" + no_telp + ", no_telp2=" + no_telp2 + ", provinsi=" + provinsi + "]";
    }

}

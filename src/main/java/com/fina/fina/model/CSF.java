package com.fina.fina.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "public.CSF")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "newCustomer" })
public class CSF {
    @Id
    @Column(name = "no_kontrak")
    private String no_kontrak;

    @Column(name = "nama")
    private String nama;

    @Column(name = "no_telepon")
    private String no_telepon;

    @Column(name = "loan_status")
    private String loan_status;

    @Column(name = "merk")
    private String merk;

    @Column(name = "type")
    private String type;

    @Column(name = "tahun_kendaraan")
    private String tahun_kendaraan;

    @Column(name = "no_polisi")
    private String no_polisi;

    @Column(name = "OTR")
    private Double OTR;

    @Column(name = "sisa_outstanding")
    private Double sisa_outstanding;

    @Column(name = "sisa_tenor")
    private int sisa_tenor;

    @Column(name = "tenor")
    private int tenor;

    @Column(name = "gantungan_pengurusan")
    private Double gantungan_pengurusan;

    @Column(name = "gantungan_asuransi")
    private Double gantungan_asuransi;

    @Column(name = "deposit")
    private Double deposit;

    @Column(name = "angsuran")
    private Double angsuran;

    @Column(name = "tgl_jatuh_tempo")
    private Date tgl_jatuh_tempo;

    @Column(name = "pengajuan_overkredit")
    private String pengajuan_overkredit;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "email_user", nullable = false)
    private UserFina email_user;

    @OneToOne(mappedBy = "old_customer", cascade = CascadeType.ALL)
    private TempNewCustomer newCustomer;

    public CSF() {

    }

    public String getPengajuan_overkredit() {
        return pengajuan_overkredit;
    }

    public void setPengajuan_overkredit(String pengajuan_overkredit) {
        this.pengajuan_overkredit = pengajuan_overkredit;
    }

    public CSF(String no_kontrak) {
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

    public String getNo_telepon() {
        return no_telepon;
    }

    public void setNo_telepon(String no_telepon) {
        this.no_telepon = no_telepon;
    }

    public String getLoan_status() {
        return loan_status;
    }

    public void setLoan_status(String loan_status) {
        this.loan_status = loan_status;
    }

    public String getMerk() {
        return merk;
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTahun_kendaraan() {
        return tahun_kendaraan;
    }

    public void setTahun_kendaraan(String tahun_kendaraan) {
        this.tahun_kendaraan = tahun_kendaraan;
    }

    public String getNo_polisi() {
        return no_polisi;
    }

    public void setNo_polisi(String no_polisi) {
        this.no_polisi = no_polisi;
    }

    public Double getSisa_outstanding() {
        return sisa_outstanding;
    }

    public void setSisa_outstanding(Double sisa_outstanding) {
        this.sisa_outstanding = sisa_outstanding;
    }

    public int getSisa_tenor() {
        return sisa_tenor;
    }

    public void setSisa_tenor(int sisa_tenor) {
        this.sisa_tenor = sisa_tenor;
    }

    public Double getAngsuran() {
        return angsuran;
    }

    public void setAngsuran(Double angsuran) {
        this.angsuran = angsuran;
    }

    public UserFina getEmail_user() {
        return email_user;
    }

    public void setEmail_user(UserFina email_user) {
        this.email_user = email_user;
    }

    public Date getTgl_jatuh_tempo() {
        return tgl_jatuh_tempo;
    }

    public void setTgl_jatuh_tempo(Date tgl_jatuh_tempo) {
        this.tgl_jatuh_tempo = tgl_jatuh_tempo;
    }

    public Double getOTR() {
        return OTR;
    }

    public void setOTR(Double oTR) {
        OTR = oTR;
    }

    public int getTenor() {
        return tenor;
    }

    public void setTenor(int tenor) {
        this.tenor = tenor;
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

    public Double getDeposit() {
        return deposit;
    }

    public void setDeposit(Double deposit) {
        this.deposit = deposit;
    }

    @Override
    public String toString() {
        return "CSF [OTR=" + OTR + ", angsuran=" + angsuran + ", deposit=" + deposit + ", email_user=" + email_user
                + ", gantungan_asuransi=" + gantungan_asuransi + ", gantungan_pengurusan=" + gantungan_pengurusan
                + ", loan_status=" + loan_status + ", merk=" + merk + ", nama=" + nama + ", newCustomer=" + newCustomer
                + ", no_kontrak=" + no_kontrak + ", no_polisi=" + no_polisi + ", no_telepon=" + no_telepon
                + ", sisa_outstanding=" + sisa_outstanding + ", sisa_tenor=" + sisa_tenor + ", tahun_kendaraan="
                + tahun_kendaraan + ", tenor=" + tenor + ", tgl_jatuh_tempo=" + tgl_jatuh_tempo + ", type=" + type
                + "]";
    }

    public TempNewCustomer getNewCustomer() {
        return newCustomer;
    }

    public void setNewCustomer(TempNewCustomer newCustomer) {
        this.newCustomer = newCustomer;
    }

}

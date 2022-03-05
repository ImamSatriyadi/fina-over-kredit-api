package com.fina.fina.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "public.Temp_Vehicle")
public class TempVehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "merk")
    private String merk;

    @Column(name = "type")
    private String type;

    @Column(name = "no_polisi")
    private String no_polisi;

    @Column(name = "tahun")
    private int tahun;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_customers", nullable = false)
    private TempNewCustomer id_customers;

    public TempVehicle() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getNo_polisi() {
        return no_polisi;
    }

    public void setNo_polisi(String no_polisi) {
        this.no_polisi = no_polisi;
    }

    public int getTahun() {
        return tahun;
    }

    public void setTahun(int tahun) {
        this.tahun = tahun;
    }

    public TempNewCustomer getId_customers() {
        return id_customers;
    }

    public void setId_customers(TempNewCustomer id_customers) {
        this.id_customers = id_customers;
    }

    @Override
    public String toString() {
        return "TempVehicle [id=" + id + ", id_customers=" + id_customers + ", merk=" + merk + ", no_polisi="
                + no_polisi + ", tahun=" + tahun + ", type=" + type + "]";
    }

}

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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "public.Temp_Document_New_Customer")
@JsonIgnoreProperties
public class TempDocumentNewCustomer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "path_doc")
    private String path_doc;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_customer", nullable = false)
    private TempNewCustomer id_customer;

    public TempDocumentNewCustomer() {

    }

    public TempDocumentNewCustomer(String path_doc, int id_customer) {
        this.path_doc = path_doc;
        this.id_customer = new TempNewCustomer(id_customer);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPath_doc() {
        return path_doc;
    }

    public void setPath_doc(String path_doc) {
        this.path_doc = path_doc;
    }

    public TempNewCustomer getId_customer() {
        return id_customer;
    }

    public void setId_customer(TempNewCustomer id_customer) {
        this.id_customer = id_customer;
    }

    @Override
    public String toString() {
        return "TempDocumentNewCustomer [id=" + id + ", id_customer=" + id_customer + ", path_doc=" + path_doc + "]";
    }

}

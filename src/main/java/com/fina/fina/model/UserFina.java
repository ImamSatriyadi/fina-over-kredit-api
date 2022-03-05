package com.fina.fina.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "public.User_Fina")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "email_user" })
public class UserFina {
    @Id
    private String email;

    @Column(name = "password")
    private String password;

    @OneToMany(mappedBy = "email_user", cascade = CascadeType.ALL)
    private List<CSF> email_user;

    public UserFina() {

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserFina [email=" + email + ", password=" + password + "]";
    }

}

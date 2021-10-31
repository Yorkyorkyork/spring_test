package com.example.demo.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "email_verify")
public class EmailDTO {

    @Id
    @Column(name = "email", nullable = false)
    private String email;
    @Column(name = "verify", nullable = false, length = 10)
    private String verify;
    @Column(name = "status", nullable = false)
    private Integer status;


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getVerify() {
        return verify;
    }

    public void setVerify(String vertify) {
        this.verify = vertify;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

}


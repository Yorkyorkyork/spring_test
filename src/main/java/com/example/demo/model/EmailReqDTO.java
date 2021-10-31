package com.example.demo.model;

import javax.validation.constraints.Email;

public class EmailReqDTO {

    @Email
    private String email;

    private String verify;

    public String getVerify(){ return verify; }

    public void setVerify(String verify){ this.verify = verify; }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

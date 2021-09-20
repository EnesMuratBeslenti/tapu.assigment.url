package com.example.demo.Core.entities.dtos;

public class UserLoginDto {
    private String mail;
    private String password;

    public UserLoginDto(String mail, String password) {
        this.mail = mail;
        this.password = password;
    }

    public UserLoginDto() {
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}

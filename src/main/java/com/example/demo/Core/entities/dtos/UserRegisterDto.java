package com.example.demo.Core.entities.dtos;

import com.sun.istack.NotNull;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

public class UserRegisterDto  {

    @NotNull
    @Size(min = 3,max = 50,message = "Firstname en az 3 en fazla 50 karekterden oluşmalıdır")
    private  String firstName;

    @NotNull
    @Size(min = 3, max = 50 , message = "Lastname en az 3 en fazla 50 karakterden oluşmalıdır.")
    private String  lastName;

    @Email
    private String  mail;

    @NotNull
    @Size(min = 5 , max = 15, message = "Şifre en az 5 en fazla 15 karakterden oluşmalıdır.")
    private String password;

    public UserRegisterDto(String firstName, String lastName, String mail, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.mail = mail;
        this.password = password;
    }

    public UserRegisterDto() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

package com.example.demo.Core.entities.concretes;

import com.example.demo.Entities.concretes.Url;
import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "Users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Size(min = 3,max = 50,message = "Firstname en az 3 en fazla 50 karekterden oluşmalıdır")
    private String firstName;
    @NotNull
    @Size(min = 3, max = 50 , message = "Lastname en az 3 en fazla 50 karakterden oluşmalıdır.")
    private String lastName;
    @Email
    @Column(name = "mail",unique = true)
    private String mail;
    @NotNull
    @Size(min = 5 , max = 15, message = "Şifre en az 5 en fazla 15 karakterden oluşmalıdır.")
    private String password;

    @OneToMany(mappedBy = "user")
    private List<Url> urls;

    public User() {
    }

    public User(String firstName, String lastName, String mail, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.mail = mail;
        this.password = password;
    }

    public User(Long id, String firstName, String lastName, String mail, String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mail = mail;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", mail='" + mail + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

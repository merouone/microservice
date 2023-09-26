package com.app.microservice.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


import java.time.LocalDate;
import java.util.Date;

/**
 * User Entity model.
 * It is responsible for all the interactions with the database.
 */
@Entity
@Table(name = "airfrance_user")
public class User {



    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;


    @NotBlank(message = "Name is mandatory")
    private String name;

    @NotNull(message = "Birthday is mandatory")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate birthday;

    @NotBlank(message = "Residence is mandatory")
    private String residence;

    private String phone;

    private boolean gender;

    public User() {
    }

    public User(long id) {
        this.id = id;
    }

    public User(String name, LocalDate birthday, String residence) {
        this.name = name;
        this.birthday = birthday;
        this.residence = residence;
    }

    public User(long id, String name, LocalDate birthday, String residence) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.residence = residence;
    }

    public User(String name, LocalDate birthday, String residence, String phone) {
        this.name = name;
        this.birthday = birthday;
        this.residence = residence;
        this.phone = phone;
    }

    public User(String name, LocalDate birthday, String residence, String phone, boolean gender) {
        this.name = name;
        this.birthday = birthday;
        this.residence = residence;
        this.phone = phone;
        this.gender = gender;
    }

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getResidence() {
        return residence;
    }

    public void setResidence(String residence) {
        this.residence = residence;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean getGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                ", residence='" + residence + '\'' +
                ", phone='" + phone + '\'' +
                ", gender=" + gender +
                '}';
    }
}

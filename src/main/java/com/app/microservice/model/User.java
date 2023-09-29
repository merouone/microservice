package com.app.microservice.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

/**
 * User Entity model.
 * It is responsible for all the interactions with the database.
 */
@Entity
@Table(name = "app_user")
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @NotBlank(message = "Name is mandatory")
    private String name;

    @NotNull(message = "Birthday is mandatory")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthday;

    @NotBlank(message = "Residence is mandatory")
    private String residence;

    private String phone;

    private boolean gender;

    /**
     * Default constructor
     */
    public User() {
    }

    /**
     * Constructor with one parameter.
     *
     * @param id
     */
    public User(long id) {
        this.id = id;
    }

    /**
     * Constructor with 3 params
     *
     * @param name
     * @param birthday
     * @param residence
     */
    public User(String name, LocalDate birthday, String residence) {
        this.name = name;
        this.birthday = birthday;
        this.residence = residence;
    }

    /**
     * Constructor with 4 params
     *
     * @param id
     * @param name
     * @param birthday
     * @param residence
     */
    public User(long id, String name, LocalDate birthday, String residence) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.residence = residence;
    }

    /**
     * Constructor with all params, except the id
     *
     * @param name
     * @param birthday
     * @param residence
     * @param phone
     */
    public User(String name, LocalDate birthday, String residence, String phone) {
        this.name = name;
        this.birthday = birthday;
        this.residence = residence;
        this.phone = phone;
    }

    /**
     * Constructor with all params
     *
     * @param name
     * @param birthday
     * @param residence
     * @param phone
     * @param gender
     */
    public User(String name, LocalDate birthday, String residence, String phone, boolean gender) {
        this.name = name;
        this.birthday = birthday;
        this.residence = residence;
        this.phone = phone;
        this.gender = gender;
    }

    /**
     * Constructor with only the user name
     *
     * @param name
     */
    public User(String name) {
        this.name = name;
    }

    /**
     * Get the user name
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Set the user name
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get user birthday
     *
     * @return
     */
    public LocalDate getBirthday() {
        return birthday;
    }

    /**
     * Set the user birthday
     *
     * @param birthday
     */
    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    /**
     * get User residence
     *
     * @return
     */
    public String getResidence() {
        return residence;
    }

    /**
     * Set User residence
     *
     * @param residence
     */
    public void setResidence(String residence) {
        this.residence = residence;
    }

    /**
     * Get the user phone
     *
     * @return
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Set the user phone
     *
     * @param phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Get the user gender
     *
     * @return
     */
    public boolean getGender() {
        return gender;
    }

    /**
     * Set the user gender
     *
     * @param gender
     */
    public void setGender(boolean gender) {
        this.gender = gender;
    }

    /**
     * Get the user Id
     *
     * @return
     */
    public long getId() {
        return id;
    }

    /**
     * set user id
     *
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Convert the object to string
     *
     * @return
     */
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

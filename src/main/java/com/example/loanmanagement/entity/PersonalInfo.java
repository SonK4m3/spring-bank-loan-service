package com.example.loanmanagement.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Date;

@Entity
@Table(name = "personal_info",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "id_number"),
        })
public class PersonalInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 120)
    private String firstName;

    @NotNull
    @Size(max = 120)
    private String lastName;

    @NotNull
    private Date dob;

    @NotNull
    private String gender;

    @Size(max = 12)
    @NotNull
    @Column(name = "id_number")
    private String idNumber;

    @Size(max = 10)
    @NotNull
    private String phone;

    @Size(max = 120)
    @Email
    @NotNull
    private String email;

    @Size(max = 120)
    @NotNull
    private String address;

    public PersonalInfo() {

    }

    public PersonalInfo(@NotNull String firstName, @NotNull String lastName, @NotNull Date dob, @NotNull String gender, @NotNull String idNumber, @NotNull String phone, @NotNull String email, @NotNull String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.gender = gender;
        this.idNumber = idNumber;
        this.phone = phone;
        this.email = email;
        this.address = address;
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

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

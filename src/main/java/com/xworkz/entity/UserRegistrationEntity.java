package com.xworkz.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
@Data
@Entity
@Table(name = "userRegister")
@NamedQuery(name = "emailFindByMe",
        query = "SELECT entity FROM UserRegistrationEntity entity WHERE entity.email=:email")
@NamedQuery(name = "oneTimeOtp", query = "UPDATE UserRegistrationEntity l SET l.otp = :otp WHERE l.email = :email")
@NamedQuery(name = "findById",
        query = "SELECT entity FROM UserRegistrationEntity entity WHERE entity.id=:id")

public class UserRegistrationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String email;
    private String mobileNumber;
    private String password;
    private String gender;
    private String otp;
    private String imageName;
    private String imageType;

}

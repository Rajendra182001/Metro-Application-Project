package com.xworkz.entity;


import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "login")


public class LoginEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private  String email;
    private String mobileNumber;
    private String gender;
    private String loginstart;
    private String loginend;
}

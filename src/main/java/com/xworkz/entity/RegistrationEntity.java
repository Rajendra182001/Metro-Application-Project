package com.xworkz.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name ="registration")
@NamedQuery(name = "read",query="Select entities from RegistrationEntity entities")
@NamedQuery(name = "findByUserName",query ="SELECT t FROM  RegistrationEntity t WHERE t.userName = :name")
@NamedQuery(name = "findByEmail",
            query = "SELECT entity FROM RegistrationEntity entity WHERE entity.email=:email")

@NamedQuery(name = "updateEmail", query = "UPDATE RegistrationEntity l SET l.otp = :otp WHERE l.email = :email")
@NamedQuery(name = "updatePassword", query = "UPDATE RegistrationEntity v SET v.password = :password WHERE v.email = :email")
@NamedQuery(name = "wrongAttempt" , query = "update RegistrationEntity reg set reg.noOfAttempts =:noOfAttempts , reg.isAccountLocked =:isAccountLocked where reg.email = :email")


public class RegistrationEntity {
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
    private String otp;
    private boolean isAccountLocked;
    private Integer noOfAttempts;
    private String imageName;
    private String imageType;
}

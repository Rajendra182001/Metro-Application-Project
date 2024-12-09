package com.xworkz.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationDto {


    private Integer id;
    @NotEmpty(message = "firstName must not be empty")
    @NotNull (message = "firstName must not be null")
    @NotBlank (message = "firstName must not be blank")
    private String firstName;
    @NotEmpty(message = "lastName must not be empty")
    @NotNull (message = "lastName must not be null")
    @NotBlank (message = "lastName must not be blank")
    private String lastName;
    @NotEmpty(message = "userName must not be empty")
    @NotNull (message = "userName must not be null")
    @NotBlank (message = "userName must not be blank")
    private String userName;
    @NotNull(message = "password must not be null")
    @Size(min = 1,max = 10,message = "password should between 1-10")
    private String password;
    @NotEmpty(message = "email must not be empty")
    @NotBlank(message = "email must not be blank")

    @NotEmpty
    @NotEmpty
    @NotBlank
    private String confirmPassword;

    private  String email;
    @NotNull
    @Size(min = 10,max = 10,message = "mobile number exactly 10 numbers")
    private String mobileNumber;
    @NotEmpty(message = "gender must not be empty")
    @NotNull (message = "gender must not be null")
    @NotBlank (message = "gender must not be blank")
    private String gender;
    private String otp;
    private boolean isAccountLocked;
    private Integer noOfAttempts;
    private String imageName;
    private String imageType;
}

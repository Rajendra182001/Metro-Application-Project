package com.xworkz.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginDto {

    private Integer id;

    private String firstName;

    private String lastName;

    private String userName;
    @NotNull(message = "password must not be null")
    @Max(value =10)
    @Min(value = 1)
    private  String password;
    @NotEmpty(message = "email must not be empty")
    @NotBlank(message = "email must not be blank")
    private String email;
    private String mobileNumber;
    private String gender;
    private String loginstart;
    private String loginend;

}

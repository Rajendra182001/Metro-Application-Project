package com.xworkz.service;

import com.xworkz.dto.RegistrationDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface MetroService {

    public boolean onSave(RegistrationDto registrationDto);

    List<RegistrationDto> readUser();


    public boolean onLoginSave(String userName , String password) ;


    RegistrationDto findByUserName(String userName);

    RegistrationDto findByEmail(String email);


    public boolean loginByEmail(String email,String password);

    public  boolean transferOtpToService(String email,String otp);


   public   boolean verifyOtp(String email, String otp);

   public boolean onUpdate(String email,String password, String confirmPassword);

   public boolean updateUserDetails(RegistrationDto registrationDto,MultipartFile file);

}

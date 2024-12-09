package com.xworkz.repository;

import com.xworkz.entity.LoginEntity;
import com.xworkz.entity.RegistrationEntity;

import java.util.List;
import java.util.Objects;

public interface MetroRepository {
    public String save(RegistrationEntity registrationEntity);

    List<RegistrationEntity> readUser();

    RegistrationEntity findByUserName(String userName);

    public String onLoginSave(LoginEntity loginEntity);

    RegistrationEntity findByEmail(String email);

    public String loginByEmail(LoginEntity loginEntity);


   RegistrationEntity saveOtp(String email,String otp);

   public String updatePassword(String email, String password);


    void userLocked(String email,int noOfAttempts,boolean isAccountLocked);

    public String updateUser(RegistrationEntity registrationEntity);
}

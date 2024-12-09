package com.xworkz.repository;

import com.xworkz.entity.RegistrationEntity;
import com.xworkz.entity.TicketEntity;
import com.xworkz.entity.TimingEntity;
import com.xworkz.entity.UserRegistrationEntity;

import javax.persistence.Table;

public interface UserRepository {
    public String save(UserRegistrationEntity userRegistrationEntity);

    UserRegistrationEntity findingEmailFromDataBase(String email);

    boolean SaveOtp(String email,String otp);

    UserRegistrationEntity findByUserId(Integer id);

    String saveTheDetails(TicketEntity ticketEntity);

}

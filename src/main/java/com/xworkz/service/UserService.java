package com.xworkz.service;

import com.xworkz.dto.RegistrationDto;
import com.xworkz.dto.TicketDto;
import com.xworkz.dto.UserRegistrationDto;
import org.springframework.ui.Model;

import java.util.List;

public interface UserService {
     boolean onSave(UserRegistrationDto userRegistrationDto);

     UserRegistrationDto lookingForEmail(String email);

     boolean loginByEmail(String email,String otp);

     boolean sendingOtpToRepo(String email, String otp);

     boolean verifyEmailAndOtp(String email,String otp);

     UserRegistrationDto findById(Integer id);

     boolean saveTicketDetails(Integer id,String ticketNumber,String source,String destination);

     List<TicketDto> getTicketDetailsFromRepo();

     List<TicketDto> findingUserIdInTicket(Integer userId);
}

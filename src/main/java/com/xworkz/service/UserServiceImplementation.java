package com.xworkz.service;


import com.xworkz.dto.PriceDto;
import com.xworkz.dto.TicketDto;
import com.xworkz.dto.UserLoginDto;
import com.xworkz.dto.UserRegistrationDto;
import com.xworkz.entity.TicketEntity;
import com.xworkz.entity.UserLoginEntity;
import com.xworkz.entity.UserRegistrationEntity;
import com.xworkz.repository.UserLoginRepository;
import com.xworkz.repository.UserRepository;
import com.xworkz.util.EncryptionDecryption;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.time.LocalDateTime;

@Service
@Slf4j
public class UserServiceImplementation implements UserService {

    private static String UPLOADED_FOLDER = "C://Users//rajen//IdeaProjects//metro-application//";

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserLoginRepository userLoginRepository;

    @Autowired
    private EmailClass emailClass;

    @Autowired
    private   PriceService priceService;

    @Autowired
    private EncryptionDecryption encryptionDecryption;

    @Override
    public boolean onSave(UserRegistrationDto userRegistrationDto) {
  UserRegistrationEntity userRegistrationEntity = new UserRegistrationEntity();
  userRegistrationDto.setPassword(encryptionDecryption.encrypt(userRegistrationDto.getPassword()));
        userRegistrationDto.setImageName("temp.png");
        userRegistrationDto.setImageType("image/png");
        BeanUtils.copyProperties(userRegistrationDto,userRegistrationEntity);
        userRepository.save(userRegistrationEntity);
        return true;
    }

    @Override
    public UserRegistrationDto lookingForEmail(String email) {
        if(email != null){
            log.info("email in service {}",email);
            UserRegistrationDto userRegistrationDto = new UserRegistrationDto();
            UserRegistrationEntity userRegistrationEntity = userRepository.findingEmailFromDataBase(email);
            log.info("userRegistrationEntity {}",userRegistrationEntity);
            if(userRegistrationEntity!=null){
            BeanUtils.copyProperties(userRegistrationEntity,userRegistrationDto);
            log.info("userRegistrationDto {}",userRegistrationDto);
            return userRegistrationDto;
            }
        }
        return null;
    }

    @Override
    public boolean loginByEmail(String email, String otp) {
        UserRegistrationDto userRegistrationDto = lookingForEmail(email);
        UserRegistrationEntity userRegistrationEntity1 = userRepository.findingEmailFromDataBase(email);
        UserRegistrationEntity userRegistrationEntity = new UserRegistrationEntity();
        UserLoginDto userLoginDto =new UserLoginDto();
        UserLoginEntity userLoginEntity = new UserLoginEntity();
        userLoginDto.setLoginId(userRegistrationDto.getId());
        userLoginDto.setFirstName(userRegistrationDto.getFirstName());
        userLoginDto.setLastName(userRegistrationDto.getLastName());
        userLoginDto.setEmail(userRegistrationDto.getEmail());
        userLoginDto.setMobileNumber(userRegistrationDto.getMobileNumber());
        userLoginDto.setLoginStart(LocalDateTime.now().toString());
        userLoginDto.setLoginEnd(null);
        BeanUtils.copyProperties(userLoginDto,userLoginEntity);
        return true;
    }

    @Override
    public boolean sendingOtpToRepo(String email, String otp) {
        UserRegistrationEntity userRegistrationEntity = userRepository.findingEmailFromDataBase(email);
        if (userRegistrationEntity !=null){
            String saveOtp = emailClass.emailSend(email);
            userRepository.SaveOtp(email,saveOtp);
            return true;
        }
        return false;
    }

    @Override
    public boolean verifyEmailAndOtp(String email, String otp) {
        UserRegistrationEntity userRegistrationEntity = userRepository.findingEmailFromDataBase(email);
        if (userRegistrationEntity!=null){
            UserRegistrationDto userRegistrationDto = new UserRegistrationDto();
            BeanUtils.copyProperties(userRegistrationEntity,userRegistrationDto);
            if (userRegistrationEntity.getOtp().equals(otp)&&userRegistrationEntity.getEmail().equals(email)){
                UserLoginDto userLoginDto =new UserLoginDto();
                UserLoginEntity userLoginEntity = new UserLoginEntity();
                userLoginDto.setLoginId(userRegistrationDto.getId());
                userLoginDto.setFirstName(userRegistrationDto.getFirstName());
                userLoginDto.setLastName(userRegistrationDto.getLastName());
                userLoginDto.setEmail(userRegistrationDto.getEmail());
                userLoginDto.setMobileNumber(userRegistrationDto.getMobileNumber());
                userLoginDto.setLoginStart(LocalDateTime.now().toString());
                userLoginDto.setLoginEnd(null);
                BeanUtils.copyProperties(userLoginDto,userLoginEntity);
                userLoginRepository.loginByEmail(userLoginEntity);
                log.info(otp);
                return true;
            }
            return true;
        }
        return false;
    }

    @Override
    public UserRegistrationDto findById(Integer id) {
        if(id!=null) {
            UserRegistrationDto userRegistrationDto = new UserRegistrationDto();
            UserRegistrationEntity userRegistrationEntity = userRepository.findByUserId(id);
            if (userRegistrationEntity != null) {
                BeanUtils.copyProperties(userRegistrationEntity, userRegistrationDto);
                return userRegistrationDto;
            }
        }
        return null;
    }

    @Override
    public boolean saveTicketDetails(Integer id,String ticketNumber, String source, String destination) {
        PriceDto priceDto = priceService.findBySourceAndDestination(source, destination);
        if (priceDto.getSource().equals(source)&&priceDto.getDestination().equals(destination)){
            TicketDto ticketDto = new TicketDto();
            TicketEntity ticketEntity = new TicketEntity();
            ticketDto.setUserId(id);
            ticketDto.setSource(source);
            ticketDto.setDestination(destination);
            ticketDto.setPrice(priceDto.getPrice());
            ticketDto.setTokenNumber(ticketNumber);
            BeanUtils.copyProperties(ticketDto,ticketEntity);
            userRepository.saveTheDetails(ticketEntity);
            return true;
        }
        return false;
    }


}

package com.xworkz.service;

import com.xworkz.dto.LoginDto;
import com.xworkz.dto.RegistrationDto;
import com.xworkz.entity.LoginEntity;
import com.xworkz.entity.RegistrationEntity;
import com.xworkz.repository.MetroRepository;
import com.xworkz.util.EncryptionDecryption;
import lombok.extern.slf4j.Slf4j;
import org.jasypt.util.password.PasswordEncryptor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;



@Service
@Slf4j
public class MetroServiceImpl implements MetroService {
    private static String UPLOADED_FOLDER = "C://Users//rajen//IdeaProjects//metro-application//";

    @Autowired
    private MetroRepository metroRepository;

    @Autowired
    private EncryptionDecryption encryptionDecryption;

    @Autowired
    private EmailClass emailClass;


    @Override
    public boolean onSave(RegistrationDto registrationDto) {
        RegistrationEntity registrationEntity = new RegistrationEntity();
        registrationDto.setPassword(encryptionDecryption.encrypt(registrationDto.getPassword()));
        registrationDto.setImageName("temp.png");
        registrationDto.setImageType("image/png");
        BeanUtils.copyProperties(registrationDto, registrationEntity);
        metroRepository.save(registrationEntity);
        return true;
    }

    @Override
    public List<RegistrationDto> readUser() {
        List<RegistrationEntity> listofentity = metroRepository.readUser();
        List<RegistrationDto> listOfdtos = new ArrayList<>();
        if (!listofentity.isEmpty()) {
            for (RegistrationEntity registeredEntity : listofentity) {
                System.err.println("before decrypt text   " + registeredEntity.getPassword() + "dcrypted text is " + encryptionDecryption.decrypt(registeredEntity.getPassword()));
                registeredEntity.setPassword(encryptionDecryption.decrypt(registeredEntity.getPassword()));
                RegistrationDto registeredDto = new RegistrationDto();
                BeanUtils.copyProperties(registeredEntity, registeredDto);
                listOfdtos.add(registeredDto);
            }
            return listOfdtos;
        }
        return null;
    }

    @Override
    public RegistrationDto findByUserName(String userName) {
        if (userName != null) {
            RegistrationDto registrationDto = new RegistrationDto();
            RegistrationEntity registrationEntity = metroRepository.findByUserName(userName);
            if (registrationEntity != null) {
                BeanUtils.copyProperties(registrationEntity, registrationDto);
                return registrationDto;
            }
        }
        return null;
    }

    @Override
    public RegistrationDto findByEmail(String email) {
        if (email != null) {
            RegistrationDto registrationDto = new RegistrationDto();
            RegistrationEntity registrationEntity = metroRepository.findByEmail(email);
            if (registrationEntity != null) {
                BeanUtils.copyProperties(registrationEntity, registrationDto);
                return registrationDto;
            }
        }
        return null;
    }

    @Override
    public boolean loginByEmail(String email, String password) {
        RegistrationDto registrationDto = findByEmail(email);
        RegistrationEntity registrationEntity1 = new RegistrationEntity();
        if (registrationDto != null) {
            String decrypt = encryptionDecryption.decrypt(registrationDto.getPassword());
            registrationDto.setPassword(decrypt);
            log.info("decrypted password{}", decrypt);
            if(!(registrationDto.getPassword().equals(password))){
                if(registrationDto.getNoOfAttempts()==null) {
                    registrationDto.setNoOfAttempts(0);
                    registrationDto.setAccountLocked(false);
                    log.info("=============="+registrationDto.getNoOfAttempts());
                }
                 registrationDto.setNoOfAttempts(registrationDto.getNoOfAttempts()+1);
                  BeanUtils.copyProperties(registrationDto,registrationEntity1);
                  log.info("registration Entity {}",registrationEntity1);
                  metroRepository.userLocked(email, registrationEntity1.getNoOfAttempts(),registrationEntity1.isAccountLocked());
                if (registrationDto.getNoOfAttempts()>=3){
                    registrationDto.setAccountLocked(true);
                    BeanUtils.copyProperties(registrationDto,registrationEntity1);
                    metroRepository.userLocked(email,registrationEntity1.getNoOfAttempts(),registrationEntity1.isAccountLocked());
                    return false;
                }
            }else {
                LoginDto loginDto=new LoginDto();
                LoginEntity loginEntity = new LoginEntity();
                loginDto.setId(registrationDto.getId());
                loginDto.setFirstName(registrationDto.getFirstName());
                loginDto.setLastName(registrationDto.getLastName());
                loginDto.setUserName(registrationDto.getUserName());
                loginDto.setPassword(encryptionDecryption.encrypt(registrationDto.getPassword()));
                log.info("encryption  decryption get Password{}",encryptionDecryption.encrypt(registrationDto.getPassword()));
                loginDto.setEmail(registrationDto.getEmail());
                loginDto.setMobileNumber(registrationDto.getMobileNumber());
                loginDto.setGender(registrationDto.getGender());
                loginDto.setLoginstart(LocalDateTime.now().toString());
                loginDto.setLoginend(null);
                BeanUtils.copyProperties(loginDto,loginEntity);
                metroRepository.loginByEmail(loginEntity);
                log.info("login Entity {}",loginEntity);
                registrationDto.setNoOfAttempts(0);
                registrationDto.setAccountLocked(false);
                BeanUtils.copyProperties(registrationDto, registrationEntity1);
                metroRepository.userLocked(email,registrationEntity1.getNoOfAttempts(),registrationEntity1.isAccountLocked());
                return true;
            }
        }
        return false;
    }


    @Override
    public boolean transferOtpToService(String email, String otp) {
        RegistrationEntity registrationEntity = metroRepository.findByEmail(email);
        if (registrationEntity != null) {
            String otpSave = emailClass.emailSend(email);
            metroRepository.saveOtp(email, otpSave);
            return true;
        }
        return false;
    }

    @Override
    public boolean verifyOtp(String email, String otp) {
        log.info("before start {}");
        RegistrationEntity registrationEntity = metroRepository.findByEmail(email);
        log.info("otp from repo {}",registrationEntity.getOtp() );
            if (registrationEntity != null) {
                RegistrationDto registrationDto = new RegistrationDto();
                BeanUtils.copyProperties(registrationEntity, registrationDto);
                if (registrationEntity.getOtp().equals(otp)) {
                    System.out.println(registrationEntity.getOtp());
                    return true;
                }
        }
       return false;
    }

    @Override
    public boolean onUpdate(String email,String password, String confirmPassword) {
        RegistrationEntity registrationEntity = metroRepository.findByEmail(email);
        if (registrationEntity != null){
            if(password.equals(confirmPassword)){
                String encrypt = encryptionDecryption.encrypt(confirmPassword);
                metroRepository.updatePassword(email,encrypt);
                return true;
            }return false;
        }return false;
    }

    @Override
    public boolean updateUserDetails(RegistrationDto registrationDto,MultipartFile file) {
        log.error("This is in the Update User Details service implementation Page");
        log.info("registration Dto"+registrationDto);
        RegistrationDto registrationDto1 = findByEmail(registrationDto.getEmail());
        RegistrationEntity registrationEntity = new RegistrationEntity();
          if(file != null && !file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();
                Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
                Files.write(path, bytes);
                registrationDto.setImageName(file.getOriginalFilename());
                registrationDto.setImageType(file.getContentType());

            } catch (Exception e) {
            }

            }else {
             registrationDto.setImageName(registrationDto1.getImageName());
             registrationDto.setImageType(registrationDto1.getImageType());
        }
        if(registrationDto!=null){
            BeanUtils.copyProperties(registrationDto,registrationEntity);
            metroRepository.updateUser(registrationEntity);
            return true;
        }
        return false;
    }

    @Override
    public boolean onLoginSave(String userName,String password) {
                RegistrationEntity registeredEntity = metroRepository.findByUserName(userName);
                log.info("entity from repository {}",registeredEntity);
                if(registeredEntity!=null) {
                log.info("encrypted Password {}",registeredEntity.getPassword());
                String decrypt = encryptionDecryption.decrypt(registeredEntity.getPassword());
                registeredEntity.setPassword(decrypt);
                log.info("decrypted Password {}",decrypt);
                LoginEntity loginEntity = new LoginEntity();
                if(registeredEntity.getUserName().equals(userName)&&registeredEntity.getPassword().equals(password)) {
                loginEntity.setId(registeredEntity.getId());
                loginEntity.setFirstName(registeredEntity.getFirstName());
                loginEntity.setLastName(registeredEntity.getLastName());
                loginEntity.setUserName(registeredEntity.getUserName());
                loginEntity.setPassword(encryptionDecryption.encrypt(decrypt));
                log.info("encryption decryption {}",encryptionDecryption.encrypt(registeredEntity.getPassword()));
                loginEntity.setEmail(registeredEntity.getEmail());
                loginEntity.setMobileNumber(registeredEntity.getMobileNumber());
                loginEntity.setGender(registeredEntity.getGender());
                loginEntity.setLoginstart(LocalDateTime.now().toString());
                loginEntity.setLoginend(null);
                metroRepository.onLoginSave(loginEntity);
                log.info("loginEntity{}",loginEntity);
                return true;
            }
            else
                log.info("invalid userName or Password");
        }
            return false;
       }


  }



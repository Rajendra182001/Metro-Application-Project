package com.xworkz.controller;

import com.xworkz.dto.PriceDto;
import com.xworkz.dto.RegistrationDto;
import com.xworkz.service.EmailClass;
import com.xworkz.service.MetroService;
import com.xworkz.service.PriceService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Path;
import javax.validation.Valid;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.logging.Logger;

@Controller
@RequestMapping("/")
@Slf4j
public class RegistrationController {


    private static String path = "C://Users//rajen//IdeaProjects//metro-application//";

    @Autowired
    private MetroService metroService;

    @Autowired
    private PriceService priceService;

    @Autowired
    private EmailClass emailClass;

    @GetMapping("/index")
    public String index(Model model)
    {
        List<PriceDto> priceDtos = priceService.readPrice();
        model.addAttribute("priceDto",priceDtos);
         log.info("price Dtos {}",priceDtos);
        return "index";
    }


    @PostMapping("/onRegister")
    public String onSave(@Valid RegistrationDto registrationDto, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "Message";
        }
        metroService.onSave(registrationDto);
        model.addAttribute("success", "Registration successful");
        return "MetroRegistration";
    }


    @GetMapping("/MetroRegistration")
    public String onSaving(Model model) {

        return "RedirectRegisterPage";
    }

  @GetMapping("/AdminRegister")
  public String admin(){
        return "MetroRegistration";
  }

    @GetMapping("/read")
    public String onRead(Model model) {
        List<RegistrationDto> registrationDtos = metroService.readUser();
        System.out.println(registrationDtos);
        model.addAttribute("trainees", registrationDtos);
        return "Read";
    }

    @GetMapping("/searchUserName")
    public String findUser(@RequestParam String userName, Model model) {
        RegistrationDto registrationDto = metroService.findByUserName(userName);
        if (registrationDto != null) {
            model.addAttribute("single", registrationDto);
            return "Read";
        }
        List<RegistrationDto> registrationDtos = metroService.readUser();
        System.out.println(registrationDtos);
        model.addAttribute("trainees", registrationDtos);
        model.addAttribute("message", "not found" + userName);
        return "Read";

    }


    @GetMapping("/email")
    public ResponseEntity<String> findByEmail(@RequestParam String email, Model model) {
        RegistrationDto registrationDto = metroService.findByEmail(email);
        System.out.println(registrationDto);
        if (registrationDto != null) {
            System.out.println(registrationDto + "registrationDto");
            model.addAttribute("single", registrationDto);
            return ResponseEntity.ok("email user already existed");

        }
        List<RegistrationDto> registrationDtos = metroService.readUser();
        System.out.println(registrationDtos);
        model.addAttribute("trainees", registrationDtos);
        model.addAttribute("message", "not found" + email);
        return ResponseEntity.ok("email user not existed");

    }
    @GetMapping("/Forgot")
    public String ForgotPassword(){
        return "Reset";
    }

    @GetMapping("/emailSent")
    public String emailSent(@RequestParam String email, String otp, Model model) {
        System.out.println(email+"email===========================================");
        RegistrationDto registrationDto = metroService.findByEmail(email);
        if (registrationDto != null) {
            model.addAttribute("email",registrationDto);
            metroService.transferOtpToService(email, otp);
            return "Reset";
        }
        return "Reset";
    }


    @GetMapping("/otp")
    public String enterOtp(@RequestParam String otp, @RequestParam String email, Model model) {
        System.out.println("hiiiiiiiiiiiiiiiiiiiiiiiiiii========================");
        RegistrationDto registrationDto = metroService.findByEmail(email);
        System.out.println(registrationDto+"registrationDto==================");
        if (registrationDto != null) {
            System.out.println(registrationDto.getOtp());
            System.out.println(registrationDto.getEmail());
            boolean isOtpVerified = metroService.verifyOtp(email, otp);
            if (isOtpVerified) {
                model.addAttribute("success", registrationDto);
                return "ConfirmPassword";
            }return "Reset";
        }
        return "Reset";
    }

    @PostMapping("/confirm")
    public String ConfirmPassword(@RequestParam String email,@RequestParam String password,String confirmPassword,Model model ){
        System.out.println("========================================");
        RegistrationDto registrationDto = metroService.findByEmail(email);
        model.addAttribute("email",registrationDto);
        if (email != null && password != null && confirmPassword !=null) {
            metroService.onUpdate(email,password,confirmPassword);
            return "Login";
        }
        return "Login";
    }


    @GetMapping("/UpdateProfile")
    public String onEdit(String email,Model model){
        RegistrationDto registrationDto = metroService.findByEmail(email);
        model.addAttribute("dto",registrationDto);
        return "ProfileName";
    }
    @PostMapping("/UpdateUser")
    public String updateProfile(@RequestParam("file") MultipartFile file, RegistrationDto registrationDto, Model model){
        log.info("This is the controller of update user :");
        boolean  update = metroService.updateUserDetails(registrationDto,file);
        RegistrationDto registrationDto1 = metroService.findByEmail(registrationDto.getEmail());
        log.error(" file from ui : "+  file.getOriginalFilename());
        log.error(" registrationDto : "+ registrationDto);
            if(update) {
                model.addAttribute("dto", registrationDto1);
                log.info("registration Dto1"+registrationDto1);
                model.addAttribute("message","upload succesfully");
                System.out.println("data from ui" + registrationDto);
                model.addAttribute("mod",registrationDto1);
                model.addAttribute("model", "data saved successfully");
                return "Success";
            }else {
                model.addAttribute("details", registrationDto1);
                model.addAttribute("errMsg", "data not updated");
                return "Success";
            }
    }

    @GetMapping("/getImage/{imageName}")
    public void viewImage(@PathVariable  String imageName,Model model, HttpServletResponse httpServletResponse) {
        File file = new File(path + imageName);
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            InputStream inputStream = new BufferedInputStream(fileInputStream);
            ServletOutputStream outputStream = httpServletResponse.getOutputStream();
            IOUtils.copy(inputStream, outputStream);
            model.addAttribute("image", outputStream);
            httpServletResponse.flushBuffer();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
      }
    }




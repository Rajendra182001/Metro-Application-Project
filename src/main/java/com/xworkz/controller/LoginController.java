package com.xworkz.controller;



import com.xworkz.dto.AddTrainDto;
import com.xworkz.dto.RegistrationDto;
import com.xworkz.service.AddTrainService;
import com.xworkz.service.MetroService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/")
@Slf4j
public class LoginController {



    @Autowired
    MetroService metroService;

    @Autowired
   AddTrainService addTrainService;

    public LoginController() {
        System.out.println("metro controller has been initialized");
    }

    @PostMapping("/onLogin")
    public String onSaveLogin(@RequestParam String userName,@RequestParam String password, Model model)  {
        log.info("login");
        System.out.println("login : for  user name  and password : "+userName +"   : "+password);
        RegistrationDto registrationDto = metroService.findByUserName(userName);
        log.info("=============================+"+userName);
        boolean b = metroService.onLoginSave(userName, password);
       if (b){
           model.addAttribute("dto",registrationDto);
           model.addAttribute("loginSuccess","Login saved Succesfully..!");
            return "Success";
        }
       else
            model.addAttribute("loginError","invalid login");
        return "Message";
    }

    @GetMapping("/MetroLogin")
    public String inLogin(){
        return "MetroLogin";
    }
    @GetMapping("/inLogin")
    public String LoginEmail(){

        return "LoginByEmail";
    }


    @GetMapping("/userLogin")
    public  String LoginPage(){

        return "UserLogin";
    }

    @GetMapping("userCanLoginHere")
    public String userCanLoginHere(){

        return "UserEmail";
    }

    @PostMapping("/inLogin")
    public String loginByEmailOrMobileNumber(@RequestParam String email,@RequestParam String password,Model model){
        System.out.println("login : for  user name  and password : "+ email +"   : "+password);
       RegistrationDto registrationDto = metroService.findByEmail(email);
       log.info("email {}",email);
       boolean isSaved = metroService.loginByEmail(email,password);
        if(isSaved){
            model.addAttribute("dto",registrationDto);
            model.addAttribute("hi","login saved");
            return "Success";
        }
           if(registrationDto.isAccountLocked()){
               model.addAttribute("blocked","Too Many Attempts,User Account is Locked Please Try Again");
               return "LoginByEmail";
           }
        else
            model.addAttribute("emailError","invalid login");
            return "LoginByEmail";

    }
}


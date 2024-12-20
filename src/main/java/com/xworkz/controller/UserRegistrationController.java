package com.xworkz.controller;

import com.xworkz.dto.*;
import com.xworkz.entity.AddTrainEntity;
import com.xworkz.entity.PriceEntity;
import com.xworkz.entity.TimingEntity;
import com.xworkz.repository.AddTrainRepository;
import com.xworkz.repository.PriceRepository;
import com.xworkz.service.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/")
@Slf4j
public class UserRegistrationController {

    private static final String PATH = "C://Users//rajen//IdeaProjects//metro-application//";

    @Autowired
   private UserService userService;

    @Autowired
    private   TimingService timingService;

    @Autowired
   private AddTrainService addTrainService;

    @Autowired
    private   PriceService priceService;

    @Autowired
    private TicketService ticketService;
    @Autowired
  private   PriceRepository priceRepository;

    @Autowired
    private EmailClass emailClass;

    @GetMapping("/userRegister")
    public String userRegister(){
        return "UserRegistration";
    }


    @PostMapping("/userRegistration")
    public String userRegistration(@Valid UserRegistrationDto userRegistrationDto, BindingResult bindingResult, Model model){
      if(bindingResult.hasErrors()){
          model.addAttribute("errors",bindingResult.getAllErrors());
          return "UserRegistration";
      } else if (userRegistrationDto != null) {
          boolean isSaved = userService.onSave(userRegistrationDto);
        if(isSaved){
            emailClass.mimeMessage(userRegistrationDto.getEmail());
            model.addAttribute("dto",userRegistrationDto);
            model.addAttribute("success","your Registration is Completed,ThankYou");
            return "UserRegistration";
        }
        return "UserRegistration";
      }
      return "index";
    }



    @GetMapping("/FindEmail")
    public ResponseEntity<String> findingUserEmail(@RequestParam String email, Model model){
            log.info("email {}",email);
              if(email != null) {
                  UserRegistrationDto userRegistrationDto = userService.lookingForEmail(email);
                  log.info("user Registration Dto {}", userRegistrationDto);
                  if (userRegistrationDto != null) {
                      model.addAttribute("userRegistrationDto", userRegistrationDto);
                      model.addAttribute("success", "Your Email Has Been Found");
                      return ResponseEntity.ok("email user already existed");
                  }
              }
                  return ResponseEntity.ok("email user not existed");
    }


    @GetMapping("/User")
    public String savingOtp(@RequestParam String email,String otp,Model model){
        UserRegistrationDto userRegistrationDto = userService.lookingForEmail(email);
        if (userRegistrationDto != null) {
            model.addAttribute("email", userRegistrationDto);
            userService.sendingOtpToRepo(email,otp);
            return "UserEmail";
        }
        model.addAttribute("message", "Your Email has not been Found");
        return "UserEmail";
    }

   @GetMapping("/loginHere")
    public String gettingOtpFromRepo(@RequestParam String otp,@RequestParam String email,@RequestParam Integer id, Model model){
        UserRegistrationDto userRegistrationDto = userService.lookingForEmail(email);
        List<AddTrainDto> addTrainEntities = addTrainService.readAddTrainData();
        List<String> uniqueSources = addTrainEntities.stream().flatMap(addTrainEntity -> addTrainEntity.getTimingEntity().stream()).map(TimingDto::getSource).distinct().collect(Collectors.toList());
        List<String> uniqueDestinations = addTrainEntities.stream().flatMap(addTrainEntity -> addTrainEntity.getTimingEntity().stream()).map(TimingDto::getDestination).distinct().collect(Collectors.toList());
        model.addAttribute("uniqueSources", uniqueSources);
        model.addAttribute("uniqueDestinations", uniqueDestinations);
        if (userRegistrationDto != null){
            log.info(userRegistrationDto.getOtp());
            log.info(userRegistrationDto.getEmail());
            boolean isOtpVerified= userService.verifyEmailAndOtp(email, otp);
            if (isOtpVerified){
                model.addAttribute("email", userRegistrationDto);
                return "UserSuccessPage";
            }
            model.addAttribute("emailError","invalid Otp");
            return "UserEmail";
        }
        return "UserEmail";
    }


       private  String generatingTicketNumber()
       {
           Random random = new Random();
           int randomNumber = random.nextInt(9000) + 1000;
               SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss,EEE");
           String currentDateTime = sdf.format(new Date());
           return "RAJ" + randomNumber + currentDateTime;
       }

       @GetMapping("ticketForm")
       public  String getTicketForm(@RequestParam String source,@RequestParam String destination,@RequestParam String email,@RequestParam Integer id,Model model){
        log.info("source {}",source);
        log.info("destination {}",destination);
        log.info("id {}",id);
           String ticketNumber = generatingTicketNumber();
           PriceDto priceDto = priceService.findBySourceAndDestination(source, destination);
           boolean isSaved = userService.saveTicketDetails(id, ticketNumber, source, destination);
           if (isSaved){
               emailClass.ticketMessage(email,ticketNumber);
               model.addAttribute("booked","ThankYou Your Ticket Booked Successfully");
               return "UserSuccessPage";
           }
           log.info("by {}",priceDto);
           return "SmartCard";
       }
   @GetMapping("findByUserId")
    public  ResponseEntity<?> getUserId(@RequestParam Integer id,Model model) {
       UserRegistrationDto userId = userService.findById(id);
       if (userId != null) {
           model.addAttribute("ticketDto",userId);
           log.info("userId {}", userId);
           return ResponseEntity.ok("UserId was found");
       }
       return ResponseEntity.ok("user ID not found");
   }

   @GetMapping("/smartCards")
   public  String getSmartCardDetails(){
     return "SmartCard";
   }

    @GetMapping("/info")
    public  String getInfo(){
        return "Information";
    }

    @GetMapping("/success")
    public  String showSuccessPage(){
        return "UserSucessPage";
    }

    @GetMapping("/readTimings")
    public String getTimings(Model model){
        List<TimingDto> timingDtos = timingService.readTime();
        log.info("timingDtos {}",timingDtos);
        model.addAttribute("timings",timingDtos);
        return "MetroTimings";
    }

}

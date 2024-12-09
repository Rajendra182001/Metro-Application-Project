package com.xworkz.controller;

import com.xworkz.dto.RegistrationDto;
import com.xworkz.dto.TimingDto;
import com.xworkz.service.MetroService;
import com.xworkz.service.TimingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/")
@Slf4j
public class TimingsController {
    @Autowired
    MetroService metroService;

    @Autowired
    TimingService timingService;

    @GetMapping("/addTimings")
    public String addTimings(@RequestParam String email, Model model){
        RegistrationDto registrationDto = metroService.findByEmail(email);
        model.addAttribute("dto",registrationDto);
        return "AddTimings";
    }


    @PostMapping("/timings")
    public String timings(@Valid TimingDto timingDto, @RequestParam String email, BindingResult bindingResult, Model model){
     if(bindingResult.hasErrors()){
         model.addAttribute("errors",bindingResult.getAllErrors());
         return "Message";
     }else{
         RegistrationDto registrationDto = metroService.findByEmail(email);
         log.info(email+"email");
         model.addAttribute("dto",registrationDto);
         model.addAttribute("success","Add Location and TrainType successful");
         timingService.saveTimings(timingDto);
         return "AddTimings";

     }
    }

    @GetMapping("/train")
    public String findByTrainType(@RequestParam String trainType,Model model){
        TimingDto timingto = timingService.findByTrainType(trainType);
        System.out.println(timingto+"timingDto");
        model.addAttribute("time",timingto);
        return "Read";
    }

    @GetMapping("/hello")
    public String onRead(Model model) {
        List<TimingDto> timingDtos = timingService.readTime();
        System.out.println(timingDtos);
        model.addAttribute("trainees", timingDtos);
        return "Read";
    }

    @GetMapping("/gettingDetails")
    public String getSourceAndDestination(@RequestParam String source,@RequestParam String destination){

        return "";
    }
}
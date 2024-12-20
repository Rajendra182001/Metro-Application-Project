package com.xworkz.controller;


import com.xworkz.dto.LocationDto;
import com.xworkz.dto.RegistrationDto;
import com.xworkz.service.LocationService;
import com.xworkz.service.MetroService;
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
import javax.xml.ws.soap.Addressing;

@Controller
@RequestMapping("/")
@Slf4j
public class LocationController {
    @Autowired //
    LocationService locationService;

    @Autowired
    MetroService metroService;

    @GetMapping("/addLocations")
    public String addLocation(@RequestParam String email,Model model){
        RegistrationDto registrationDto = metroService.findByEmail(email);
        model.addAttribute("dto",registrationDto);
        return "AddLocation";
    }

    @PostMapping("/location")
       public String addingLocationAndTrainType(@Valid LocationDto locationDto,@RequestParam String email, BindingResult bindingResult,Model model){

        if(bindingResult.hasErrors()){
            model.addAttribute("errors",bindingResult.getAllErrors());
            return "Message";
        }else{
            RegistrationDto registrationDto = metroService.findByEmail(email);
            log.info(email+"email");
            model.addAttribute("dto",registrationDto);
            model.addAttribute("success", "Add Location and TrainType successful");
            locationService.onSaveLocationAndType(locationDto);
            return "AddLocation";
        }

       }

       @GetMapping("/trainNumber")
         public  String findLocationTrainType(@RequestParam String trainNumber,Model model){
           LocationDto locationDto = locationService.findByTrainNumber(trainNumber);
           System.out.println(locationDto+"location Dto");
                   model.addAttribute("dto",locationDto);
           return "Read";
  }
}

package com.xworkz.controller;

import com.xworkz.dto.ReadDataDto;
import com.xworkz.dto.RegistrationDto;
import com.xworkz.service.ReadDataService;
import com.xworkz.service.MetroService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/")
@Slf4j
public class ReadDataController {

    @Autowired
    MetroService metroService;

    @Autowired
    ReadDataService readDataService;

    /*@GetMapping("/readData")
    public String readData(@RequestParam String email, Model model){
        List<ReadDataDto> readDataDtoList = readDataService.readData();
        log.info("================================"+readDataDtoList);
        model.addAttribute("trainees",readDataDtoList);
        return "ReadData";
    }*/

    /*   @GetMapping("/readData")
        public String readAllData(@RequestParam String email,Model model) {
            List<ReadDataDto> readDataDtos = readDataService.readAllData();
            model.addAttribute("trainees",readDataDtos);
            return "ReadData";
        }*/
}

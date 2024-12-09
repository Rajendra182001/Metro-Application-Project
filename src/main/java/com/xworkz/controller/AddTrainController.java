package com.xworkz.controller;

import com.xworkz.dto.AddTrainDto;
import com.xworkz.dto.RegistrationDto;
import com.xworkz.entity.AddTrainEntity;
import com.xworkz.repository.AddTrainRepository;
import com.xworkz.service.AddTrainService;
import com.xworkz.service.MetroService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/")
@Slf4j
public class AddTrainController {


    @Autowired
    MetroService metroService;
    @Autowired
    AddTrainService addTrainService;


    @GetMapping("/addTrainType")
    public String addTrain(@RequestParam String email,AddTrainDto addTrainDto, Model model) {
        RegistrationDto registrationDto = metroService.findByEmail(email);
        model.addAttribute("dto", registrationDto);
        return "AddTrain";
    }


    @PostMapping("/addTrain")
    public String train(@Valid AddTrainDto addTrainDto, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "Message";
        } else {
            boolean isSaved = addTrainService.saveTrainTypeAndTrainNumber(addTrainDto);
            log.info(isSaved+"issaved");
            if(isSaved){
                model.addAttribute("success", "Saved successful");
                return "AddTrain";
            }else{
                model.addAttribute("Unsaved","Not Saved");
                return "AddTrain";
            }
        }
    }


    @GetMapping("/trainType")
    public String findByTrainType(@RequestParam String trainType,Model model){
        AddTrainDto addTrainDto = addTrainService.getTrainTypeService(trainType);
        model.addAttribute("trainType",addTrainDto);
        log.info("===================addTrainDto==========================="+addTrainDto);
        return "ReadData";
    }

  /*  @GetMapping("/getAllDetails{addTrainId}")
    public ResponseEntity<AddTrainEntity> findById(@RequestParam Integer addTrainId){
        Optional<AddTrainEntity> optional = addTrainService.findById(addTrainId);
        if(optional.isPresent()){
            return ResponseEntity.ok(optional.get());
        }
        return ResponseEntity.noContent().build();
    }*/

   @GetMapping("/getAllDetails")
    public String getData(@RequestParam Integer addTrainId,Model model){
        AddTrainEntity addTrainEntity = addTrainService.getDetails(addTrainId);
        log.info("addTrainEntity");
       model.addAttribute("trainees",addTrainEntity);
        model.addAttribute("addTrainEntity", addTrainEntity);  // Name it properly here.
        return "ReadData";
    }

    @GetMapping("/use")
    public String getInfo(@RequestParam String trainNumber,Model model){
        AddTrainDto byTrainNumber = addTrainService.findByTrainNumber(trainNumber);
        log.info("byTrainNumber");
        model.addAttribute("addTrainId", byTrainNumber);
        return "ReadData";
    }


    @GetMapping("/number")
    public String getTrainNumber(@RequestParam String trainNumber,Model model){
        AddTrainDto byTrainNumber = addTrainService.findByTrainNumber(trainNumber);
        model.addAttribute("trainNumber",byTrainNumber);
        return "AddTrain";
    }

    @GetMapping("/readTrain")
    public String readAllData(Model model){
        List<AddTrainDto> addTrainEntities = addTrainService.readAddTrainData();
        log.info(" addTrainDtos   {}  ",addTrainEntities);
        model.addAttribute("addTrainEntities", addTrainEntities);
        return "ReadData";
    }

}

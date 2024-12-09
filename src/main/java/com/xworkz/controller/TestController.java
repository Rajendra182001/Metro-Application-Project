package com.xworkz.controller;

import com.xworkz.entity.AddTrainEntity;
import com.xworkz.service.AddTrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RequestMapping("/")
public class TestController {
    @Autowired
    private AddTrainService addTrainService;

   /* @GetMapping("/getAllDetails")
    public ResponseEntity<List<AddTrainEntity>> addTrainDto( Integer id) {
        return ResponseEntity.ok((List<AddTrainEntity>) addTrainService.getAllTraainDetails(id));
    }*/
}

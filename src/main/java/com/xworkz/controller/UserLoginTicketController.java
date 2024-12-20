package com.xworkz.controller;

import com.xworkz.dto.TicketDto;
import com.xworkz.dto.UserRegistrationDto;
import com.xworkz.service.EmailClass;
import com.xworkz.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/")
@Slf4j
public class UserLoginTicketController {

    @Autowired
    private EmailClass emailClass;

    @Autowired
    private UserService userService;


    @GetMapping("/viewTicketHistory")
    public String findingTicketNumber(Model model){
        List<TicketDto> listOfTicketDetails = userService.getTicketDetailsFromRepo();
        log.info(" listOfTicketDetails{}",listOfTicketDetails);
        model.addAttribute("ticketDto",listOfTicketDetails);
        return "UserTicketHistory";
    }

    @GetMapping("/fromId")
    public ResponseEntity<?> getUserDetsils(@RequestParam Integer userId, Model model) {
        List<TicketDto> ticketDtos = userService.findingUserIdInTicket(userId);
        for (TicketDto ticketDto : ticketDtos) {
            if (ticketDto != null) {
                model.addAttribute("ticketDto", ticketDto);
                log.info("ticketDto {}",ticketDto);
                return ResponseEntity.ok("GOT THE ID");
            } else {
                return ResponseEntity.ok("ID NOT FOUND");
            }
        }
        return ResponseEntity.ok("");

    }

    @GetMapping("/abc")
    public String getDet(@RequestParam Integer userId,Model model){
        List<TicketDto> ticketDtos = userService.findingUserIdInTicket(userId);
        log.info("ticket Dto {}",ticketDtos);
        model.addAttribute("ticketDto",ticketDtos);
        return "UserTicketHistory";
    }
}

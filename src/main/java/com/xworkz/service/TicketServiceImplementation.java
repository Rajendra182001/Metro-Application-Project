package com.xworkz.service;

import com.xworkz.dto.TicketDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class TicketServiceImplementation implements  TicketService {
    @Autowired
    private UserService userService;
    @Override
    public boolean savingTicketDataDetails(String ticketNumber, String source, String destination) {
        TicketDto ticketDto = new TicketDto();
      //    userService.lookingForEmail()
      //  ticketDto.setUserId();
        return false;
    }
}

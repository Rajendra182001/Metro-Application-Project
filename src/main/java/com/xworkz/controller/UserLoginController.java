package com.xworkz.controller;

import com.xworkz.service.EmailClass;
import com.xworkz.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
@Slf4j
public class UserLoginController {

    @Autowired
    private EmailClass emailClass;

    @Autowired
    private UserService userService;


}

package com.pei.api.emailService.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @RequestMapping("/1")
    public String helloWorld(){
        return "hello world";
    }

}

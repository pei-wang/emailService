package com.pei.api.emailService.controllers;

import com.pei.api.emailService.Configuration.EmailConfiguration;
import com.pei.api.emailService.entity.EmailMessage;
import com.pei.api.emailService.services.SimpleEmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;

@RestController
public class MailController {
    @Autowired
    private SimpleEmailSenderService simpleEmailSenderService;

    @Autowired
    private EmailConfiguration emailConfiguration;

    @PostMapping("/email")
    public String sendEmail(@RequestBody EmailMessage emailMessage) throws MessagingException {
        simpleEmailSenderService.send(emailMessage);
        return "hello world";
    }

    @GetMapping
    public String test() {
        return "test" + emailConfiguration.getAuth() + emailConfiguration.getSslEnable();
    }
}
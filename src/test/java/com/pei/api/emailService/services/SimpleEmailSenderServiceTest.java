package com.pei.api.emailService.services;

import com.pei.api.emailService.entity.EmailMessage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@WebAppConfiguration
public class SimpleEmailSenderServiceTest {
    @Autowired
    private SimpleEmailSenderService simpleEmailSenderService;

    @Test
    public void send() throws Exception {
        EmailMessage emailMessage = new EmailMessage();
        emailMessage.setFrom("519875872@qq.com");
        emailMessage.setSubject("test");
        emailMessage.setTo("wangpei9679@163.com");
        emailMessage.setContent("test...");
        simpleEmailSenderService.send(emailMessage);
    }

}
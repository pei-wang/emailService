package com.pei.api.emailService.services;

import com.pei.api.emailService.Configuration.EmailConfiguration;
import com.pei.api.emailService.entity.EmailMessage;
import com.pei.api.emailService.entity.MailAuthenticator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.rmi.runtime.Log;

import javax.annotation.PostConstruct;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Service
public class SimpleEmailSenderService {

    private static final Logger logger = LoggerFactory.getLogger(SimpleEmailSenderService.class);

    @Autowired
    private EmailConfiguration emailConfiguration;

    private Session session;

    public SimpleEmailSenderService() {
    }

    @PostConstruct
    public void init() {
        Properties props = new Properties();
        props.put("mail.smtp.auth", emailConfiguration.getAuth());
        props.put("mail.smtp.host", emailConfiguration.getHost());
        props.put("mail.smtp.port", emailConfiguration.getPort());
        props.put("mail.smtp.timeout", emailConfiguration.getTimeout());
        props.put("mail.smtp.ssl.enable", emailConfiguration.getSslEnable());
        MailAuthenticator mailAuthenticator = new MailAuthenticator();
        session = Session.getDefaultInstance(props, mailAuthenticator);
    }

    public void send(EmailMessage emailMessage) throws MessagingException {
        logger.info(emailMessage.getFrom() + " send email to " + emailMessage.getTo());
        long start = System.currentTimeMillis();
        MimeMessage mimeMessage = new MimeMessage(session);
        mimeMessage.setFrom(new InternetAddress(emailMessage.getFrom()));
        mimeMessage.setRecipients(Message.RecipientType.TO, emailMessage.getTo());
        mimeMessage.setSubject(emailMessage.getSubject());
        mimeMessage.setContent(emailMessage.getContent(), emailMessage.getContentType());
        Transport.send(mimeMessage);
        long end = System.currentTimeMillis();
        logger.info("This email sent use " + (end - start) + " ms");
    }
}

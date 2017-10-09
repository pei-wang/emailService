package com.pei.api.emailService.entity;

import javax.mail.Authenticator;

public class MailAuthenticator extends Authenticator {
    @Override
    protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
        return new javax.mail.PasswordAuthentication(System.getenv("Email_user"),
                System.getenv("Email_password"));
    }
}

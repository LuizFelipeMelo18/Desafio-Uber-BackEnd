package com.desafio.uber.application;

import com.desafio.uber.adapters.EmailSenderGateway;
import com.desafio.uber.core.cases.EmailSenderUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService implements EmailSenderUseCase{
    private final EmailSenderGateway emailSenderGateway;

    @Autowired
    public EmailSenderService(EmailSenderGateway emailSenderGateway){
        this.emailSenderGateway = emailSenderGateway;
    }

    @Override
    public void sendEmail(String toEmail, String subject, String body){
        emailSenderGateway.sendEmail(toEmail, subject, body);
    }
}

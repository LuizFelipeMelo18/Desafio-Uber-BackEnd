package com.desafio.uber.infra.ses;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.model.*;
import com.desafio.uber.adapters.EmailSenderGateway;
import com.desafio.uber.core.exceptions.EmailServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SesEmailSender implements EmailSenderGateway{
    private final AmazonSimpleEmailService sesCliente;

    @Autowired
    public SesEmailSender(AmazonSimpleEmailService sesCliente){
        this.sesCliente = sesCliente;
    }

    @Override
    public void sendEmail(String toEmail, String subject, String body){
        SendEmailRequest request = new SendEmailRequest()
                .withSource("SEU EMAIL")
                .withDestination(new Destination().withToAddresses(toEmail))
                .withMessage(new Message()
                        .withSubject(new Content(subject))
                        .withBody(new Body().withText(new Content(body)))
                );
        try {
            sesCliente.sendEmail(request);
        } catch (AmazonServiceException ex){
            throw new EmailServiceException("Email sending failed!", ex);
        }
    }
}

package com.desafio.uber.adapters;

public interface EmailSenderGateway {
    void sendEmail(String toEmail, String subject, String body);
}

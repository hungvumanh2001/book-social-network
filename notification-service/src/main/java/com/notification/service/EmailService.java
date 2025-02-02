package com.notification.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.notification.dto.request.EmailRequest;
import com.notification.dto.request.SendEmailRequest;
import com.notification.dto.request.Sender;
import com.notification.dto.response.EmailResponse;
import com.notification.exception.AppException;
import com.notification.exception.ErrorCode;
import com.notification.repository.httpclient.EmailClient;

import feign.FeignException;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class EmailService {
    EmailClient emailClient;

    String apiKey = "your-brevo-apikey";

    public EmailResponse sendEmail(SendEmailRequest request) {
        EmailRequest emailRequest = EmailRequest.builder()
                .sender(Sender.builder()
                        .name("Hungvm")
                        .email("hungvumanh2001@gmail.com")
                        .build())
                .to(List.of(request.getTo()))
                .subject(request.getSubject())
                .htmlContent(request.getHtmlContent())
                .build();
        try {
            return emailClient.sendEmail(apiKey, emailRequest);
        } catch (FeignException e) {
            throw new AppException(ErrorCode.CANNOT_SEND_EMAIL);
        }
    }
}

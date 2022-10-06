package com.amigoscode.notification;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class Notificationservice {

    private final NotificationRepo repo;

    public void send(NotificationRequest request) {

    
        Notification notification = Notification.builder()
                .toCustomerId(request.toCustomerId())
                .toCustomerEmail(request.toCustomerEmail())
                .sender("Amigoscode")
                .message(request.message())
                .sentAt(LocalDateTime.now())
                .build();

        repo.save(notification);

    }

}

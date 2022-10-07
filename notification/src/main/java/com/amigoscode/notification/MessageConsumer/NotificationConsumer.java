package com.amigoscode.notification.MessageConsumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.amigoscode.notification.NotificationRequest;
import com.amigoscode.notification.Notificationservice;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class NotificationConsumer {

    private final Notificationservice notificationservice;

    public NotificationConsumer(Notificationservice notificationservice) {
        this.notificationservice = notificationservice;
    }

    @RabbitListener(queues = "${rabbitmq.queues.notification}")
    public void Consumer(NotificationRequest request) {
        log.info("Consumed {} from queue", request);
        notificationservice.send(request);
    }
}

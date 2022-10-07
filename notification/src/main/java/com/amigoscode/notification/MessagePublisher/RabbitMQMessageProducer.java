package com.amigoscode.notification.MessagePublisher;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@AllArgsConstructor
public class RabbitMQMessageProducer {

    private final AmqpTemplate amqpTemplate;

    public void publish(Object payload, String exchange, String routingkey) {
        log.info("Publishing {} to exchange {} through routingKey {}", payload, exchange, routingkey);
        amqpTemplate.convertAndSend(exchange, routingkey, payload);
        log.info("Published {} to exchange {} through routingKey {}", payload, exchange, routingkey);
    }
}

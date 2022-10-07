package com.amigoscode.cutomer.MessagePublisher;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomerMQConfig {

    @Value("${rabbitmq.exchanges.internal}")
    private String internal_exchange;

    @Value("${rabbitmq.queues.notification}")
    private String notification_queue;

    @Value("${rabbitmq.routing-keys.internal-notification}")
    private String internal_notification_routing_key;

    public String getInternal_exchange() {
        return internal_exchange;
    }

    public String getNotification_queue() {
        return notification_queue;
    }

    public String getInternal_notification_routing_key() {
        return internal_notification_routing_key;
    }

    @Bean
    public TopicExchange getExchange() {
        return new TopicExchange(this.internal_exchange);
    }

    @Bean
    public Queue getNotificationQueue() {
        return new Queue(this.notification_queue);
    }

}

package com.amigoscode.notification;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import com.amigoscode.notification.MessagePublisher.NotificationMQConfig;
import com.amigoscode.notification.MessagePublisher.RabbitMQMessageProducer;

@SpringBootApplication
@EnableEurekaClient
public class NotificationApplication {

	public static void main(String[] args) {
		SpringApplication.run(NotificationApplication.class, args);
	}
    // @Bean
	// CommandLineRunner runner(RabbitMQMessageProducer producer, NotificationMQConfig config) {
	// 	return args -> {
	// 		producer.publish(new Person("Tom", "tom@gmail.com"), config.getInternal_exchange(), config.getInternal_notification_routing_key());
	// 	};

	// }

	// record Person(String name,String email)
	// {}

}

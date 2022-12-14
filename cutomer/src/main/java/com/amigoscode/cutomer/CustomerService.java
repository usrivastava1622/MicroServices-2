package com.amigoscode.cutomer;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
//import main.java.com.amigoscode.feignclient.FraudClient;

import com.amigoscode.cutomer.MessagePublisher.CustomerMQConfig;
import com.amigoscode.cutomer.MessagePublisher.RabbitMQMessageProducer;

import lombok.AllArgsConstructor;

//import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepostitory repo;
    private final RestTemplate template;
    // private final FraudCleint fraudCleint;

    private final RabbitMQMessageProducer producer;

    private final CustomerMQConfig config;

    public void registerCutomer(CustomerRegistrationRequest request) {

        Customer customer = Customer.builder()
                .firstname(request.firstname())
                .lastname(request.lastname())
                .email(request.email())
                .build();
        // valid email,email not taken,store in db
        repo.saveAndFlush(customer);
        // repo.findById()
        // FraudCheckResponse fraudCheckResponse = null;
        // try {
        //     fraudCheckResponse = template.getForObject("http://FRAUD/api/v1/check_fraud/" + customer.getId(),
        //             FraudCheckResponse.class);

        //     // fraudCheckResponse = fraudCleint.checkFraud(customer.getId());

        // } catch (NullPointerException e) {
        //     throw new NullPointerException("No response received " + e.getMessage().toString());
        // }

        // if (fraudCheckResponse.isFraudster()) {
        //     throw new IllegalStateException("User is fraudster");
        // }

        //template.getForObject("http://NOTIFICATION/api/v1/notification" + customer.getId(), String.class);
        NotificationRequest notificationRequest = new NotificationRequest(customer.getId(), customer.getEmail(),
                String.format("Hi %s, welcome to Amigoscode...",
                        customer.getFirstname()));
        //template.postForLocation("http://NOTIFICATION/api/v1/notification", notificationRequest);

        //publishing message
        producer.publish(notificationRequest, config.getInternal_exchange(), config.getInternal_notification_routing_key());

    }

}

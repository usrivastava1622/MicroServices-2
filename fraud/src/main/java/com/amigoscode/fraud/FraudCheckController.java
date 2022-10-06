package com.amigoscode.fraud;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1/check_fraud")
@AllArgsConstructor
public class FraudCheckController {

    private final FraudCheckService fraudCheckService;

    @GetMapping(path = "{customer_id}")
    public FraudCheckResponse checkFraud(@PathVariable("customer_id") Integer customer_id) {
        boolean fraud_response = fraudCheckService.isFraudster(customer_id);
        return new FraudCheckResponse(fraud_response);
    }

}

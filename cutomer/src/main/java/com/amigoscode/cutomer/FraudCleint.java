package com.amigoscode.cutomer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "fraud")
public interface FraudCleint {

    @GetMapping(path = "api/v1/check_fraud/{customer_id}")
    public FraudCheckResponse checkFraud(@PathVariable("customer_id") Integer customer_id);
    
}
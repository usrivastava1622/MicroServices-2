package com.amigoscode.cutomer;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/customers")
@Slf4j
public record CustomerController(CustomerService customerservice) {


    @PostMapping
    public void registerCutomer(@RequestBody CustomerRegistrationRequest customerRegistrationRequest)
    {
     log.info("new customer registration {}",  customerRegistrationRequest);
     customerservice.registerCutomer(customerRegistrationRequest);
    }
    
}

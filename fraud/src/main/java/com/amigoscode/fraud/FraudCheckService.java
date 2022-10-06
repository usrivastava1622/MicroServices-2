package com.amigoscode.fraud;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class FraudCheckService {

    private final FraudCheckHistoryRepo fraudCheckHistoryRepo;

    public boolean isFraudster(Integer customer_id) {
        FraudCheckHistory fraudCheckHistory = FraudCheckHistory.builder()
                .customer_id(customer_id)
                .isFraudster(false)
                .created(LocalDateTime.now())
                .build();
        fraudCheckHistoryRepo.save(fraudCheckHistory);
        return false;
    }

}

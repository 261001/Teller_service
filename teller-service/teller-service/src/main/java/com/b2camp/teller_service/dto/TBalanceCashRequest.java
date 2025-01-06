package com.b2camp.teller_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TBalanceCashRequest {
    private String accountNumber;
    private BigDecimal balance;
    private Timestamp createdAt;
}

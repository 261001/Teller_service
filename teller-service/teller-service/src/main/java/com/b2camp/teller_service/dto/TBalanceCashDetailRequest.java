package com.b2camp.teller_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TBalanceCashDetailRequest {
    private BigDecimal nominal;
    private String mutation;
    private String destAccountNumber;
    private String savingAccountNumber;
    private BigDecimal endBalance;
    private BigDecimal balance;
    private String referenceCode;

}

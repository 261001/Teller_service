package com.b2camp.teller_service.dto;

import com.b2camp.teller_service.entity.TSavingAccount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TSavingAccountDetailRequest {
    private TSavingAccount savingAccountId;
    private BigDecimal nominal;
    private String mutation;
    private String sourceAccountNumber;
    private String destAccountNumber;
    private BigDecimal endBalance;
    private BigDecimal balance;
    private String referenceCode;

}

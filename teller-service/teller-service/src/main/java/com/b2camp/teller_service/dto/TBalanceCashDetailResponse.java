package com.b2camp.teller_service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TBalanceCashDetailResponse {
    private String balanceCashDetailId;
    private String balanceCashId;
    private BigDecimal nominal;
    private String mutation;
    private String destAccountNumber;
    private BigDecimal endBalance;
    private BigDecimal balance;
    private String referenceCode;
    private Timestamp createdAt;
    private String createdBy;
    private Timestamp authorizationAt;
    private String authorizationBy;

}

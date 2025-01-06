package com.b2camp.teller_service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TBalanceCashResponse {
    private String balanceCashId;
    private String accountNumber;
    private BigDecimal balance;
    private String statusId;
    private boolean isDeleted;
    private Timestamp createdAt;
    private String createdBy;
    private Timestamp updatedAt;
    private String updatedBy;
    private Timestamp authorizationAt;
    private String authorizationBy;

}

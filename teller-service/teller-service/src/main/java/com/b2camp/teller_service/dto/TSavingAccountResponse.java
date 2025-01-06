package com.b2camp.teller_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TSavingAccountResponse {
    private String savingAccountId;
    private String accountNumber;
    private String cifId;
    private BigDecimal beginBalance;
    private BigDecimal endBalance;
    private BigDecimal currentBalance;
    private String statusId;
    private boolean isDeleted;
    private Timestamp authorizationAt;
    private String authorizationBy;
    private String savingId;
    private String savingName;
    private String statusName;
    private String createdBy;
    private Timestamp createdAt;
    private String updatedBy;
    private Timestamp updatedAt;

}

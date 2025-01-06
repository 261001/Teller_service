package com.b2camp.teller_service.dto;

import com.b2camp.teller_service.entity.MUser;
import com.b2camp.teller_service.entity.RStatus;
import com.b2camp.teller_service.entity.TSavingAccount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TSavingAccountDetailResponse {
    private String savingAccountDetail;
    private TSavingAccount savingAccountId;
    private BigDecimal nominal;
    private String mutation;
    private String destAccountNumber;
    private BigDecimal endBalance;
    private BigDecimal balance;
    private String referenceCode;
    private Timestamp createdAt;
    private MUser userIdDetail;
    private MUser userIdAuthorizationDetail;
    private RStatus statusIdDetail;
}

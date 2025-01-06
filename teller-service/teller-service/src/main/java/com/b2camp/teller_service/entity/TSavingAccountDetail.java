package com.b2camp.teller_service.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "t_saving_account_detail", schema = "public")
public class TSavingAccountDetail extends BaseReference {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "saving_account_detail_id", nullable = false)
    private String savingAccountDetailId;

    @Column(name = "saving_account_id", nullable = false)
    private String savingAccountId;

    @Column(name = "nominal", nullable = false)
    private BigDecimal nominal;

    @Column(name = "mutation", nullable = false)
    private String mutation;

    @Column(name = "dest_account_number", nullable = false)
    private String destAccountNumber;

    @Column(name = "end_balance", nullable = false)
    private BigDecimal endBalance;

    @Column(name = "balance", nullable = false)
    private BigDecimal balance;

    @Column(name = "reference_code", nullable = false)
    private String referenceCode;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "status_id", referencedColumnName = "status_id")
    private RStatus rStatus;

    @Column(name = "authorization_at")
    private Timestamp authorizationAt;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "authorization_by", referencedColumnName = "user_id")
    private MUser mUserAuthorizationBy;
}

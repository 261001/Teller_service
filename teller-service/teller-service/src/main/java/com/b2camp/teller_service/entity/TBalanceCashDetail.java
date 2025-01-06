package com.b2camp.teller_service.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "t_balance_cash_detail", schema = "public")
public class TBalanceCashDetail extends BaseReference {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "balance_cash_detail_id", nullable = false)
    private String balanceCashDetailId;

    @Column(name = "balance_cash_id", nullable = false)
    private String balanceCashId;

    @Column(name = "nominal")
    private BigDecimal nominal;

    @Column(name = "mutation", nullable = false)
    private String mutation;

    @Column(name = "dest_account_number", nullable = false)
    private String destAccountNumber;

    @Column(name = "end_balance")
    private BigDecimal endBalance;

    @Column(name = "balance")
    private BigDecimal balance;

    @Column(name = "reference_code")
    private String referenceCode;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "authorization_at")
    private Timestamp authorizationAt;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "authorization_by", referencedColumnName = "user_id")
    private MUser mUserAuthorizationBy;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "status_id", referencedColumnName = "status_id")
    private RStatus rStatus;
}

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

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "t_saving_account", schema = "public")
public class TSavingAccount extends BaseReference {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "saving_account_id", nullable = false)
    private String savingAccountId;

    @Column(name = "account_number", nullable = false)
    private String accountNumber;

    @Column(name = "balance")
    private BigDecimal balance;

    @ManyToOne
    @JoinColumn(name = "cif_id", referencedColumnName = "cif_id")
    private MCif mCifId;

    @Column(name = "begin_balance")
    private BigDecimal beginBalance;

    @Column(name = "end_balance")
    private BigDecimal endBalance;

    @Column(name = "current_balance")
    private BigDecimal currentBalance;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "status_id", referencedColumnName = "status_id")
    private RStatus rStatus;

    @Column(name = "is_deleted")
    private boolean isDeleted;

    @Column(name = "authorization_at")
    private Timestamp authorizationAt;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "authorization_by", referencedColumnName = "user_id")
    private MUser mUserAuthorizationBy;

    @ManyToOne
    @JoinColumn(name = "saving_id", referencedColumnName = "saving_id")
    private MSaving mSaving;
}

package com.b2camp.teller_service.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table (name = "m_saving",schema = "public")
public class MSaving {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "saving_id", nullable = false)
    private String savingId;

    @Column(name = "saving_cod")
    private String savingCode;

    @Column(name = "saving_name")
    private String savingName;

    @Column(name = "is_deleted")
    private boolean isDeleted;

    @Column(name = "denom")
    private Integer denom;

    @Column(name = "minimal_balance")
    private Integer minimalBalance;

    @Column(name = "tax")
    private Integer tax;
}

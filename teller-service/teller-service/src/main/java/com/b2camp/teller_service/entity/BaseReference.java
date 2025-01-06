package com.b2camp.teller_service.entity;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseReference {
    @ManyToOne
    @JoinColumn(name = "created_by", referencedColumnName = "user_id")
    private MUser createdBy;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @ManyToOne
    @JoinColumn(name = "updated_by", referencedColumnName = "user_id")
    private MUser updatedBy;

    @Column(name = "updated_at")
    private Timestamp updatedAt;
}

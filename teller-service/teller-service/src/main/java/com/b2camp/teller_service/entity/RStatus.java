package com.b2camp.teller_service.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "r_status", schema = "public")
public class RStatus {

    @Id
    @Column(name = "status_id", nullable = false)
    private String statusId;

    @Column(name = "status_code", nullable = false)
    private String statusCode;

    @Column(name = "status_name", nullable = false)
    private String statusName;
}

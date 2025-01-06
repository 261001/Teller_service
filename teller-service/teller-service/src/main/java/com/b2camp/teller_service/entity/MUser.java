package com.b2camp.teller_service.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table (name = "m_user",schema = "public")
public class MUser extends BaseReference {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "user_id", nullable = false, length = 70)
    private String userId;

    @Column(name = "is_deleted")
    private boolean isDeleted;

    @Column(name = "email", length = 70)
    private String email;

    @Column(name = "user_name", length = 100)
    private String userName;

    @Column(name = "password")
    private String password;

    @Column(name = "fullName", length = 100)
    private String fullName;

    @Column(name = "token", length = 225)
    private String token;

    @Column(name = "session_id", length = 225)
    private String sessionId;

    @ManyToOne
    @JoinColumn(name = "user_role_id", referencedColumnName = "user_role_id")
    private MUserRole mUserRole;

}

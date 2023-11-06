package com.ooadprojectserver.restaurantmanagement.model.user;

import com.ooadprojectserver.restaurantmanagement.model.user.baseUser.User;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@DynamicInsert
@DynamicUpdate
@Entity
@Table(name = "manager")
public class Manager extends User {
    @Column(name = "certification_management", nullable = false)
    private String certificationManagement;

    @Column(name = "foreign_language", nullable = false)
    @JdbcTypeCode(SqlTypes.NVARCHAR)
    private String foreignLanguage;

    @Column(name = "experienced_year", nullable = false)
    @JdbcTypeCode(SqlTypes.NVARCHAR)
    private String experiencedYear;

    public Manager(User user, String certificationManagement, String foreignLanguage, String experiencedYear) {
        super(user);
        this.certificationManagement = certificationManagement;
        this.foreignLanguage = foreignLanguage;
        this.experiencedYear = experiencedYear;
    }
}
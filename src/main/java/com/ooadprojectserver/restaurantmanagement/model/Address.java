package com.ooadprojectserver.restaurantmanagement.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@DynamicInsert
@DynamicUpdate
@Entity
@Table(name = "address")
public class Address implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "address_line", nullable = false)
    @JdbcTypeCode(SqlTypes.NVARCHAR)
    private String addressLine;

    @Column(name = "city", nullable = false)
    @JdbcTypeCode(SqlTypes.NVARCHAR)
    private String city;

    @Column(name = "region", nullable = false)
    @JdbcTypeCode(SqlTypes.NVARCHAR)
    private String region;

}
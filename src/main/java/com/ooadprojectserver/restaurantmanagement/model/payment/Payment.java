package com.ooadprojectserver.restaurantmanagement.model.payment;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ooadprojectserver.restaurantmanagement.model.CommonEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "payment")
public class Payment extends CommonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "type", nullable = false)
    @NotNull
    @Enumerated(EnumType.ORDINAL)
    @JsonFormat(shape = JsonFormat.Shape.NUMBER)
    private PaymentType paymentType;

    @ManyToOne
    @JoinColumn(name = "method_id")
    private TransferMethod methodId;
}
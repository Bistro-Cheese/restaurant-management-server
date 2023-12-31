package com.ooadprojectserver.restaurantmanagement.model.discount;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ooadprojectserver.restaurantmanagement.constant.DateTimeConstant;
import com.ooadprojectserver.restaurantmanagement.model.CommonEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "discount")
public class Discount extends CommonEntity {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @NotNull
    @Column(name = "type", nullable = false)
    @Enumerated(EnumType.ORDINAL)
    @JsonFormat(shape = JsonFormat.Shape.NUMBER)
    private DiscountType type;

    @NotNull
    @Column(name = "value", nullable = false)
    private BigDecimal value;

    @NotNull
    @Column(name = "start_date", nullable = false)
    @JsonFormat(pattern = DateTimeConstant.FORMAT_DATE_TIME, timezone = DateTimeConstant.TIMEZONE)
    private Date startDate;

    @NotNull
    @Column(name = "end_date", nullable = false)
    @JsonFormat(pattern = DateTimeConstant.FORMAT_DATE_TIME, timezone = DateTimeConstant.TIMEZONE)
    private Date endDate;

    @NotNull
    @Column(name = "uses_cnt", nullable = false)
    private Integer usesCount;

    @NotNull
    @Column(name = "uses_max", nullable = false)
    private Integer usesMax;

    @NotNull
    @Column(name = "is_active", nullable = false)
    private Boolean isActive;

    public BigDecimal calculateDiscount(BigDecimal total){
        if (!this.isActive) return BigDecimal.valueOf(0);
        if (this.usesMax != null && this.usesCount >= this.usesMax) return BigDecimal.valueOf(0);
        if (this.type == DiscountType.PERCENTAGE) {
            return total.multiply(this.value).divide(BigDecimal.valueOf(100));
        } else {
            return this.value;
        }
    }

    public Boolean canUseDiscount()
    {
        Date currentDate = new Date();
        return currentDate.before(this.endDate) && currentDate.after(this.startDate);
    }
}
package com.scholarshipholders.core.model.payment;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@Builder
public class CreatePaymentModel {

    private BigDecimal amount;
    private LocalDate paymentDate;
    private UUID scholarId;

}

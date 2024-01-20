package com.scholarshipholders.core.model.payment;

import com.scholarshipholders.infrastructure.entity.payment.enums.PaymentStatusEnum;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@Builder
public class GetPaymentModel {

    private UUID id;
    private BigDecimal amount;
    private LocalDate paymentDate;
    private PaymentStatusEnum paymentStatus;
    private GetPaymentScholarModel scholar;

    public boolean hasValidFutureStatus(PaymentStatusEnum paymentStatusEnum) {
        return getPaymentStatus().canUpdateFor(paymentStatusEnum);
    }

}

package com.scholarshipholders.core.model.payment;

import com.scholarshipholders.infrastructure.entity.payment.enums.PaymentStatusEnum;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Builder
public class UpdatePaymentModel {

    private UUID id;
    private UUID scholarId;
    private PaymentStatusEnum paymentStatus;


}

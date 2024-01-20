package com.scholarshipholders.infrastructure.entity.payment.enums;

import java.util.Arrays;
import java.util.List;

public enum PaymentStatusEnum {
    PAID(),
    CANCELLED(),
    REQUESTED(PAID, CANCELLED),
    NOT_COMPLETED(REQUESTED, CANCELLED);


    private final List<PaymentStatusEnum> futureStatus;

    PaymentStatusEnum(PaymentStatusEnum... futureStatus) {
        this.futureStatus = Arrays.asList(futureStatus);
    }

    public boolean canUpdateFor(PaymentStatusEnum newStatus) {
        return this.futureStatus.contains(newStatus);
    }

}

package com.scholarshipholders.core.model.payment;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class GetPaymentScholarModel {

    private Integer bankCode;
    private Integer bankAgency;
    private Long accountNumber;

}

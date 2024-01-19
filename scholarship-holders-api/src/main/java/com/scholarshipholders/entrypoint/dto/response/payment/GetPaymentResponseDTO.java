package com.scholarshipholders.entrypoint.dto.response.payment;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.scholarshipholders.infrastructure.entity.payment.enums.PaymentStatusEnum;
import com.scholarshipholders.infrastructure.entity.scholar.enums.DocumentTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.LowerCamelCaseStrategy.class)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class GetPaymentResponseDTO {

    private BigDecimal amount;
    private LocalDate paymentDate;
    private PaymentStatusEnum paymentStatus;
    private GetPaymentScholarResponseDTO scholar;
}

package com.scholarshipholders.dummy;

import com.scholarshipholders.core.model.payment.CreatePaymentModel;
import com.scholarshipholders.core.model.payment.GetPaymentModel;
import com.scholarshipholders.core.model.payment.UpdatePaymentModel;
import com.scholarshipholders.core.model.scholar.CreateScholarModel;
import com.scholarshipholders.core.model.scholar.GetScholarModel;
import com.scholarshipholders.core.model.scholar.UpdateScholarModel;
import com.scholarshipholders.entrypoint.dto.request.payment.CreatePaymentRequestDTO;
import com.scholarshipholders.entrypoint.dto.request.payment.UpdatePaymentRequestDTO;
import com.scholarshipholders.entrypoint.dto.request.scholar.CreateScholarRequestDTO;
import com.scholarshipholders.entrypoint.dto.request.scholar.UpdateScholarRequestDTO;
import com.scholarshipholders.entrypoint.dto.response.scholar.GetScholarResponseDTO;
import com.scholarshipholders.entrypoint.dto.response.scholar.UpdateScholarResponseDTO;
import com.scholarshipholders.infrastructure.entity.payment.PaymentEntity;
import com.scholarshipholders.infrastructure.entity.payment.enums.PaymentStatusEnum;
import com.scholarshipholders.infrastructure.entity.scholar.ScholarEntity;
import com.scholarshipholders.infrastructure.entity.scholar.enums.DocumentTypeEnum;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public class PaymentDummy {

    public static CreatePaymentRequestDTO.CreatePaymentRequestDTOBuilder createPaymentRequestDTOBuilder() {
        return CreatePaymentRequestDTO.builder()
                .paymentDate(LocalDate.now().plusDays(2))
                .amount(BigDecimal.TEN);
    }

    public static CreatePaymentModel.CreatePaymentModelBuilder createPaymentModelBuilder() {
        return CreatePaymentModel.builder()
                .paymentDate(LocalDate.now().plusDays(2))
                .amount(BigDecimal.TEN)
                .scholarId(UUID.randomUUID());
    }

    public static UpdatePaymentRequestDTO.UpdatePaymentRequestDTOBuilder updatePaymentRequestDTOBuilder() {
        return UpdatePaymentRequestDTO.builder()
                .id(UUID.randomUUID())
                .paymentStatus(PaymentStatusEnum.PAID)
                .scholarId(UUID.randomUUID());
    }

    public static UpdatePaymentModel.UpdatePaymentModelBuilder updatePaymentModelBuilder() {
        return UpdatePaymentModel.builder()
                .id(UUID.randomUUID())
                .paymentStatus(PaymentStatusEnum.PAID)
                .scholarId(UUID.randomUUID());
    }

    public static PaymentEntity.PaymentEntityBuilder paymentEntityBuilder() {
        return PaymentEntity.builder()
                .id(UUID.randomUUID())
                .paymentStatus(PaymentStatusEnum.REQUESTED)
                .amount(BigDecimal.valueOf(100))
                .paymentDate(LocalDate.now())
                .scholar(ScholarDummy.scholarEntityBuilder().build());
    }

    public static GetPaymentModel.GetPaymentModelBuilder getPaymentModelBuilder() {
        return GetPaymentModel.builder()
                .id(UUID.randomUUID())
                .paymentStatus(PaymentStatusEnum.REQUESTED)
                .amount(BigDecimal.valueOf(100))
                .paymentDate(LocalDate.now());
    }


}

package com.scholarshipholders.core.ports.out.repository;


import com.scholarshipholders.core.model.payment.CreatePaymentModel;
import com.scholarshipholders.core.model.payment.GetPaymentModel;
import com.scholarshipholders.infrastructure.entity.payment.PaymentEntity;
import com.scholarshipholders.infrastructure.entity.payment.enums.PaymentStatusEnum;
import com.scholarshipholders.infrastructure.entity.scholar.ScholarEntity;

import java.util.List;
import java.util.UUID;

public interface IPaymentRepositoryPort {

    void createPayment(CreatePaymentModel createPaymentModel);

    List<GetPaymentModel> getPayments(UUID scholarId);

    PaymentEntity findPaymentEntity(UUID paymentId, ScholarEntity scholarEntity);

    void updatePaymentStatus(PaymentEntity paymentEntity, PaymentStatusEnum newStatus);

    void deletePayment(UUID paymentId, UUID id);

}

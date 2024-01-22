package com.scholarshipholders.core.adapter.service;


import com.scholarshipholders.core.exception.BusinessException;
import com.scholarshipholders.core.model.payment.CreatePaymentModel;
import com.scholarshipholders.core.model.payment.GetPaymentModel;
import com.scholarshipholders.core.model.payment.UpdatePaymentModel;
import com.scholarshipholders.core.ports.in.service.IPaymentServicePort;
import com.scholarshipholders.core.ports.out.repository.IPaymentRepositoryPort;
import com.scholarshipholders.core.ports.out.repository.IScholarRepositoryPort;
import com.scholarshipholders.infrastructure.entity.payment.PaymentEntity;
import com.scholarshipholders.infrastructure.entity.payment.enums.PaymentStatusEnum;
import com.scholarshipholders.infrastructure.entity.scholar.ScholarEntity;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Slf4j
@Service
@AllArgsConstructor
public class PaymentServiceAdapterImpl implements IPaymentServicePort {

    private final IPaymentRepositoryPort paymentRepositoryPort;
    private final IScholarRepositoryPort scholarRepositoryPort;


    @Override
    @Transactional
    public void createPayment(CreatePaymentModel createPaymentModel) {
        log.info("Class {} method createPayment", this.getClass().getName());

        paymentRepositoryPort.createPayment(createPaymentModel);
    }

    @Override
    public List<GetPaymentModel> getPayments(UUID scholarId) {

        return paymentRepositoryPort.getPayments(scholarId);
    }

    @Override
    @Transactional
    public void updatePaymentStatus(UpdatePaymentModel updatePaymentModel) {
        log.info("Class {} method updatePaymentStatus", this.getClass().getName());

        ScholarEntity scholarEntity = scholarRepositoryPort.getScholarEntity(updatePaymentModel.getScholarId());
        PaymentEntity paymentEntity = paymentRepositoryPort.findPaymentEntity(updatePaymentModel.getId(), scholarEntity);

        validatePaymentStatusUpdate(paymentEntity, updatePaymentModel.getPaymentStatus());

        paymentRepositoryPort.updatePaymentStatus(paymentEntity, updatePaymentModel.getPaymentStatus());
    }

    @Override
    @Transactional
    public void deletePayment(UUID scholarId, UUID paymentId) {
        log.info("Class {} method deletePayment", this.getClass().getName());

        paymentRepositoryPort.deletePayment(scholarId, paymentId);
    }

    private void validatePaymentStatusUpdate(PaymentEntity paymentEntity, PaymentStatusEnum newStatus) {
        if (!paymentEntity.hasValidFutureStatus(newStatus)) {
            throw new BusinessException(
                    String.format("Pagamento %s não pode ser alterado de %s para %s",
                            paymentEntity.getId(),
                            paymentEntity.getPaymentStatus().name(),
                            newStatus.name()));
        }
    }
}

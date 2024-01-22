package com.scholarshipholders.infrastructure.repository.adapter.payment;


import com.scholarshipholders.core.exception.NotFoundException;
import com.scholarshipholders.core.model.payment.CreatePaymentModel;
import com.scholarshipholders.core.model.payment.GetPaymentModel;
import com.scholarshipholders.core.ports.out.repository.IPaymentRepositoryPort;
import com.scholarshipholders.core.ports.out.repository.IScholarRepositoryPort;
import com.scholarshipholders.infrastructure.entity.payment.PaymentEntity;
import com.scholarshipholders.infrastructure.entity.payment.enums.PaymentStatusEnum;
import com.scholarshipholders.infrastructure.entity.scholar.ScholarEntity;
import com.scholarshipholders.infrastructure.mapper.IPaymentInfrastructureMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;


@Slf4j
@Component
@AllArgsConstructor
public class PaymentRepositoryAdapterImpl implements IPaymentRepositoryPort {

    private final ISpringPaymentRepositoryAdapter springPaymentRepositoryAdapter;
    private final IPaymentInfrastructureMapper paymentInfrastructureMapper;
    private final IScholarRepositoryPort scholarRepositoryPort;


    @Override
    public void createPayment(CreatePaymentModel createPaymentModel) {
        log.info("Class {} method createPayment", this.getClass().getName());

        ScholarEntity scholarEntity = scholarRepositoryPort.getScholarEntity(createPaymentModel.getScholarId());

        PaymentEntity paymentEntity = PaymentEntity.builder()
                .scholar(scholarEntity)
                .paymentStatus(PaymentStatusEnum.NOT_COMPLETED)
                .paymentDate(createPaymentModel.getPaymentDate())
                .amount(createPaymentModel.getAmount())
                .build();
        log.info("PaymentEntity {}", paymentEntity);


        PaymentEntity payment = springPaymentRepositoryAdapter.save(paymentEntity);
        log.info("PaymentEntity created {}", payment);
    }

    @Override
    public List<GetPaymentModel> getPayments(UUID scholarId) {
        log.info("Class {} method getPayments", this.getClass().getName());

        ScholarEntity scholarEntity = scholarRepositoryPort.getScholarEntity(scholarId);

        List<PaymentEntity> paymentEntities = springPaymentRepositoryAdapter.findByScholar(scholarEntity);

        List<GetPaymentModel> paymentModels = paymentEntities.stream()
                .map(paymentEntity -> paymentInfrastructureMapper.toGetPaymentModel(paymentEntity, scholarEntity))
                .collect(Collectors.toList());
        log.info("List<GetPaymentModel> {}", paymentModels);

        return paymentModels;
    }

    @Override
    public PaymentEntity findPaymentEntity(UUID paymentId, ScholarEntity scholarEntity) {
        log.info("Class {} method findPaymentEntity", this.getClass().getName());

        Optional<PaymentEntity> paymentEntity = springPaymentRepositoryAdapter.findByIdAndScholar(paymentId, scholarEntity);
        return paymentEntity.orElseThrow(() -> new NotFoundException("Pagamento não encontrado"));
    }

    @Override
    public void updatePaymentStatus(PaymentEntity paymentEntity, PaymentStatusEnum newStatus) {
        log.info("Class {} method updatePaymentStatus", this.getClass().getName());

        paymentEntity.setPaymentStatus(newStatus);
        springPaymentRepositoryAdapter.save(paymentEntity);
    }

    @Override
    public void deletePayment(UUID scholarId, UUID paymentId) {
        log.info("Class {} method deletePayment", this.getClass().getName());

        springPaymentRepositoryAdapter.deleteByIdAndScholarId(paymentId, scholarId);
    }
}

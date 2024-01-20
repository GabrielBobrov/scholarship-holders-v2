package com.scholarshipholders.infrastructure.repository.adapter.payment;


import com.scholarshipholders.core.exception.BusinessException;
import com.scholarshipholders.core.exception.NotFoundException;
import com.scholarshipholders.core.model.payment.CreatePaymentModel;
import com.scholarshipholders.core.model.payment.GetPaymentModel;
import com.scholarshipholders.core.model.payment.UpdatePaymentModel;
import com.scholarshipholders.core.ports.out.repository.IPaymentRepositoryPort;
import com.scholarshipholders.infrastructure.entity.payment.PaymentEntity;
import com.scholarshipholders.infrastructure.entity.payment.enums.PaymentStatusEnum;
import com.scholarshipholders.infrastructure.entity.scholar.ScholarEntity;
import com.scholarshipholders.infrastructure.mapper.IPaymentInfrastructureMapper;
import com.scholarshipholders.infrastructure.repository.adapter.scholar.ISpringScholarRepositoryAdapter;
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
    private final ISpringScholarRepositoryAdapter springScholarRepositoryAdapter;
    private final IPaymentInfrastructureMapper paymentInfrastructureMapper;


    @Override
    public void createPayment(CreatePaymentModel createPaymentModel) {
        log.info("Class {} method createPayment", this.getClass().getName());

        ScholarEntity scholarEntity = getScholarEntity(createPaymentModel.getScholarId());

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

        ScholarEntity scholarEntity = getScholarEntity(scholarId);

        List<PaymentEntity> paymentEntities = springPaymentRepositoryAdapter.findByScholar(scholarEntity);

        List<GetPaymentModel> paymentModels = paymentEntities.stream()
                .map(paymentEntity -> paymentInfrastructureMapper.toGetPaymentModel(paymentEntity, scholarEntity))
                .collect(Collectors.toList());
        log.info("List<GetPaymentModel> {}", paymentModels);

        return paymentModels;
    }

    @Override
    public PaymentEntity findPaymentEntity(UUID paymentId, ScholarEntity scholarEntity) {
        Optional<PaymentEntity> paymentEntity = springPaymentRepositoryAdapter.findByIdAndScholar(paymentId, scholarEntity);
        return paymentEntity.orElseThrow(() -> new NotFoundException("Pagamento não encontrado"));
    }

    @Override
    public ScholarEntity getScholarEntity(UUID scholarId) {
        ScholarEntity scholarEntity = springScholarRepositoryAdapter.findById(scholarId)
                .orElseThrow(() -> new NotFoundException("Bolsista não encontrado"));
        log.info("ScholarEntity {}", scholarEntity);
        return scholarEntity;
    }

    @Override
    public void updatePaymentStatus(PaymentEntity paymentEntity, PaymentStatusEnum newStatus) {
        paymentEntity.setPaymentStatus(newStatus);
        springPaymentRepositoryAdapter.save(paymentEntity);
    }
}

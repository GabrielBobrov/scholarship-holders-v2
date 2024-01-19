package com.scholarshipholders.infrastructure.repository.adapter.payment;


import com.scholarshipholders.core.exception.NotFoundException;
import com.scholarshipholders.core.model.payment.CreatePaymentModel;
import com.scholarshipholders.core.model.scholar.CreateScholarModel;
import com.scholarshipholders.core.model.scholar.GetScholarModel;
import com.scholarshipholders.core.model.scholar.UpdateScholarModel;
import com.scholarshipholders.core.ports.out.repository.IPaymentRepositoryPort;
import com.scholarshipholders.core.ports.out.repository.IScholarRepositoryPort;
import com.scholarshipholders.infrastructure.entity.payment.PaymentEntity;
import com.scholarshipholders.infrastructure.entity.payment.enums.PaymentStatusEnum;
import com.scholarshipholders.infrastructure.entity.scholar.ScholarEntity;
import com.scholarshipholders.infrastructure.entity.scholar.enums.DocumentTypeEnum;
import com.scholarshipholders.infrastructure.mapper.IPaymentInfrastructureMapper;
import com.scholarshipholders.infrastructure.mapper.IScholarInfrastructureMapper;
import com.scholarshipholders.infrastructure.repository.adapter.scholar.ISpringScholarRepositoryAdapter;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
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

        ScholarEntity scholarEntity = springScholarRepositoryAdapter.findById(createPaymentModel.getScholarId())
                .orElseThrow(() -> new NotFoundException("Bolsista não encontrado"));
        log.info("ScholarEntity {}", scholarEntity);

        PaymentEntity paymentEntity = PaymentEntity.builder()
                .scholar(scholarEntity)
                .paymentStatus(PaymentStatusEnum.REQUESTED)
                .paymentDate(createPaymentModel.getPaymentDate())
                .amount(createPaymentModel.getAmount())
                .build();
        log.info("PaymentEntity {}", paymentEntity);


        PaymentEntity payment = springPaymentRepositoryAdapter.save(paymentEntity);
        log.info("PaymentEntity created {}", payment);
    }
}

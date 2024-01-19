package com.scholarshipholders.core.adapter.service;


import com.scholarshipholders.core.model.payment.CreatePaymentModel;
import com.scholarshipholders.core.model.payment.GetPaymentModel;
import com.scholarshipholders.core.ports.in.service.IPaymentServicePort;
import com.scholarshipholders.core.ports.out.repository.IPaymentRepositoryPort;
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


    @Override
    public void createPayment(CreatePaymentModel createPaymentModel) {
        log.info("Class {} method createPayment", this.getClass().getName());

        paymentRepositoryPort.createPayment(createPaymentModel);
    }

    @Override
    public List<GetPaymentModel> getPayments(UUID scholarId) {

        return paymentRepositoryPort.getPayments(scholarId);
    }
}

package com.scholarshipholders.core.ports.out.repository;


import com.scholarshipholders.core.model.payment.CreatePaymentModel;
import com.scholarshipholders.core.model.payment.GetPaymentModel;

import java.util.List;
import java.util.UUID;

public interface IPaymentRepositoryPort {

    void createPayment(CreatePaymentModel createPaymentModel);

    List<GetPaymentModel> getPayments(UUID scholarId);


}

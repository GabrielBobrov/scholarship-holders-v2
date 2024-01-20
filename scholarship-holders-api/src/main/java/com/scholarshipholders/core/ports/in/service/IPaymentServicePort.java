package com.scholarshipholders.core.ports.in.service;


import com.scholarshipholders.core.model.payment.CreatePaymentModel;
import com.scholarshipholders.core.model.payment.GetPaymentModel;
import com.scholarshipholders.core.model.payment.UpdatePaymentModel;

import java.util.List;
import java.util.UUID;

public interface IPaymentServicePort {

    void createPayment(CreatePaymentModel createPaymentModel);

    List<GetPaymentModel> getPayments(UUID scholarId);

    void updatePaymentStatus(UpdatePaymentModel updatePaymentModel);


}



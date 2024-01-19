package com.scholarshipholders.core.ports.out.repository;


import com.scholarshipholders.core.model.payment.CreatePaymentModel;

public interface IPaymentRepositoryPort {

    void createPayment(CreatePaymentModel createPaymentModel);


}

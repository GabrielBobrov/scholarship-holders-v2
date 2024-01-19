package com.scholarshipholders.core.ports.in.service;


import com.scholarshipholders.core.model.payment.CreatePaymentModel;

public interface IPaymentServicePort {

    void createPayment(CreatePaymentModel createPaymentModel);


}



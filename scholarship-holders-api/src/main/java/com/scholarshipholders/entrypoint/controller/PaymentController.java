package com.scholarshipholders.entrypoint.controller;


import com.scholarshipholders.core.model.payment.CreatePaymentModel;
import com.scholarshipholders.core.model.scholar.CreateScholarModel;
import com.scholarshipholders.core.ports.in.service.IPaymentServicePort;
import com.scholarshipholders.core.ports.in.service.IScholarServicePort;
import com.scholarshipholders.entrypoint.UrlConstant;
import com.scholarshipholders.entrypoint.dto.request.payment.CreatePaymentRequestDTO;
import com.scholarshipholders.entrypoint.dto.request.scholar.CreateScholarRequestDTO;
import com.scholarshipholders.entrypoint.mapper.IPaymentEntrypointMapper;
import com.scholarshipholders.entrypoint.mapper.IScholarEntrypointMapper;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping(value = UrlConstant.PAYMENT_URI)
public class PaymentController {

    private final IPaymentServicePort paymentServicePort;
    private final IPaymentEntrypointMapper paymentEntrypointMapper;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createPayment(@RequestBody @Valid CreatePaymentRequestDTO createPaymentRequestDTO, @PathVariable UUID scholarId) {
        log.info("Class {} method createPayment", this.getClass().getName());
        log.info("CreatePaymentRequestDTO {}", createPaymentRequestDTO);

        CreatePaymentModel createPaymentModel = paymentEntrypointMapper.fromCreatePaymentRequestDTOToCreatePaymentModel(createPaymentRequestDTO);
        createPaymentModel.setScholarId(scholarId);

        paymentServicePort.createPayment(createPaymentModel);
    }


}




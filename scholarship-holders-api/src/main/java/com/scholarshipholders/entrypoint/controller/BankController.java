package com.scholarshipholders.entrypoint.controller;


import com.scholarshipholders.core.model.payment.CreatePaymentModel;
import com.scholarshipholders.core.model.payment.GetPaymentModel;
import com.scholarshipholders.core.model.payment.UpdatePaymentModel;
import com.scholarshipholders.core.ports.in.service.IBankServicePort;
import com.scholarshipholders.core.ports.in.service.IPaymentServicePort;
import com.scholarshipholders.entrypoint.UrlConstant;
import com.scholarshipholders.entrypoint.dto.request.payment.CreatePaymentRequestDTO;
import com.scholarshipholders.entrypoint.dto.request.payment.UpdatePaymentRequestDTO;
import com.scholarshipholders.entrypoint.dto.response.payment.GetPaymentResponseDTO;
import com.scholarshipholders.entrypoint.mapper.IPaymentEntrypointMapper;
import com.scholarshipholders.infrastructure.integration.ms.account.model.response.GetBanksResponseDTO;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping(value = UrlConstant.BANK_URI)
public class BankController {

    private final IBankServicePort bankServicePort;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<GetBanksResponseDTO> getBanks() {
        log.info("Class {} method getBanks", this.getClass().getName());

        return bankServicePort.getBanks();
    }

}




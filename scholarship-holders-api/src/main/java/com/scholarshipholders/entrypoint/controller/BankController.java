package com.scholarshipholders.entrypoint.controller;


import com.scholarshipholders.core.ports.in.service.IBankServicePort;
import com.scholarshipholders.entrypoint.UrlConstant;
import com.scholarshipholders.infrastructure.integration.ms.account.model.response.GetBanksResponseDTO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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




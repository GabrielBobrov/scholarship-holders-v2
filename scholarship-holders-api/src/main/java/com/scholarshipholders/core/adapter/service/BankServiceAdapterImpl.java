package com.scholarshipholders.core.adapter.service;


import com.scholarshipholders.core.ports.in.service.IBankServicePort;
import com.scholarshipholders.infrastructure.integration.bank.model.response.GetBanksResponseDTO;
import com.scholarshipholders.infrastructure.integration.bank.port.in.IBankHttpClientPort;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Slf4j
@Service
@AllArgsConstructor
public class BankServiceAdapterImpl implements IBankServicePort {

    private final IBankHttpClientPort bankHttpClientPort;

    @Override
    public List<GetBanksResponseDTO> getBanks() {
        log.info("Class {} method getScholar", this.getClass().getName());

        List<GetBanksResponseDTO> banks = bankHttpClientPort.getBanks();
        List<GetBanksResponseDTO> banksWithCode = banks.stream()
                .filter(Objects::nonNull)
                .filter(bank -> bank.getCode() != null)
                .collect(Collectors.toList());
        log.info("banks {} ", banks);

        return banksWithCode;
    }
}

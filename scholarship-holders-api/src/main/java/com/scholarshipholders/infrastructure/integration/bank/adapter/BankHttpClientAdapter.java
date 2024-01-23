package com.scholarshipholders.infrastructure.integration.bank.adapter;


import com.scholarshipholders.infrastructure.integration.bank.client.BankHttpClient;
import com.scholarshipholders.infrastructure.integration.bank.model.response.GetBanksResponseDTO;
import com.scholarshipholders.infrastructure.integration.bank.port.in.IBankHttpClientPort;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
@AllArgsConstructor
public class BankHttpClientAdapter implements IBankHttpClientPort {

    private final BankHttpClient bankHttpClient;

    @Override
    public List<GetBanksResponseDTO> getBanks() {
        log.info("Class {} method getBanks", this.getClass().getName());

        return bankHttpClient.getBanks();
    }

}

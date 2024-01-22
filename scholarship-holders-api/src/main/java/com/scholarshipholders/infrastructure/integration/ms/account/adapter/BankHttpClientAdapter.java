package com.scholarshipholders.infrastructure.integration.ms.account.adapter;


import com.scholarshipholders.infrastructure.integration.ms.account.client.BankHttpClient;
import com.scholarshipholders.infrastructure.integration.ms.account.model.response.GetBanksResponseDTO;
import com.scholarshipholders.infrastructure.integration.ms.account.port.in.IBankHttpClientPort;
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

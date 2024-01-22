package com.scholarshipholders.infrastructure.integration.ms.account.client;


import com.scholarshipholders.infrastructure.integration.ms.account.model.response.GetBanksResponseDTO;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

import java.util.List;

@HttpExchange("api/banks/v1")
public interface BankHttpClient {

    @GetExchange
    List<GetBanksResponseDTO> getBanks();


}

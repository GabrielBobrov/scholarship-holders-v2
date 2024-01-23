package com.scholarshipholders.infrastructure.integration.bank.port.in;


import com.scholarshipholders.infrastructure.integration.bank.model.response.GetBanksResponseDTO;

import java.util.List;

public interface IBankHttpClientPort {
    List<GetBanksResponseDTO> getBanks();

}

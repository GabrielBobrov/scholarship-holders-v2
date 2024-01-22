package com.scholarshipholders.infrastructure.integration.ms.account.port.in;


import com.scholarshipholders.infrastructure.integration.ms.account.model.response.GetBanksResponseDTO;

import java.util.List;

public interface IBankHttpClientPort {
    List<GetBanksResponseDTO> getBanks();

}

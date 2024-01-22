package com.scholarshipholders.core.ports.in.service;


import com.scholarshipholders.infrastructure.integration.ms.account.model.response.GetBanksResponseDTO;

import java.util.List;

public interface IBankServicePort {

    List<GetBanksResponseDTO> getBanks();


}



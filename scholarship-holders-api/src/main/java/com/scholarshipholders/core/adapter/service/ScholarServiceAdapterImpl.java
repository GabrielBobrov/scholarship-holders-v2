package com.scholarshipholders.core.adapter.service;


import com.scholarshipholders.core.model.GetScholarModel;
import com.scholarshipholders.core.ports.in.service.IScholarServicePort;
import com.scholarshipholders.core.ports.out.repository.IScholarRepositoryPort;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
@AllArgsConstructor
public class ScholarServiceAdapterImpl implements IScholarServicePort {

    private final IScholarRepositoryPort accountRepositoryPort;


    @Override
    public GetScholarModel getScholar(UUID id) {
        log.info("Class {} method getScholar", this.getClass().getName());

        return accountRepositoryPort.getScholar(id);
    }
}

package com.scholarshipholders.core.adapter.service;


import com.scholarshipholders.core.model.CreateScholarModel;
import com.scholarshipholders.core.model.GetScholarModel;
import com.scholarshipholders.core.model.UpdateScholarModel;
import com.scholarshipholders.core.ports.in.service.IScholarServicePort;
import com.scholarshipholders.core.ports.out.repository.IScholarRepositoryPort;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Slf4j
@Service
@AllArgsConstructor
public class ScholarServiceAdapterImpl implements IScholarServicePort {

    private final IScholarRepositoryPort scholarRepositoryPort;


    @Override
    public GetScholarModel getScholar(UUID id) {
        log.info("Class {} method getScholar", this.getClass().getName());

        return scholarRepositoryPort.getScholar(id);
    }

    @Override
    public List<GetScholarModel> getScholars() {
        log.info("Class {} method getScholars", this.getClass().getName());

        return scholarRepositoryPort.getScholars();
    }

    @Override
    @Transactional
    public void createScholar(CreateScholarModel createScholarModel) {
        log.info("Class {} method createScholar", this.getClass().getName());

        scholarRepositoryPort.createScholar(createScholarModel);

    }

    @Override
    public UpdateScholarModel updateScholar(UpdateScholarModel updateScholarModel) {
        log.info("Class {} method updateScholar", this.getClass().getName());

        return scholarRepositoryPort.updateScholar(updateScholarModel);
    }
}

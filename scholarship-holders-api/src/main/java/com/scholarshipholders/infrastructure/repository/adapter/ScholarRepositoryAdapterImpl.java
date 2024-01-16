package com.scholarshipholders.infrastructure.repository.adapter;


import com.scholarshipholders.core.exception.NotFoundException;
import com.scholarshipholders.core.model.GetScholarModel;
import com.scholarshipholders.core.ports.out.repository.IScholarRepositoryPort;
import com.scholarshipholders.infrastructure.entity.ScholarEntity;
import com.scholarshipholders.infrastructure.mapper.IScholarInfrastructureMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


@Slf4j
@Component
@AllArgsConstructor
public class ScholarRepositoryAdapterImpl implements IScholarRepositoryPort {

    private final ISpringScholarRepositoryAdapter springAccountRepository;
    private final IScholarInfrastructureMapper accountInfrastructureMapper;


    @Override
    public GetScholarModel getScholar(UUID id) {
        log.info("Class {} method getScholar", this.getClass().getName());

        ScholarEntity scholarEntity = springAccountRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Bolsista não encontrado com id " + id));
        log.info("ScholarEntity {}", scholarEntity);

        GetScholarModel getScholarModel = accountInfrastructureMapper.fromScholarEntityToGetScholarModel(scholarEntity);
        log.info("GetScholarModel {}", getScholarModel);

        return getScholarModel;
    }

    @Override
    public List<GetScholarModel> getScholars() {
        log.info("Class {} method getScholars", this.getClass().getName());

        List<ScholarEntity> scholarEntities = springAccountRepository.findAll();
        log.info("ScholarEntity {}", scholarEntities);

        List<GetScholarModel> models = scholarEntities.stream()
                .map(accountInfrastructureMapper::fromScholarEntityToGetScholarModel)
                .collect(Collectors.toList());
        log.info("List<GetScholarModel> {}", models);

        return models;
    }

}

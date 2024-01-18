package com.scholarshipholders.infrastructure.repository.adapter;


import com.scholarshipholders.core.exception.NotFoundException;
import com.scholarshipholders.core.model.CreateScholarModel;
import com.scholarshipholders.core.model.GetScholarModel;
import com.scholarshipholders.core.model.UpdateScholarModel;
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

    private static final String SCHOLAR_ENTITY_LOG = "ScholarEntity {}";
    private final ISpringScholarRepositoryAdapter springScholarRepository;
    private final IScholarInfrastructureMapper scholarInfrastructureMapper;


    @Override
    public GetScholarModel getScholar(UUID id) {
        log.info("Class {} method getScholar", this.getClass().getName());

        ScholarEntity scholarEntity = springScholarRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Bolsista não encontrado com id " + id));
        log.info(SCHOLAR_ENTITY_LOG, scholarEntity);

        GetScholarModel getScholarModel = scholarInfrastructureMapper.fromScholarEntityToGetScholarModel(scholarEntity);
        log.info("GetScholarModel {}", getScholarModel);

        return getScholarModel;
    }

    @Override
    public List<GetScholarModel> getScholars() {
        log.info("Class {} method getScholars", this.getClass().getName());

        List<ScholarEntity> scholarEntities = springScholarRepository.findAll();
        log.info(SCHOLAR_ENTITY_LOG, scholarEntities);

        List<GetScholarModel> models = scholarEntities.stream()
                .map(scholarInfrastructureMapper::fromScholarEntityToGetScholarModel)
                .collect(Collectors.toList());
        log.info("List<GetScholarModel> {}", models);

        return models;
    }

    @Override
    public void createScholar(CreateScholarModel createScholarModel) {
        log.info("Class {} method createScholar", this.getClass().getName());

        ScholarEntity entity = scholarInfrastructureMapper.fromCreateScholarModelToScholarEntity(createScholarModel);
        log.info(SCHOLAR_ENTITY_LOG, createScholarModel);

        springScholarRepository.save(entity);
    }

    @Override
    public UpdateScholarModel updateScholar(UpdateScholarModel updateScholarModel) {
        log.info("Class {} method updateScholar", this.getClass().getName());

        ScholarEntity entity = scholarInfrastructureMapper.fromUpdateScholarModelToScholarEntity(updateScholarModel);
        ScholarEntity scholarEntity = springScholarRepository.save(entity);
        log.info("Scholar entity updated {}", scholarEntity);

        UpdateScholarModel updateScholarModelUpdated = scholarInfrastructureMapper.fromScholarEntityToUpdateScholarModel(scholarEntity);
        log.info("UpdateScholarModel {}", updateScholarModelUpdated);

        return updateScholarModelUpdated;
    }

    @Override
    public void deleteScholar(GetScholarModel getScholarModel) {
        log.info("Class {} method deleteScholar", this.getClass().getName());

        ScholarEntity scholarEntity = scholarInfrastructureMapper.fromGetScholarModelTScholarEntity(getScholarModel);
        log.info("ScholarEntity {}", scholarEntity);

        springScholarRepository.delete(scholarEntity);

    }

}

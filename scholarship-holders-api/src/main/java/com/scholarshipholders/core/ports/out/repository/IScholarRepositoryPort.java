package com.scholarshipholders.core.ports.out.repository;


import com.scholarshipholders.core.model.scholar.CreateScholarModel;
import com.scholarshipholders.core.model.scholar.GetScholarModel;
import com.scholarshipholders.core.model.scholar.UpdateScholarModel;
import com.scholarshipholders.infrastructure.entity.scholar.ScholarEntity;
import com.scholarshipholders.infrastructure.entity.scholar.enums.DocumentTypeEnum;

import java.util.List;
import java.util.UUID;

public interface IScholarRepositoryPort {

    GetScholarModel getScholar(UUID id);

    List<GetScholarModel> getScholars();

    void createScholar(CreateScholarModel createScholarModel);

    UpdateScholarModel updateScholar(UpdateScholarModel updateScholarModel);

    void deleteScholar(GetScholarModel entity);

    Boolean existsByDocumentAndDocumentType(String document, DocumentTypeEnum documentType);

    ScholarEntity getScholarEntity(UUID scholarId);

}

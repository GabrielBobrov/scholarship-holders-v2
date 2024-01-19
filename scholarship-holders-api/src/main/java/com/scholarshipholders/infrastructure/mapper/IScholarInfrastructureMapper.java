package com.scholarshipholders.infrastructure.mapper;


import com.scholarshipholders.core.model.scholar.CreateScholarModel;
import com.scholarshipholders.core.model.scholar.GetScholarModel;
import com.scholarshipholders.core.model.scholar.UpdateScholarModel;
import com.scholarshipholders.infrastructure.entity.scholar.ScholarEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IScholarInfrastructureMapper {

    GetScholarModel fromScholarEntityToGetScholarModel(ScholarEntity scholarEntity);

    ScholarEntity fromGetScholarModelTScholarEntity(GetScholarModel getScholarModel);

    ScholarEntity fromCreateScholarModelToScholarEntity(CreateScholarModel createScholarModel);

    ScholarEntity fromUpdateScholarModelToScholarEntity(UpdateScholarModel updateScholarModel);

    UpdateScholarModel fromScholarEntityToUpdateScholarModel(ScholarEntity scholarEntity);


}

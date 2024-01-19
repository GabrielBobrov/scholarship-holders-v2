package com.scholarshipholders.infrastructure.mapper;


import com.scholarshipholders.core.model.CreateScholarModel;
import com.scholarshipholders.core.model.GetScholarModel;
import com.scholarshipholders.core.model.UpdateScholarModel;
import com.scholarshipholders.infrastructure.entity.ScholarEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

import java.time.LocalDate;
import java.time.OffsetDateTime;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IScholarInfrastructureMapper {

    GetScholarModel fromScholarEntityToGetScholarModel(ScholarEntity scholarEntity);

    ScholarEntity fromGetScholarModelTScholarEntity(GetScholarModel getScholarModel);

    ScholarEntity fromCreateScholarModelToScholarEntity(CreateScholarModel createScholarModel);

    ScholarEntity fromUpdateScholarModelToScholarEntity(UpdateScholarModel updateScholarModel);

    UpdateScholarModel fromScholarEntityToUpdateScholarModel(ScholarEntity scholarEntity);

    @Named("map")
    default LocalDate map(OffsetDateTime value) {
        return value != null ? value.toLocalDate() : null;
    }

}

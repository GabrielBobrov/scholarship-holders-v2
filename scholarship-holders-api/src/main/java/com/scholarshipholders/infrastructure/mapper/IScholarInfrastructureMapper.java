package com.scholarshipholders.infrastructure.mapper;


import com.scholarshipholders.core.model.GetScholarModel;
import com.scholarshipholders.infrastructure.entity.ScholarEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

import java.time.LocalDate;
import java.time.OffsetDateTime;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IScholarInfrastructureMapper {

    @Mapping(source = "createdAt", target = "createdAt", qualifiedByName = "map")
    GetScholarModel fromScholarEntityToGetScholarModel(ScholarEntity scholarEntity);

    @Named("map")
    default LocalDate map(OffsetDateTime value) {
        return value != null ? value.toLocalDate() : null;
    }

}

package com.scholarshipholders.entrypoint.mapper;


import com.scholarshipholders.core.model.GetScholarModel;
import com.scholarshipholders.entrypoint.dto.response.GetScholarResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IScholarEntrypointMapper {
    GetScholarResponseDTO fromGetScholarModelToGetScholarResponseDTO(GetScholarModel getScholarModel);

}

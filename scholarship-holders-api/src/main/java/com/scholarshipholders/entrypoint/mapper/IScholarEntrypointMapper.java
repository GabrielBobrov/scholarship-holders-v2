package com.scholarshipholders.entrypoint.mapper;


import com.scholarshipholders.core.model.CreateScholarModel;
import com.scholarshipholders.core.model.GetScholarModel;
import com.scholarshipholders.entrypoint.dto.request.CreateScholarRequestDTO;
import com.scholarshipholders.entrypoint.dto.response.GetScholarResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IScholarEntrypointMapper {
    GetScholarResponseDTO fromGetScholarModelToGetScholarResponseDTO(GetScholarModel getScholarModel);

    List<GetScholarResponseDTO> fromListGetScholarModelToListGetScholarResponseDTO(List<GetScholarModel> getScholarModel);

    CreateScholarModel fromCreateScholarRequestDTOToCreateScholarModel(CreateScholarRequestDTO createScholarRequestDTO);

}

package com.scholarshipholders.entrypoint.mapper;


import com.scholarshipholders.core.model.scholar.CreateScholarModel;
import com.scholarshipholders.core.model.scholar.GetScholarModel;
import com.scholarshipholders.core.model.scholar.UpdateScholarModel;
import com.scholarshipholders.entrypoint.dto.request.scholar.CreateScholarRequestDTO;
import com.scholarshipholders.entrypoint.dto.request.scholar.UpdateScholarRequestDTO;
import com.scholarshipholders.entrypoint.dto.response.scholar.GetScholarResponseDTO;
import com.scholarshipholders.entrypoint.dto.response.scholar.UpdateScholarResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IScholarEntrypointMapper {
    GetScholarResponseDTO fromGetScholarModelToGetScholarResponseDTO(GetScholarModel getScholarModel);

    List<GetScholarResponseDTO> fromListGetScholarModelToListGetScholarResponseDTO(List<GetScholarModel> getScholarModel);

    CreateScholarModel fromCreateScholarRequestDTOToCreateScholarModel(CreateScholarRequestDTO createScholarRequestDTO);

    UpdateScholarModel fromUpdateScholarRequestDTOToUpdateScholarModel(UpdateScholarRequestDTO updateScholarRequestDTO);

    UpdateScholarResponseDTO fromUpdateScholarModelToUpdateScholarResponseDTO(UpdateScholarModel updateScholarRequestDTO);

}

package com.scholarshipholders.entrypoint.controller;


import com.scholarshipholders.core.model.scholar.CreateScholarModel;
import com.scholarshipholders.core.model.scholar.GetScholarModel;
import com.scholarshipholders.core.model.scholar.UpdateScholarModel;
import com.scholarshipholders.core.ports.in.service.IScholarServicePort;
import com.scholarshipholders.entrypoint.UrlConstant;
import com.scholarshipholders.entrypoint.dto.request.scholar.CreateScholarRequestDTO;
import com.scholarshipholders.entrypoint.dto.request.scholar.UpdateScholarRequestDTO;
import com.scholarshipholders.entrypoint.dto.response.GetScholarResponseDTO;
import com.scholarshipholders.entrypoint.dto.response.UpdateScholarResponseDTO;
import com.scholarshipholders.entrypoint.mapper.IScholarEntrypointMapper;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping(value = UrlConstant.SCHOLAR_URI)
public class ScholarController {

    private final IScholarServicePort scholarServicePort;
    private final IScholarEntrypointMapper scholarEntrypointMapper;


    @GetMapping("/{scholarId}")
    @ResponseStatus(HttpStatus.OK)
    public GetScholarResponseDTO getScholar(@PathVariable UUID scholarId) {
        log.info("Class {} method getScholar", this.getClass().getName());

        GetScholarModel getScholarModel = scholarServicePort.getScholar(scholarId);
        log.info("GetScholarModel {}", getScholarModel);

        GetScholarResponseDTO responseDTO = scholarEntrypointMapper.fromGetScholarModelToGetScholarResponseDTO(getScholarModel);
        log.info("GetScholarResponseDTO {}", responseDTO);

        return responseDTO;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<GetScholarResponseDTO> getScholars() {
        log.info("Class {} method getScholars", this.getClass().getName());

        List<GetScholarModel> getScholarModel = scholarServicePort.getScholars();
        log.info("List<GetScholarModel> {}", getScholarModel);

        List<GetScholarResponseDTO> responseDTO = scholarEntrypointMapper.fromListGetScholarModelToListGetScholarResponseDTO(getScholarModel);
        log.info("List<GetScholarResponseDTO> {}", responseDTO);

        return responseDTO;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createScholar(@RequestBody @Valid CreateScholarRequestDTO createScholarRequestDTO) {
        log.info("Class {} method createScholar", this.getClass().getName());
        log.info("CreateScholarRequestDTO {}", createScholarRequestDTO);

        CreateScholarModel createScholarModel = scholarEntrypointMapper.fromCreateScholarRequestDTOToCreateScholarModel(createScholarRequestDTO);
        scholarServicePort.createScholar(createScholarModel);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public UpdateScholarResponseDTO updateScholar(@RequestBody @Valid UpdateScholarRequestDTO updateScholarRequestDTO) {
        log.info("Class {} method updateScholar", this.getClass().getName());
        log.info("UpdateScholarRequestDTO {}", updateScholarRequestDTO);

        UpdateScholarModel updateScholarModel = scholarEntrypointMapper.fromUpdateScholarRequestDTOToUpdateScholarModel(updateScholarRequestDTO);
        UpdateScholarModel scholarModel = scholarServicePort.updateScholar(updateScholarModel);

        UpdateScholarResponseDTO updateScholarResponseDTO = scholarEntrypointMapper.fromUpdateScholarModelToUpdateScholarResponseDTO(scholarModel);
        log.info("UpdateScholarResponseDTO {}", updateScholarResponseDTO);

        return updateScholarResponseDTO;
    }

    @DeleteMapping("/{scholarId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteScholar(@PathVariable UUID scholarId) {
        log.info("Class {} method deleteScholar", this.getClass().getName());

        scholarServicePort.deleteScholar(scholarId);
    }


}




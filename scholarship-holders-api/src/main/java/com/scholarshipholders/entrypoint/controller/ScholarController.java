package com.scholarshipholders.entrypoint.controller;


import com.scholarshipholders.core.model.GetScholarModel;
import com.scholarshipholders.core.ports.in.service.IScholarServicePort;
import com.scholarshipholders.entrypoint.UrlConstant;
import com.scholarshipholders.entrypoint.dto.response.GetScholarResponseDTO;
import com.scholarshipholders.entrypoint.mapper.IScholarEntrypointMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping(value = UrlConstant.SCHOLAR_URI)
public class ScholarController {

    private final IScholarServicePort accountServicePort;
    private final IScholarEntrypointMapper accountEntrypointMapper;


    @GetMapping("/{scholarId}")
    @ResponseStatus(HttpStatus.OK)
    public GetScholarResponseDTO getScholar(@PathVariable UUID scholarId) {
        log.info("Class {} method getScholar", this.getClass().getName());

        GetScholarModel scholarModel = accountServicePort.getScholar(scholarId);
        log.info("GetScholarModel {}", scholarModel);

        GetScholarResponseDTO responseDTO = accountEntrypointMapper.fromGetScholarModelToGetScholarResponseDTO(scholarModel);
        log.info("GetScholarResponseDTO {}", responseDTO);

        return responseDTO;
    }


}




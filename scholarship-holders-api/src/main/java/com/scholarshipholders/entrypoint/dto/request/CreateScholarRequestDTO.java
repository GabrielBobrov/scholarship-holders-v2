package com.scholarshipholders.entrypoint.dto.request;

import com.scholarshipholders.infrastructure.entity.enums.DocumentTypeEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CreateScholarRequestDTO {

    @NotBlank
    private String fullName;

    @NotBlank
    private String document;

    @NotNull
    private DocumentTypeEnum documentType;

    @NotNull
    private Integer bankCode;

    @NotNull
    private Integer bankAgency;

    @NotNull
    private Long accountNumber;

}

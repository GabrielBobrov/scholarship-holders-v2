package com.scholarshipholders.entrypoint.dto.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.scholarshipholders.infrastructure.entity.enums.DocumentTypeEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.LowerCamelCaseStrategy.class)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class UpdateScholarRequestDTO {

    @NotNull
    private UUID id;
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

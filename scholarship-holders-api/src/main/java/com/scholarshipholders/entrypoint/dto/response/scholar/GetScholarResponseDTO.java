package com.scholarshipholders.entrypoint.dto.response.scholar;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.scholarshipholders.infrastructure.entity.scholar.enums.DocumentTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.LowerCamelCaseStrategy.class)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class GetScholarResponseDTO {


    private UUID id;
    private String fullName;
    private String document;
    private DocumentTypeEnum documentType;
    private Integer bankCode;
    private Integer bankAgency;
    private Long accountNumber;
    private Boolean hasRestrictedPayment;
    private LocalDate createdAt;
}

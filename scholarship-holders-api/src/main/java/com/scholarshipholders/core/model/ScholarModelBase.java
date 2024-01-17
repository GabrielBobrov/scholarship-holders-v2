package com.scholarshipholders.core.model;

import com.scholarshipholders.infrastructure.entity.enums.DocumentTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class ScholarModelBase {

    private String fullName;
    private DocumentTypeEnum documentType;
    private String document;
    private Integer bankCode;
    private Integer bankAgency;
    private Long accountNumber;


}

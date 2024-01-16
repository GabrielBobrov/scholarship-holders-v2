package com.scholarshipholders.core.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@Builder
public class GetScholarModel {

    private UUID id;
    private String fullName;
    private String document;
    private Integer bankCode;
    private Integer bankAgency;
    private Long accountNumber;
    private LocalDate createdAt;


}

package com.scholarshipholders.core.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

@Getter
@Setter
@SuperBuilder(toBuilder = true)
public class UpdateScholarModel extends ScholarModelBase {
    private UUID id;


}

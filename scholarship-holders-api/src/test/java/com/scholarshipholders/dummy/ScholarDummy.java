package com.scholarshipholders.dummy;

import com.scholarshipholders.core.model.CreateScholarModel;
import com.scholarshipholders.core.model.GetScholarModel;
import com.scholarshipholders.core.model.UpdateScholarModel;
import com.scholarshipholders.infrastructure.entity.ScholarEntity;

import java.util.UUID;

public class ScholarDummy {

    public static ScholarEntity.ScholarEntityBuilder scholarEntityBuilder() {
        return ScholarEntity.builder()
                .id(UUID.randomUUID())
                .fullName("John Doe");
    }

    public static GetScholarModel.GetScholarModelBuilder getScholarModelBuilder() {
        return GetScholarModel.builder()
                .id(UUID.randomUUID())
                .fullName("John Doe");
    }

    public static CreateScholarModel.CreateScholarModelBuilder createScholarModelBuilder() {
        return CreateScholarModel.builder()
                .fullName("John Doe");
    }

    public static UpdateScholarModel.UpdateScholarModelBuilder updateScholarModelBuilder() {
        return UpdateScholarModel.builder()
                .id(UUID.randomUUID())
                .fullName("John Doe");
    }
}

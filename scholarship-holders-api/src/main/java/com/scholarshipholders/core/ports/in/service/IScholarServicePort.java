package com.scholarshipholders.core.ports.in.service;



import com.scholarshipholders.core.model.scholar.CreateScholarModel;
import com.scholarshipholders.core.model.scholar.GetScholarModel;
import com.scholarshipholders.core.model.scholar.UpdateScholarModel;

import java.util.List;
import java.util.UUID;

public interface IScholarServicePort {

    GetScholarModel getScholar(UUID id);

    List<GetScholarModel> getScholars();

    void createScholar(CreateScholarModel createScholarModel);

    UpdateScholarModel updateScholar(UpdateScholarModel updateScholarModel);

    void deleteScholar(UUID id);

}



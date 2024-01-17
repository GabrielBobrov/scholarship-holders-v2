package com.scholarshipholders.core.ports.in.service;



import com.scholarshipholders.core.model.CreateScholarModel;
import com.scholarshipholders.core.model.GetScholarModel;
import com.scholarshipholders.core.model.UpdateScholarModel;

import java.util.List;
import java.util.UUID;

public interface IScholarServicePort {

    GetScholarModel getScholar(UUID id);

    List<GetScholarModel> getScholars();

    void createScholar(CreateScholarModel createScholarModel);

    UpdateScholarModel updateScholar(UpdateScholarModel updateScholarModel);

}



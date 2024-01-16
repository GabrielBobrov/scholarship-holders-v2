package com.scholarshipholders.core.ports.in.service;



import com.scholarshipholders.core.model.GetScholarModel;

import java.util.UUID;

public interface IScholarServicePort {

    GetScholarModel getScholar(UUID id);
}



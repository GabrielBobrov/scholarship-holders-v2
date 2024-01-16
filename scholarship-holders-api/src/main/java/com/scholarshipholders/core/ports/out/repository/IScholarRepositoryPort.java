package com.scholarshipholders.core.ports.out.repository;


import com.scholarshipholders.core.model.GetScholarModel;

import java.util.UUID;

public interface IScholarRepositoryPort {

    GetScholarModel getScholar(UUID id);


}

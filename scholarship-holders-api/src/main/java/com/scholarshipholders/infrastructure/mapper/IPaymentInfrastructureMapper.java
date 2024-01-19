package com.scholarshipholders.infrastructure.mapper;


import com.scholarshipholders.core.model.scholar.CreateScholarModel;
import com.scholarshipholders.core.model.scholar.GetScholarModel;
import com.scholarshipholders.core.model.scholar.UpdateScholarModel;
import com.scholarshipholders.infrastructure.entity.payment.PaymentEntity;
import com.scholarshipholders.infrastructure.entity.scholar.ScholarEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IPaymentInfrastructureMapper {

    @Mapping(target = "scholar", source = "scholar")
    PaymentEntity toPaymentEntity(CreateScholarModel createScholarModel, ScholarEntity scholar);



}

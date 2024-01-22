package com.scholarshipholders.infrastructure.mapper;


import com.scholarshipholders.core.model.payment.GetPaymentModel;
import com.scholarshipholders.infrastructure.entity.payment.PaymentEntity;
import com.scholarshipholders.infrastructure.entity.scholar.ScholarEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IPaymentInfrastructureMapper {

    @Mapping(target = "scholar", source = "scholar")
    @Mapping(target = "id", source = "paymentEntity.id")
    GetPaymentModel toGetPaymentModel(PaymentEntity paymentEntity, ScholarEntity scholar);

    GetPaymentModel toGetPaymentModel(PaymentEntity paymentEntity);



}

package com.scholarshipholders.entrypoint.mapper;


import com.scholarshipholders.core.model.payment.CreatePaymentModel;
import com.scholarshipholders.core.model.payment.GetPaymentModel;
import com.scholarshipholders.entrypoint.dto.request.payment.CreatePaymentRequestDTO;
import com.scholarshipholders.entrypoint.dto.response.payment.GetPaymentResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IPaymentEntrypointMapper {
    CreatePaymentModel fromCreatePaymentRequestDTOToCreatePaymentModel(CreatePaymentRequestDTO createPaymentRequestDTO);

    List<GetPaymentResponseDTO> fromListGetPaymentModelToListGetPaymentResponseDTO(List<GetPaymentModel> getPaymentModel);

}

package com.scholarshipholders.entrypoint.mapper;


import com.scholarshipholders.core.model.payment.CreatePaymentModel;
import com.scholarshipholders.core.model.scholar.CreateScholarModel;
import com.scholarshipholders.core.model.scholar.GetScholarModel;
import com.scholarshipholders.core.model.scholar.UpdateScholarModel;
import com.scholarshipholders.entrypoint.dto.request.payment.CreatePaymentRequestDTO;
import com.scholarshipholders.entrypoint.dto.request.scholar.CreateScholarRequestDTO;
import com.scholarshipholders.entrypoint.dto.request.scholar.UpdateScholarRequestDTO;
import com.scholarshipholders.entrypoint.dto.response.GetScholarResponseDTO;
import com.scholarshipholders.entrypoint.dto.response.UpdateScholarResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IPaymentEntrypointMapper {
    CreatePaymentModel fromCreatePaymentRequestDTOToCreatePaymentModel(CreatePaymentRequestDTO createPaymentRequestDTO);

}

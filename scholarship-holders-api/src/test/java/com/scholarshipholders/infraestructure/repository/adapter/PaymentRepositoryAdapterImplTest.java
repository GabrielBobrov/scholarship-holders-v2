package com.scholarshipholders.infraestructure.repository.adapter;

import com.scholarshipholders.core.model.payment.CreatePaymentModel;
import com.scholarshipholders.core.model.payment.GetPaymentModel;
import com.scholarshipholders.core.ports.out.repository.IScholarRepositoryPort;
import com.scholarshipholders.dummy.PaymentDummy;
import com.scholarshipholders.dummy.ScholarDummy;
import com.scholarshipholders.infrastructure.entity.payment.PaymentEntity;
import com.scholarshipholders.infrastructure.entity.payment.enums.PaymentStatusEnum;
import com.scholarshipholders.infrastructure.entity.scholar.ScholarEntity;
import com.scholarshipholders.infrastructure.mapper.IPaymentInfrastructureMapper;
import com.scholarshipholders.infrastructure.repository.adapter.payment.ISpringPaymentRepositoryAdapter;
import com.scholarshipholders.infrastructure.repository.adapter.payment.PaymentRepositoryAdapterImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PaymentRepositoryAdapterImplTest {
    @Mock
    private ISpringPaymentRepositoryAdapter springPaymentRepositoryAdapter;

    @Mock
    private IPaymentInfrastructureMapper paymentInfrastructureMapper;

    @Mock
    private IScholarRepositoryPort scholarRepositoryPort;

    @InjectMocks
    private PaymentRepositoryAdapterImpl paymentRepositoryAdapter;

    @Test
    void testCreatePayment() {
        CreatePaymentModel createPaymentModel = PaymentDummy.createPaymentModelBuilder().build();

        ScholarEntity scholarEntity = ScholarDummy.scholarEntityBuilder().build();

        when(scholarRepositoryPort.getScholarEntity(any(UUID.class))).thenReturn(scholarEntity);

        paymentRepositoryAdapter.createPayment(createPaymentModel);

        verify(springPaymentRepositoryAdapter, times(1)).save(any(PaymentEntity.class));
    }

    @Test
    void testGetPayments() {
        // Arrange
        UUID scholarId = UUID.randomUUID();
        ScholarEntity scholarEntity = ScholarDummy.scholarEntityBuilder().build();
        List<PaymentEntity> paymentEntities = Collections.singletonList(PaymentDummy.paymentEntityBuilder().build());
        List<GetPaymentModel> expectedPaymentModels = Collections.singletonList(PaymentDummy.getPaymentModelBuilder().build());

        when(scholarRepositoryPort.getScholarEntity(scholarId)).thenReturn(scholarEntity);
        when(springPaymentRepositoryAdapter.findByScholar(scholarEntity)).thenReturn(paymentEntities);
        when(paymentInfrastructureMapper.toGetPaymentModel(any(PaymentEntity.class), eq(scholarEntity)))
                .thenReturn(expectedPaymentModels.get(0));

        // Act
        List<GetPaymentModel> actualPaymentModels = paymentRepositoryAdapter.getPayments(scholarId);

        // Assert
        assertEquals(expectedPaymentModels, actualPaymentModels);
    }

    @Test
    void testFindPaymentEntity() {
        // Arrange
        UUID paymentId = UUID.randomUUID();
        ScholarEntity scholarEntity = ScholarDummy.scholarEntityBuilder().build();
        PaymentEntity paymentEntity = PaymentDummy.paymentEntityBuilder().build();

        when(springPaymentRepositoryAdapter.findByIdAndScholar(paymentId, scholarEntity))
                .thenReturn(Optional.of(paymentEntity));

        // Act
        PaymentEntity actualPaymentEntity = paymentRepositoryAdapter.findPaymentEntity(paymentId, scholarEntity);

        // Assert
        assertEquals(paymentEntity, actualPaymentEntity);
    }

    @Test
    void testUpdatePaymentStatus() {
        // Arrange
        PaymentEntity paymentEntity = PaymentDummy.paymentEntityBuilder().build();
        PaymentStatusEnum newStatus = PaymentStatusEnum.PAID;

        // Act
        paymentRepositoryAdapter.updatePaymentStatus(paymentEntity, newStatus);

        // Assert
        verify(springPaymentRepositoryAdapter, times(1)).save(paymentEntity);
        assertEquals(newStatus, paymentEntity.getPaymentStatus());
    }

    @Test
    void testDeletePayment() {
        // Arrange
        UUID scholarId = UUID.randomUUID();
        UUID paymentId = UUID.randomUUID();

        // Act
        paymentRepositoryAdapter.deletePayment(scholarId, paymentId);

        // Assert
        verify(springPaymentRepositoryAdapter, times(1)).deleteByIdAndScholarId(paymentId, scholarId);
    }




}

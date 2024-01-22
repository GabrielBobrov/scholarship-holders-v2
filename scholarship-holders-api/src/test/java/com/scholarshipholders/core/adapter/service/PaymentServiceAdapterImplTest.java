package com.scholarshipholders.core.adapter.service;

import com.scholarshipholders.core.exception.BusinessException;
import com.scholarshipholders.core.model.payment.CreatePaymentModel;
import com.scholarshipholders.core.model.payment.UpdatePaymentModel;
import com.scholarshipholders.core.ports.out.repository.IPaymentRepositoryPort;
import com.scholarshipholders.core.ports.out.repository.IScholarRepositoryPort;
import com.scholarshipholders.dummy.PaymentDummy;
import com.scholarshipholders.dummy.ScholarDummy;
import com.scholarshipholders.infrastructure.entity.payment.PaymentEntity;
import com.scholarshipholders.infrastructure.entity.payment.enums.PaymentStatusEnum;
import com.scholarshipholders.infrastructure.entity.scholar.ScholarEntity;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PaymentServiceAdapterImplTest {

    @Mock
    private IPaymentRepositoryPort paymentRepositoryPort;

    @Mock
    private IScholarRepositoryPort scholarRepositoryPort;

    @InjectMocks
    private PaymentServiceAdapterImpl paymentServiceAdapter;

    @Test
    void testCreatePayment() {
        CreatePaymentModel createPaymentModel = PaymentDummy.createPaymentModelBuilder().build();
        paymentServiceAdapter.createPayment(createPaymentModel);
        verify(paymentRepositoryPort, times(1)).createPayment(createPaymentModel);
    }

    @Test
    void testGetPayments() {
        UUID scholarId = UUID.randomUUID();
        paymentServiceAdapter.getPayments(scholarId);
        verify(paymentRepositoryPort, times(1)).getPayments(scholarId);
    }

    @Test
    void testUpdatePaymentStatus() {
        UpdatePaymentModel updatePaymentModel = PaymentDummy.updatePaymentModelBuilder().build();
        ScholarEntity scholarEntity = ScholarDummy.scholarEntityBuilder().build();
        PaymentEntity paymentEntity = PaymentDummy.paymentEntityBuilder().build();

        when(scholarRepositoryPort.getScholarEntity(any(UUID.class))).thenReturn(scholarEntity);
        when(paymentRepositoryPort.findPaymentEntity(any(UUID.class), any(ScholarEntity.class))).thenReturn(paymentEntity);

        paymentServiceAdapter.updatePaymentStatus(updatePaymentModel);

        verify(paymentRepositoryPort, times(1)).updatePaymentStatus(any(PaymentEntity.class), any(PaymentStatusEnum.class));
    }

    @Test
    void testInvalidPaymentStatusUpdate() {
        UpdatePaymentModel updatePaymentModel = PaymentDummy.updatePaymentModelBuilder()
                .paymentStatus(PaymentStatusEnum.REQUESTED)
                .build();
        ScholarEntity scholarEntity = ScholarDummy.scholarEntityBuilder().build();
        PaymentEntity paymentEntity = PaymentDummy.paymentEntityBuilder()
                .paymentStatus(PaymentStatusEnum.PAID)
                .build();

        when(scholarRepositoryPort.getScholarEntity(any(UUID.class))).thenReturn(scholarEntity);
        when(paymentRepositoryPort.findPaymentEntity(any(UUID.class), any(ScholarEntity.class))).thenReturn(paymentEntity);

        assertThrows(BusinessException.class, () -> {
            paymentServiceAdapter.updatePaymentStatus(updatePaymentModel);
        });

        verify(paymentRepositoryPort, never()).updatePaymentStatus(any(PaymentEntity.class), any(PaymentStatusEnum.class));
    }


    @Test
    void testDeletePayment() {
        UUID scholarId = UUID.randomUUID();
        UUID paymentId = UUID.randomUUID();
        paymentServiceAdapter.deletePayment(scholarId, paymentId);
        verify(paymentRepositoryPort, times(1)).deletePayment(scholarId, paymentId);
    }
}

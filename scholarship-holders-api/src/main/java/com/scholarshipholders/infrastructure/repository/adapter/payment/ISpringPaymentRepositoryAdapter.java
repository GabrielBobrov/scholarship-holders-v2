package com.scholarshipholders.infrastructure.repository.adapter.payment;

import com.scholarshipholders.infrastructure.entity.payment.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ISpringPaymentRepositoryAdapter extends JpaRepository<PaymentEntity, UUID> {

}

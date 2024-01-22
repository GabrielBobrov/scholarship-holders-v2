package com.scholarshipholders.infrastructure.repository.adapter.payment;

import com.scholarshipholders.infrastructure.entity.payment.PaymentEntity;
import com.scholarshipholders.infrastructure.entity.scholar.ScholarEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ISpringPaymentRepositoryAdapter extends JpaRepository<PaymentEntity, UUID> {

    List<PaymentEntity> findByScholar(ScholarEntity scholar);

    Optional<PaymentEntity> findByIdAndScholar(UUID id, ScholarEntity scholar);

    void deleteByIdAndScholarId(UUID id, UUID scholarId);

}

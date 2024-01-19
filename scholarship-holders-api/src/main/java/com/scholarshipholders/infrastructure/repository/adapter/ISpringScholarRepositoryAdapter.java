package com.scholarshipholders.infrastructure.repository.adapter;

import com.scholarshipholders.infrastructure.entity.ScholarEntity;
import com.scholarshipholders.infrastructure.entity.enums.DocumentTypeEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ISpringScholarRepositoryAdapter extends JpaRepository<ScholarEntity, UUID> {

    Optional<ScholarEntity> findByDocumentAndDocumentType(String document, DocumentTypeEnum documentType);

}

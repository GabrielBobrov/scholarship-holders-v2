package com.scholarshipholders.infrastructure.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.OffsetDateTime;
import java.util.UUID;


@Entity(name = "tb_scholar")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ScholarEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "document")
    private String document;

    @Column(name = "bank_code")
    private Integer bankCode;

    @Column(name = "bank_agency")
    private Integer bankAgency;

    @Column(name = "account_number")
    private Long accountNumber;

    @CreationTimestamp
    @Column(name = "created_at")
    private OffsetDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private OffsetDateTime updatedAt;
}

package com.primaryfeed.entity;

import jakarta.persistence.*;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Data
@Entity
@Table(name = "beneficiaries")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Beneficiary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "beneficiary_id")
    private Integer beneficiaryId;

    @Column(name = "beneficiary_full_name", nullable = false)
    private String beneficiaryFullName;

    @Column(name = "household_size", nullable = false)
    private Integer householdSize;

    @Column(nullable = false)
    private String phone;

    @Column(unique = true)
    private String email;

    // 0=Ineligible, 1=Eligible
    @Column(name = "eligibility_status", nullable = false)
    private Byte eligibilityStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Address address;
}
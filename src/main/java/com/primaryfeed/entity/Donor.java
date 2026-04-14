package com.primaryfeed.entity;

import jakarta.persistence.*;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Data
@Entity
@Table(name = "donors")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Donor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "donor_id")
    private Integer donorId;

    @Column(name = "donor_name", nullable = false)
    private String donorName;

    // 0=Individual, 1=Organization
    @Column(name = "donor_type", nullable = false)
    private Byte donorType;

    @Column(unique = true)
    private String email;

    private String phone;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Address address;
}
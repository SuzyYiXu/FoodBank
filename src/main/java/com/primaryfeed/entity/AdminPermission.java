package com.primaryfeed.entity;

import jakarta.persistence.*;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Data
@Entity
@Table(name = "admin_permissions")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class AdminPermission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "permission_id")
    private Integer permissionId;

    @Column(name = "permission_type", nullable = false)
    private Byte permissionType;

    @Column(name = "permission_description", nullable = false)
    private String permissionDescription;
}
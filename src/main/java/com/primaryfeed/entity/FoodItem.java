package com.primaryfeed.entity;

import jakarta.persistence.*;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Data
@Entity
@Table(name = "food_items")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class FoodItem {
    @Id
    @Column(name = "sku", nullable = false, length = 45)
    private String sku;

    @Column(name = "food_name", nullable = false)
    private String foodName;

    @Column(name = "food_description", columnDefinition = "MEDIUMTEXT")
    private String foodDescription;

    @Column(name = "storage_condition")
    private String storageCondition;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private FoodCategory category;
}
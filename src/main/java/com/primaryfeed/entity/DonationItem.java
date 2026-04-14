package com.primaryfeed.entity;

import jakarta.persistence.*;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "donation_items")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class DonationItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "donation_item_id")
    private Integer donationItemId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "donation_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Donation donation;

    @Column(nullable = false)
    private Integer quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "food_sku", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private FoodItem foodItem;

    @Column(nullable = false)
    private String unit;

    @Column(name = "expiry_date", nullable = false)
    private LocalDateTime expiryDate;
}
package com.primaryfeed.entity;

import jakarta.persistence.*;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Entity
@Table(name = "volunteer_shifts")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class VolunteerShift {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shift_id")
    private Integer shiftId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "volunteer_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Volunteer volunteer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "branch_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private FoodBankBranch branch;

    @Column(name = "shift_date", nullable = false)
    private LocalDate shiftDate;

    @Column(name = "shift_time_start", nullable = false)
    private LocalTime shiftTimeStart;

    @Column(name = "shift_time_end", nullable = false)
    private LocalTime shiftTimeEnd;

    @Column(name = "shift_notes", columnDefinition = "MEDIUMTEXT")
    private String shiftNotes;
}
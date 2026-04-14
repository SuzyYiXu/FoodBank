package com.primaryfeed.repository;
import com.primaryfeed.entity.VolunteerShift;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface VolunteerShiftRepository extends JpaRepository<VolunteerShift, Integer> {
    List<VolunteerShift> findByVolunteer_VolunteerId(Integer volunteerId);
    List<VolunteerShift> findByBranch_BranchId(Integer branchId);
    List<VolunteerShift> findByShiftDate(LocalDate date);
}
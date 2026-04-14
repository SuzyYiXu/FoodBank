package com.primaryfeed.repository;
import com.primaryfeed.entity.Volunteer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface VolunteerRepository extends JpaRepository<Volunteer, Integer> {
    Optional<Volunteer> findByUser_UserId(Integer userId);
    Optional<Volunteer> findByUser_Email(String email);
}
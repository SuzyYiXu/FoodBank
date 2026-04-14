package com.primaryfeed.repository;
import com.primaryfeed.entity.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface StaffRepository extends JpaRepository<Staff, Integer> {
    Optional<Staff> findByUser_UserId(Integer userId);
    Optional<Staff> findByUser_Email(String email);
}
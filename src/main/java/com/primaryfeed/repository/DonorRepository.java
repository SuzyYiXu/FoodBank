package com.primaryfeed.repository;
import com.primaryfeed.entity.Donor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface DonorRepository extends JpaRepository<Donor, Integer> {
    Optional<Donor> findByEmail(String email);
}
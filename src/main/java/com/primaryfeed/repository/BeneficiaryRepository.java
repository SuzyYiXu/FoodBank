package com.primaryfeed.repository;
import com.primaryfeed.entity.Beneficiary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface BeneficiaryRepository extends JpaRepository<Beneficiary, Integer> {
    List<Beneficiary> findByEligibilityStatus(Byte status);
    List<Beneficiary> findByHouseholdSizeGreaterThanEqual(Integer size);
}